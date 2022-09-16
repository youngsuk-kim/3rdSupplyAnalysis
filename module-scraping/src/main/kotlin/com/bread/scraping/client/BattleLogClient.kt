package com.bread.scraping.client

import com.bread.scraping.dto.BattleLog
import com.bread.scraping.dto.BattleLogResponseDto
import com.bread.scraping.dto.DummyRequestDto
import com.bread.scraping.service.ApiService
import org.springframework.stereotype.Component

@Component
class BattleLogClient(
    private val apiService: ApiService<BattleLogResponseDto>,
    private val matchClient: MatchClient
) {
    fun fetchBattleLog(userId: Int): MutableList<BattleLog> {
        val headers = setBattleLogHeaders()
        val gameListId = matchClient.fetchGameListId(userId)
        val battleLogList = mutableListOf<BattleLog>()
        for (i in 0..gameListId.lastIndex) {
            if (i == 10) {
                break
            }
            try {
                val result = apiService.post(
                    "https://barracks.sa.nexon.com/api/BattleLog/GetBattleLog/${gameListId[i]}/${userId}",
                    headers,
                    DummyRequestDto(),
                    BattleLogResponseDto::class.java
                )
                println(result.body!!.battleLog!!)
                battleLogList.addAll(result.body!!.battleLog!!)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return battleLogList
    }

}

package com.bread.scraping.client

import com.bread.scraping.dto.BattleLog
import com.bread.scraping.service.ApiService
import com.bread.scraping.dto.BattleLogResponseDto
import com.bread.scraping.dto.DummyRequestDto
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpClientErrorException

@Component
class BattleLogClient(
    private val apiService: ApiService<BattleLogResponseDto>,
    private val matchClient: MatchClient
) {
    fun fetchBattleLog(userId: Int) {
        val headers = setBattleLogHeaders()

        val gameListId = matchClient.fetchGameListId(userId)
        val battleLogList = mutableListOf<BattleLog>()
        for (gameId in gameListId) {
            try {
                val result = apiService.post(
                    "https://barracks.sa.nexon.com/api/BattleLog/GetBattleLog/${gameId}/${userId}",
                    headers,
                    DummyRequestDto(),
                    BattleLogResponseDto::class.java
                )
                println(result.body!!.battleLog!!)
                battleLogList.addAll(result.body!!.battleLog!!)
            } catch (e: HttpClientErrorException) {
                println(e.printStackTrace())
                Thread.sleep(10000)
            }
        }
    }

}

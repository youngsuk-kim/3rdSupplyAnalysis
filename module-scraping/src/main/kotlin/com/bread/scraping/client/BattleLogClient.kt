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
    fun fetchBattleLog() {
        val headers = setBattleLogHeaders()

        val gameListId = matchClient.fetchGameListId()
        val battleLogList = mutableListOf<BattleLog>()
        for (id in gameListId) {
            try {
                val result = apiService.post(
                    "https://barracks.sa.nexon.com/api/BattleLog/GetBattleLog/${id}/2047101791",
                    headers,
                    DummyRequestDto(),
                    BattleLogResponseDto::class.java
                )
                battleLogList.addAll(result.body!!.battleLog!!)
            } catch (e: HttpClientErrorException) {
                println(e.printStackTrace())
                Thread.sleep(60000)
            }
        }
    }

}

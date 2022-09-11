package com.bread.scraping.client

import com.bread.scraping.service.ApiService
import com.bread.scraping.dto.BattleLogResponseDto
import com.bread.scraping.dto.BattleRequestDto
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
        for (id in gameListId) {
            try {
                val result = apiService.post(
                    "https://barracks.sa.nexon.com/api/BattleLog/GetBattleLog/${id}/2047101791",
                    headers,
                    BattleRequestDto(),
                    BattleLogResponseDto::class.java
                )
            } catch (e: HttpClientErrorException) {
                println(e.printStackTrace())
                Thread.sleep(60000)
            }
        }
    }

}

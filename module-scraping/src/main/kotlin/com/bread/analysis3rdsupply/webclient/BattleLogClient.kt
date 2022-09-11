package com.bread.analysis3rdsupply.webclient

import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap

@Component
class BattleLogClient(
    private val apiService: ApiService<BattleLogResponseDto>,
    private val matchClient: MatchClient
) {

    fun fetchBattleLog() {
        val multiValueMap = LinkedMultiValueMap<String, String>()
        multiValueMap["Accept"] = "application/json, text/plain, */*"
        multiValueMap["Content-Type"] = "application/json;charset=UTF-8"
        multiValueMap["User-Agent"] =
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36"
        multiValueMap["Origin"] = "https://barracks.sa.nexon.com"
        multiValueMap["Accept-Encoding"] = "gzip, deflate, br"
        multiValueMap["Content-Length"] = "0"

        val gameListId = matchClient.fetchGameListId()

        for (id in gameListId) {
            val result = apiService.post(
                "https://barracks.sa.nexon.com/api/BattleLog/GetBattleLog/${id}/2047101791",
                multiValueMap,
                BattleRequestDto(),
                BattleLogResponseDto::class.java
            )

            println(result.body)
        }
    }
}

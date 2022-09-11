package com.bread.analysis3rdsupply.webclient

import com.fasterxml.jackson.databind.exc.InvalidFormatException
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap

@Component
class MatchClient(
    private val apiService: ApiService<GetMatchListResponseDto>
) {

    fun fetchGameListId(): List<String?> {
        val multiValueMap = LinkedMultiValueMap<String, String>()
        multiValueMap["Accept"] = "application/json, text/plain, */*"
        multiValueMap["Content-Type"] = "application/json;charset=UTF-8"
        multiValueMap["User-Agent"] =
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36"
        multiValueMap["Referer"] = "https://barracks.sa.nexon.com/2047101791/match"
        multiValueMap["Cookie"] =
            "PCID=16628315223526161855208; _gid=GA1.2.1217584460.1662831522; SAIntroCheckNX=true; NXGID=822F20977F7BCD44C34E1F87B8B7C80F; NXPID=5C520292DE58C57EB9AA65B3A2B912BD; isCafe=false; _gcl_au=1.1.476126715.1662831523; _hjSessionUser_1327448=eyJpZCI6IjY0MmM0N2I1LTMwYTAtNWRlMC1iYmM2LWI5OTAxNTgzZmM1MCIsImNyZWF0ZWQiOjE2NjI4MzE1MjI1OTgsImV4aXN0aW5nIjp0cnVlfQ==; EGC=; A2SK=act:16628573087363643617; NXLW=SID=64A86E2A7C60D67C331DAD1A698BD96F&PTC=https:&DOM=sa.nexon.com&ID=&CP=; _ga_LGMJQSM7C7=GS1.1.1662855385.4.1.1662857311.0.0.0; _ga=GA1.2.142753167.1662831522; _gat_ADTeamTracker=1; _gat=1"
        multiValueMap["Origin"] = "https://barracks.sa.nexon.com"
        multiValueMap["Accept-Encoding"] = "gzip, deflate, br"
        multiValueMap["Content-Length"] = "90"

        val result = apiService.post(
            "https://barracks.sa.nexon.com/api/Match/GetMatchList/",
            multiValueMap,
            GetMatchListRequestDto(),
            GetMatchListResponseDto::class.java
        )

        var num = "0"
        var iteration = 0
        val resultList = mutableListOf<String?>()
        while (result.body != null) {
            try {

                val post = apiService.post(
                    "https://barracks.sa.nexon.com/api/Match/GetMatchList/",
                    multiValueMap,
                    GetMatchListRequestDto(seq_no = num.toLong()),
                    GetMatchListResponseDto::class.java
                )

                Thread.sleep(2000)

                num = post.body!!.message
                resultList.addAll(post.body!!.result
                    .filter { it.map_name.equals("제3보급창고") }
                    .filter { it.match_name.equals("클랜매치") }
                    .map { it.match_key })

                iteration++
            } catch (e: Exception) {
                break
            }
        }

        return resultList
    }

}

package com.bread.scraping.client

import com.bread.scraping.service.ApiService
import com.bread.scraping.dto.GetMatchListRequestDto
import com.bread.scraping.dto.GetMatchListResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.HttpClientErrorException

@Component
class MatchClient(
    private val apiService: ApiService<GetMatchListResponseDto>
) {
    fun fetchGameListId(userId: Int): List<String?> {
        val headers = setMatchHeaders()

        var num = "0"
        val resultList = mutableListOf<String?>()
        var post: ResponseEntity<GetMatchListResponseDto>

        while (true) {
            try {
                post = postMatchList(headers, num, userId)
                num = post.body!!.message
                resultList.addAll(post.body!!.result
                    .filter { it.map_name.equals("제3보급창고") }
                    .filter { it.match_name.equals("클랜매치") }
                    .map { it.match_key })
                println(num)
            } catch (e: HttpClientErrorException) {
                println(e.printStackTrace())
                Thread.sleep(10000)
            } catch (e: Exception) {
                println(e.printStackTrace())
                break
            }
        }

        println("사이즈 : ${resultList.size}")
        return resultList
    }

    private fun postMatchList(
        headers: LinkedMultiValueMap<String, String>,
        num: String,
        userId: Int
    ) = apiService.post(
        "https://barracks.sa.nexon.com/api/Match/GetMatchList/",
        headers,
        GetMatchListRequestDto(seq_no = num.toLong(), user_nexon_sn = userId.toString()),
        GetMatchListResponseDto::class.java
    )


}

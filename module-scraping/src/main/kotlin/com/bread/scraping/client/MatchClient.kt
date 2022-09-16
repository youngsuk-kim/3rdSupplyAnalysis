package com.bread.scraping.client

import com.bread.scraping.service.ApiService
import com.bread.scraping.dto.GetMatchListRequestDto
import com.bread.scraping.dto.GetMatchListResponseDto
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestClientException
import java.util.logging.Level
import java.util.logging.LogRecord
import java.util.logging.Logger

@Component
class MatchClient(
    private val apiService: ApiService<GetMatchListResponseDto>
) {

    val logger: Logger = Logger.getLogger(MatchClient::class.java.name)

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
            } catch (e: HttpMessageNotReadableException) {
                logger.log(LogRecord(Level.INFO, "gameId: ${num}번째 에서 크롤링이 종료되었습니다"))
                break
            } catch (e: RestClientException) {
                logger.log(LogRecord(Level.INFO, "gameId: ${num}번째 에서 크롤링이 종료되었습니다"))
                break
            } catch (e: InvalidFormatException) {
                logger.log(LogRecord(Level.INFO, "gameId: ${num}번째 에서 크롤링이 종료되었습니다"))
                break
            }
        }

        return resultList
    }

    private fun postMatchList(
        headers: LinkedMultiValueMap<String, String>,
        num: String,
        userId: Int
    ): ResponseEntity<GetMatchListResponseDto> {
        return try {
            requestMatchList(headers, num, userId)
        } catch (e: HttpClientErrorException.TooManyRequests) {
            requestMatchList(headers, num, userId)
        }
    }

    private fun requestMatchList(
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

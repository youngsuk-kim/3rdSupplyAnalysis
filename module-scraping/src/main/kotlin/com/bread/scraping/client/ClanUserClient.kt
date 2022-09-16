package com.bread.scraping.client

import com.bread.scraping.dto.ClanUserRequestDto
import com.bread.scraping.dto.ClanUserResponseDto
import com.bread.scraping.service.ApiService
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClientException

@Component
class ClanUserClient(
    private val apiService: ApiService<ClanUserResponseDto>,
) {

    fun fetchUserInfoIdListByClanId(clanIdList: List<String>): List<Int?> {
        val clanUserList: MutableList<List<Int?>> = mutableListOf()
        var post: ResponseEntity<ClanUserResponseDto>?
        var resultClanUserList: List<Int?>? = null
        for (clanId in clanIdList) {
            while (true) {
                try {
                    post = apiService.post(
                        "https://barracks.sa.nexon.com/api/ClanHome/GetClanUserList",
                        setDummyHeaders(),
                        ClanUserRequestDto(clanId),
                        ClanUserResponseDto::class.java
                    )
                    resultClanUserList = post.body?.resultClanUserList?.map { it?.user_nexon_sn }
                        ?: break
                } catch (e: HttpMessageNotReadableException) {
                    break
                } catch (e: RestClientException) {
                    break
                } catch (e: InvalidFormatException) {
                    break
                }
            }
            if(resultClanUserList != null) {
                clanUserList.add(resultClanUserList)
            }
        }
        return clanUserList.flatten()
    }
}

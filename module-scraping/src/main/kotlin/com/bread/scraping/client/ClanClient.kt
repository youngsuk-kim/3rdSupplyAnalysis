package com.bread.scraping.client

import com.bread.scraping.dto.ClanInfoResponseDto
import com.bread.scraping.dto.DummyRequestDto
import com.bread.scraping.service.ApiService
import org.springframework.stereotype.Component

@Component
class ClanClient(
    private val apiService: ApiService<ClanInfoResponseDto>
) {

    fun fetchClanUserInfo() {
        fetchClanInfo()
    }

    fun fetchClanInfo(clanName: String): String {
        val clanInfo = apiService.post(
            "https://barracks.sa.nexon.com/api/Search/GetSearchClanAll/${clanName}/1",
            setDummyHeaders(),
            DummyRequestDto(),
            ClanInfoResponseDto::class.java
        )

        return clanInfo.body!!.result.clanInfo.get(0).clan_id
    }
}

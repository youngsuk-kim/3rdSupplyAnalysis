package com.bread.scraping.client

import com.bread.scraping.dto.ClanUserRequestDto
import com.bread.scraping.dto.ClanUserResponseDto
import com.bread.scraping.service.ApiService
import org.springframework.stereotype.Component

@Component
class ClanUserClient(
    private val apiService: ApiService<ClanUserResponseDto>,
) {

    fun fetchUserInfoIdListByClanId(clanIdList: List<String>): List<Int?> {
        val clanUserList: MutableList<List<Int?>> = mutableListOf()
        for (clanId in clanIdList) {
            val post = apiService.post(
                "https://barracks.sa.nexon.com/api/ClanHome/GetClanUserList",
                setDummyHeaders(),
                ClanUserRequestDto(clanId),
                ClanUserResponseDto::class.java
            )
            val resultClanUserList = post.body?.resultClanUserList?.map { it?.user_nexon_sn }
                ?: continue
            clanUserList.add(resultClanUserList)
        }

        return clanUserList.flatten()
    }
}

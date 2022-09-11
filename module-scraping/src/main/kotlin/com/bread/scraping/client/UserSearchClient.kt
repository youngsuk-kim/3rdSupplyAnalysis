package com.bread.scraping.client

import com.bread.scraping.dto.DummyRequestDto
import com.bread.scraping.dto.UserSearchResponseDto
import com.bread.scraping.service.ApiService
import org.springframework.stereotype.Component

@Component
class UserSearchClient(
    private val apiService: ApiService<UserSearchResponseDto>
) {
    fun fetchUserId(nickname: String): Int? {
        val userHeaders = setUserHeaders()
        val post = apiService.post(
            "https://barracks.sa.nexon.com/api/Search/GetSearch/${nickname}/1",
            userHeaders,
            DummyRequestDto(),
            UserSearchResponseDto::class.java
        )
        return post.body!!.result!!.characterInfo!!
            .filter { it.user_nick.equals(nickname) }
            .map { it.user_nexon_sn }
            .last()
    }
}

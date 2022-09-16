package com.bread.scraping.client

import com.bread.scraping.service.ApiService
import org.springframework.stereotype.Component

@Component
class SuddenBattleClient(
    private val apiService: ApiService<String>
) {
    fun fetchClan(): String? {
        return apiService.get("http://suddenbattle.com/", setDummyHeaders(), String::class.java).body
    }

    fun fetchUser(clanId: String): String? {
        return apiService.get("http://suddenbattle.com/?page=1&clan_idx=${clanId}", setDummyHeaders(), String::class.java).body
    }
}

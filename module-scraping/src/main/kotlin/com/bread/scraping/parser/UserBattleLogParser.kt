package com.bread.scraping.parser

import com.bread.scraping.client.BattleLogClient
import com.bread.scraping.client.UserSearchClient
import org.springframework.stereotype.Component

@Component
class UserBattleLogParser(
    private val userSearchClient: UserSearchClient,
    private val battleLogClient: BattleLogClient
) {
    fun parse(nickName: String) {
        val fetchUserId = userSearchClient.fetchUserId(nickName)
        battleLogClient.fetchBattleLog(fetchUserId!!)
    }
}

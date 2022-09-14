package com.bread.scraping.parser

import com.bread.scraping.client.SuddenBattleClient
import org.jsoup.Jsoup
import org.springframework.stereotype.Component

@Component
class SuddenBattleParser(
    private val suddenBattleClient: SuddenBattleClient
) {

    fun parseClan(): MutableList<String> {
        val suddenBattleHtml = suddenBattleClient.fetchClan()
        val jsoup = Jsoup.parse(suddenBattleHtml!!)
        return jsoup.select(".viewcname").eachText()
    }
}

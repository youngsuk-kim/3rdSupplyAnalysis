package com.bread.web.service

import com.bread.scraping.client.SuddenBattleClient
import com.bread.scraping.parser.SuddenBattleParser
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class SuddenBattleClientTest {

    @Autowired
    lateinit var suddenBattleClient: SuddenBattleClient

    @Autowired
    lateinit var suddenBattleParser: SuddenBattleParser

    @Test
    fun test() {
        suddenBattleClient.fetchClan()
    }

    @Test
    fun test2() {
        suddenBattleParser.parseClan()
    }
}

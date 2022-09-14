package com.bread.scraping.client

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class SuddenBattleClientTest {

    @Autowired
    lateinit var suddenBattleClient: SuddenBattleClient

    @Disabled
    @Test
    fun test() {
        suddenBattleClient.fetchClan()
    }
}

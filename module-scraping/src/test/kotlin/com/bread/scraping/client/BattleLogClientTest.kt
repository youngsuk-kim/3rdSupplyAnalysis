package com.bread.scraping.client

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class BattleLogClientTest {

    @Autowired
    lateinit var battleLogClient: BattleLogClient

    @Test
    @Disabled
    fun test() {
        battleLogClient.fetchBattleLog(123124)
    }
}

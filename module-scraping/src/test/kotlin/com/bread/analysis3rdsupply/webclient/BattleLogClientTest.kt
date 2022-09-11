package com.bread.analysis3rdsupply.webclient

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class BattleLogClientTest {

    @Autowired
    lateinit var battleLogClient: BattleLogClient

    @Test
    fun test() {
        battleLogClient.fetchBattleLog()
    }
}

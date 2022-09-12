package com.bread.web.service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BattleLogSaveServiceTest {

    @Autowired
    lateinit var battleLogSaveService: BattleLogSaveService

    @Test
    fun saveUserBattleLogData() {
        battleLogSaveService.saveBattleLogByUserId(503852111)
    }
}

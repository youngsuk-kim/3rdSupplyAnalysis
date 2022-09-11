package com.bread.scraping.parser

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class UserBattleLogParserTest {

    @Autowired
    lateinit var userBattleLogParser: UserBattleLogParser

    @Test
    fun test() {
        userBattleLogParser.parse("프봉")
    }
}

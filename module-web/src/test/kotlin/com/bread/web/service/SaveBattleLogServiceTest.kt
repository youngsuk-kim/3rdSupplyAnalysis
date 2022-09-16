package com.bread.web.service

import com.bread.database.model.UserType
import com.bread.scraping.client.ClanUserClient
import com.bread.scraping.parser.SuddenBattleParser
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SaveBattleLogServiceTest {

    @Autowired
    lateinit var suddenBattleParser: SuddenBattleParser

    @Autowired
    lateinit var clanUserClient: ClanUserClient

    @Autowired
    lateinit var saveBattleLogService: SaveBattleLogService

    @Test
    fun saveSuddenBattleUserBattleLogData() {
        val parseClanId = suddenBattleParser.parseClanId()
        val userInfoIdList = clanUserClient.fetchUserInfoIdListByClanId(parseClanId)
        for (userInfoId in userInfoIdList) {
            println("유저 정보 id 값 $userInfoId")
            saveBattleLogService.saveBattleLogByUserId(userInfoId!!, UserType.SUDDEN_BATTLE)
        }
    }
}

package com.bread.database.dao

import com.bread.database.entity.BattleLog
import org.springframework.stereotype.Component

@Component
class BattleRepository(
    private val battleLogDao: BattleLogDao
) {
    fun save(battleLog: BattleLog) {
        battleLogDao.save(battleLog)
    }
}

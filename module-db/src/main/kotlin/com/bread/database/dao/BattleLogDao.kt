package com.bread.database.dao

import com.bread.database.entity.BattleLog
import org.springframework.data.jpa.repository.JpaRepository

interface BattleLogDao: JpaRepository<BattleLog, Long> {
}

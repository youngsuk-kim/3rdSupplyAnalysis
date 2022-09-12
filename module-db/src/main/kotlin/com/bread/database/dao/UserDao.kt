package com.bread.database.dao

import com.bread.database.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserDao: JpaRepository<User, Long> {
    fun findByUserNexonId(userId: Int): User?
}

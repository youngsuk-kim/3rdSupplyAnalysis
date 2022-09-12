package com.bread.database.entity

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Nickname (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private val user: User,

    private val nickname: String
)

package com.bread.database.entity

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class BattleLog(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,

    private val round: Int,

    private val eventType: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private val user: User,

    private val killX: Double? = null,

    private val killY: Double? = null,

    private val eventTime: String? = null,

    private val weapon: String? = null,

    private val deathX: Double? = null,

    private val deathY: Double? = null,
)

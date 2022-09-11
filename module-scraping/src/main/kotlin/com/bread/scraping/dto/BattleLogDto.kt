package com.bread.scraping.dto

data class BattleLogResponseDto(
    val battleLog: List<BattleLog>?
)

data class BattleLog(
    val death_x: Double?,
    val death_y: Double?,
    val event_category: String?,
    val event_icon: String?,
    val event_key: Int?,
    val event_text: String?,
    val event_time: String?,
    val event_type: String?,
    val kill_x: Double?,
    val kill_y: Double?,
    val map: Any?,
    val mask_nick: String?,
    val mask_target_nick: Any?,
    val round: String?,
    val target_user_nexon_sn: Int?,
    val target_user_nick: String?,
    val user_nexon_sn: Int?,
    val user_nick: String?,
    val weapon: String?
)

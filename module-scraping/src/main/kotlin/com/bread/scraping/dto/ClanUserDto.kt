package com.bread.scraping.dto

data class ClanUserResponseDto(
    val message: String?,
    val result: Int?,
    val resultClanInfo: Any?,
    val resultClanUserList: List<ResultClanUser?>?,
    val rtnCode: Int?
)

data class ClanUserRequestDto(
    val clan_id: String
)

data class ResultClanUser(
    val auth_flag: String,
    val clan_exp: String,
    val clan_level: String,
    val conn_flag: Int,
    val profile_img: String,
    val punish_flag: Int,
    val user_nexon_sn: Int,
    val user_nick: String
)


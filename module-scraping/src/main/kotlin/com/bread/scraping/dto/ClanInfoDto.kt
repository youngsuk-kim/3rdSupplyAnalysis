package com.bread.scraping.dto

data class ClanInfoResponseDto(
    val message: Any?,
    val result: ClanResult?,
    val rtnCode: Int?
)

data class ClanInfo(
    val clan_id: String,
    val clan_mark1: String,
    val clan_mark2: String,
    val clan_name: String
)

data class ClanResult(
    val clanInfo: List<ClanInfo>,
    val page_no: Int,
    val total_cnt: Int
)

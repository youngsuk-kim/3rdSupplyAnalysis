package com.bread.scraping.dto

data class UserSearchResponseDto(
    val message: Any?,
    val result: UserResult?,
    val rtnCode: Int?
)

data class UserResult(
    val characterInfo: List<CharacterInfo>?,
    val page_no: Int?,
    val total_cnt: Int?
)

data class CharacterInfo(
    val user_img: String?,
    val user_nexon_sn: Int?,
    val user_nick: String?
)

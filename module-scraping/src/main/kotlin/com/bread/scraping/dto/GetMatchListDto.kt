package com.bread.scraping.dto


data class GetMatchListRequestDto(
    val min_seq_no: Long? = 70220000119000000,
    val mode_flag: String? = "ALL",
    val seq_no: Long = 0,
    val user_nexon_sn: String = "2047101791"
)

data class GetMatchListResponseDto(
    val message: String,
    val result: List<Result>,
    val resultLastst: ResultLastst?,
    val resultPattern: List<ResultPattern>?,
    val rtnCode: Int?
)

data class Result(
    val assist_cnt: Int?,
    val clan_mark1: Any?,
    val clan_mark1_1: Int?,
    val clan_mark1_2: Int?,
    val clan_mark1_3: Int?,
    val clan_mark2: Any?,
    val clan_mark2_1: Int?,
    val clan_mark2_2: Int?,
    val clan_mark2_3: Int?,
    val clan_no: Any?,
    val damage_cnt: Int?,
    val death_cnt: Int?,
    val disaster_cnt: Int?,
    val disaster_score: Int?,
    val dogtag: Int?,
    val dogtag_cnt: Int?,
    val farming_cnt: Int?,
    val head_cnt: Int?,
    val invalid_flag: Any?,
    val is_broken_table: Boolean?,
    val is_clan: Boolean?,
    val kill_cnt: Int?,
    val leader_user_nexon_sn: Int?,
    val map_name: String?,
    val map_no: Int?,
    val match_key: String?,
    val match_name: String?,
    val match_sub_type: String?,
    val match_table_first_round: Int?,
    val match_table_last_round: Int?,
    val match_time: String?,
    val match_time_date: String?,
    val match_type: String?,
    val mission_cnt: Int?,
    val player_grade: Int?,
    val player_grade_type: Any?,
    val player_nick: Any?,
    val player_team: Any?,
    val plimit: Int?,
    val replayFlag: Int?,
    val result_rank: Int?,
    val result_rank_t: Int?,
    val result_wdl: String?,
    val save_cnt: Int?,
    val team_info: Any?,
    val team_key: Any?,
    val team_last_round: Int?,
    val team_last_round_text: Any?,
    val team_mode: Any?,
    val team_name: Any?,
    val tos_time: Int?,
    val user_nexon_sn: Int?,
    val viability: Double?,
    val viability_index: Double?
)

data class ResultLastst(
    val damage_cnt: String?,
    val death_cnt: Int?,
    val draw_cnt: Int?,
    val head_cnt: Int?,
    val head_per: String?,
    val kill_cnt: Int?,
    val kill_per: String?,
    val lose_cnt: Int?,
    val win_cnt: Int?,
    val win_per: String?
)

data class ResultPattern(
    val mode_name: String?,
    val mode_rate: String?
)


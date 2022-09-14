package com.bread.scraping.client

import org.springframework.util.LinkedMultiValueMap

private const val ACCPET = "application/json, text/plain, */*"

private const val CONTENT_TYPE = "application/json;charset=UTF-8"

private const val USER_AGENT =
    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36"

private const val ACCEPT_ENCODING = "gzip, deflate, br"

private const val ORIGIN = "https://barracks.sa.nexon.com"

fun setMatchHeaders(): LinkedMultiValueMap<String, String> {
    val multiValueMap = LinkedMultiValueMap<String, String>()
    multiValueMap["Accept"] = ACCPET
    multiValueMap["Content-Type"] = CONTENT_TYPE
    multiValueMap["User-Agent"] = USER_AGENT
    multiValueMap["Referer"] = "https://barracks.sa.nexon.com/2047101791/match"
    multiValueMap["Origin"] = ORIGIN
    multiValueMap["Accept-Encoding"] = ACCEPT_ENCODING
    multiValueMap["Content-Length"] = "90"
    return multiValueMap
}

fun setBattleLogHeaders(): LinkedMultiValueMap<String, String> {
    val multiValueMap = LinkedMultiValueMap<String, String>()
    multiValueMap["Accept"] = ACCPET
    multiValueMap["Content-Type"] = CONTENT_TYPE
    multiValueMap["User-Agent"] = USER_AGENT
    multiValueMap["Origin"] = ORIGIN
    multiValueMap["Accept-Encoding"] = ACCEPT_ENCODING
    multiValueMap["Content-Length"] = "0"
    return multiValueMap
}

fun setUserHeaders(): LinkedMultiValueMap<String, String> {
    val multiValueMap = LinkedMultiValueMap<String, String>()
    multiValueMap["Accept"] = ACCPET
    multiValueMap["Content-Type"] = CONTENT_TYPE
    multiValueMap["User-Agent"] = USER_AGENT
    multiValueMap["Origin"] = ORIGIN
    multiValueMap["Accept-Encoding"] = ACCEPT_ENCODING
    multiValueMap["Content-Length"] = "0"
    return multiValueMap
}

fun setDummyHeaders(): LinkedMultiValueMap<String, String> {
    val multiValueMap = LinkedMultiValueMap<String, String>()
    multiValueMap["Accept"] = ACCPET
    multiValueMap["Content-Type"] = CONTENT_TYPE
    multiValueMap["User-Agent"] = USER_AGENT
    multiValueMap["Origin"] = ORIGIN
    multiValueMap["Accept-Encoding"] = ACCEPT_ENCODING
    multiValueMap["Content-Length"] = "0"
    return multiValueMap
}

package com.bread.analysis3rdsupply.webclient

import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate

@Service
class ApiService<T>(
    private val restTemplate: RestTemplate
) {
    fun post(url: String, httpHeaders: MultiValueMap<String, String>, body: Any, clazz: Class<T>): ResponseEntity<T> {
        return callApiEndPoint(url, HttpMethod.POST, httpHeaders, body, clazz)
    }

    private fun callApiEndPoint(url: String, httpMethod: HttpMethod, httpHeaders: MultiValueMap<String, String>, body: Any, clazz: Class<T>): ResponseEntity<T> {
        return restTemplate.exchange(url, httpMethod, HttpEntity(body, httpHeaders), clazz)
    }
}

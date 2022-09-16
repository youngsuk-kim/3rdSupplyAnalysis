package com.bread.scraping.service

import com.bread.scraping.common.RandomProxy
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.stereotype.Service
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate
import java.net.InetSocketAddress
import java.net.Proxy

@Service
class ApiService<T>(
    private val restTemplate: RestTemplate
) {
    fun post(url: String, httpHeaders: MultiValueMap<String, String>, body: Any, clazz: Class<T>): ResponseEntity<T> {
        val ip = RandomProxy.getRandomProxy().ip
        println(ip)
        val factory = SimpleClientHttpRequestFactory()
        val address = InetSocketAddress(ip, RandomProxy.getRandomProxy().port)
        val proxy = Proxy(Proxy.Type.HTTP, address)
        factory.setProxy(proxy)
        restTemplate.requestFactory = factory
        val callApiEndPoint = callApiEndPoint(url, HttpMethod.POST, httpHeaders, body, clazz)
        return callApiEndPoint
    }

    fun get(url: String, httpHeaders: MultiValueMap<String, String>, clazz: Class<T>): ResponseEntity<T> {
        return callApiEndPoint(url, HttpMethod.GET, httpHeaders, null, clazz)
    }

    private fun callApiEndPoint(url: String, httpMethod: HttpMethod, httpHeaders: MultiValueMap<String, String>, body: Any?, clazz: Class<T>): ResponseEntity<T> {
        return restTemplate.exchange(url, httpMethod, HttpEntity(body, httpHeaders), clazz)
    }
}

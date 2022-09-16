package com.bread.scraping.common

import com.bread.scraping.common.RandomProxy.getRandomProxy
import com.bread.scraping.common.RandomProxy.isProxyOn
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.web.client.RestTemplate
import java.net.InetSocketAddress
import java.net.Proxy


@Configuration
class ScrapingConfig {
    @Bean
    fun restTemplate(): RestTemplate {
        val restTemplate = RestTemplate()
        if (isProxyOn) {
            val factory = SimpleClientHttpRequestFactory()
            val address = InetSocketAddress(getRandomProxy().ip, getRandomProxy().port)
            val proxy = Proxy(Proxy.Type.HTTP, address)
            factory.setProxy(proxy)
            restTemplate.requestFactory = factory
        }
        return restTemplate
    }

    @Bean
    fun objectMapper(): ObjectMapper {
        val objectMapper = ObjectMapper()
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, false)
        return objectMapper
    }
}

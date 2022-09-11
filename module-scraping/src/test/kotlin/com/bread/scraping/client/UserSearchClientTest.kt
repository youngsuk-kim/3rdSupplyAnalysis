package com.bread.scraping.client

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class UserSearchClientTest {
    @Autowired
    lateinit var userSearchClient: UserSearchClient

    @Test
    fun test() {
        val fetchUserId = userSearchClient.fetchUserId("피방가자")
        println(fetchUserId)
    }
}

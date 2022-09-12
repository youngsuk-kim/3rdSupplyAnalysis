package com.bread.scraping.client

import com.bread.scraping.client.MatchClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class MatchClientTest {

    @Autowired
    lateinit var matchClient: MatchClient

    @Test
    @Disabled
    fun test() {
//        matchClient.fetchGameListId()
    }
}

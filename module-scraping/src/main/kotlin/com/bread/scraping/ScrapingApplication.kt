package com.bread.scraping

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ScrapingApplication

fun main(args: Array<String>) {
    runApplication<ScrapingApplication>(*args)
}

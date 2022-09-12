package com.bread.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan


@ComponentScan("com.bread.database", "com.bread.scraping", "com.bread.web")
@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class Analysis3rdSupplyApplication

fun main(args: Array<String>) {
    runApplication<Analysis3rdSupplyApplication>(*args)
}

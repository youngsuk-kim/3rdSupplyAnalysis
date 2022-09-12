package com.bread.database

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@SpringBootApplication
class DatabaseConfig {

    @Bean
    fun datasource(): DataSource {
        return DataSourceBuilder.create()
            .driverClassName("com.mysql.cj.jdbc.Driver")
            .url("jdbc:mysql://localhost:3306/supply?useSSL=false&allowPublicKeyRetrieval=true&tinyInt1isBit=false")
            .username("root")
            .build()
    }
}

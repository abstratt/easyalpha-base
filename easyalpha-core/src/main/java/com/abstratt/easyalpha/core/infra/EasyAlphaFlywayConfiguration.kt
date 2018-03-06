package com.abstratt.easyalpha.core.infra

import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
class EasyAlphaFlywayConfiguration {
    @Autowired
    lateinit var appProperties : EasyAlphaAppProperties

    @Autowired
    lateinit var flyway : Flyway

    @Autowired
    lateinit var migrationStrategy : FlywayMigrationStrategy

    @Bean
    fun flywayInitializer(flyway: Flyway): FlywayMigrationInitializer {
        flyway.setSchemas(appProperties.name)
        return FlywayMigrationInitializer(flyway, migrationStrategy)
    }
}



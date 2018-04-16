package com.abstratt.easyalpha.core

import com.abstratt.easyalpha.core.infra.EasyAlphaProfile
import org.flywaydb.core.Flyway
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile(EasyAlphaProfile.PRODUCTION, EasyAlphaProfile.STAGING)
class EasyAlphaProductionConfiguration {
    @Bean
    fun cleanMigrateStrategy(): FlywayMigrationStrategy =
        FlywayMigrationStrategy { flyway ->
            flyway.isValidateOnMigrate = true
            flyway.migrate()
        }
}

package com.abstratt.easyalpha.core.tests

import com.abstratt.kirra.spring.KirraAppProfile
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile


@Configuration
@Profile(KirraAppProfile.TESTING, KirraAppProfile.DEVELOPMENT)
open class TestConfiguration {
    @Bean
    open fun cleanMigrateStrategy(): FlywayMigrationStrategy {
        return FlywayMigrationStrategy { flyway ->
            flyway.clean()
            flyway.migrate()
        }
    }
}

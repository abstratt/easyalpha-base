package com.abstratt.easyalpha.core.infra;

import com.abstratt.kirra.spring.api.KirraSpringApplication
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScanPackages;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration

/**
 * Builds a KirraSpringApplication based on entity classes found in the class path.
 */
@Configuration
class EasyAlphaKirraApplicationBuilder {

    @Value("\${easyalpha.app.name}")
    lateinit var applicationName : String

    @Bean
    @Autowired
    fun buildKirraApplication(beanFactory: BeanFactory) : KirraSpringApplication {
        val entityPackageNames : MutableList<String> = EntityScanPackages.get(beanFactory).packageNames
        return KirraSpringApplication(applicationName, entityPackageNames.toTypedArray())
    }
}
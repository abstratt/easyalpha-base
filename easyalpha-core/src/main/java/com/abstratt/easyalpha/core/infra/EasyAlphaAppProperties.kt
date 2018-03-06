package com.abstratt.easyalpha.core.infra

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "easyalpha.app")
class EasyAlphaAppProperties {
    lateinit var name : String
}


package com.abstratt.easyalpha.core.infra

import org.springframework.boot.SpringApplication
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.support.PropertiesLoaderUtils
import java.util.*
import kotlin.reflect.KClass


abstract class EasyAlphaApplication

fun <C : EasyAlphaApplication> runApplication(clazz : KClass<C>, args : Array<String>) {
    val springApplication = SpringApplication(clazz.java)
    val commonProperties = PropertiesLoaderUtils.loadProperties(ClassPathResource("easyalpha-common-application.properties"))
    springApplication.setDefaultProperties(commonProperties)
    springApplication.run(*args)
}

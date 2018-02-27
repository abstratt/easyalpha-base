package com.abstratt.easyalpha.core.infra

import org.springframework.boot.SpringApplication
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.support.PropertiesLoaderUtils
import java.util.*
import kotlin.collections.LinkedHashMap
import kotlin.reflect.KClass


abstract class EasyAlphaApplication {
    constructor() {
        // remember this application class
        applications[this.javaClass.`package`.name] = this.javaClass.kotlin
    }
    companion object {
        private var applications : MutableMap<String, KClass<EasyAlphaApplication>> = LinkedHashMap()
    }
}

fun <C : EasyAlphaApplication> runApplication(clazz : KClass<C>, args : Array<String>) {
    val springApplication = SpringApplication(clazz.java)
    val commonProperties = PropertiesLoaderUtils.loadProperties(ClassPathResource("easyalpha-common-application.properties", clazz.java.classLoader))
    springApplication.setDefaultProperties(commonProperties)
    springApplication.run(*args)
}

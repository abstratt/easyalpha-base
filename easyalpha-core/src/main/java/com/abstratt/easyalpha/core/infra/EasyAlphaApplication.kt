package com.abstratt.easyalpha.core.infra

import com.abstratt.kirra.spring.KirraJavaApplication
import com.abstratt.kirra.spring.user.UserRole
import org.springframework.boot.SpringApplication
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.support.PropertiesLoaderUtils
import java.util.*
import kotlin.collections.LinkedHashMap
import kotlin.reflect.KClass


abstract class EasyAlphaApplication(userRoles : Iterable<out UserRole>) : KirraJavaApplication(userRoles) {
}



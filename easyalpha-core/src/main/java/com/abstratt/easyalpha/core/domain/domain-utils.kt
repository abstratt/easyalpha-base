package com.abstratt.easyalpha.core.domain

import com.abstratt.easyalpha.uriql.CustomFilter
import com.abstratt.easyalpha.uriql.CustomFilterSpecification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.NestedRuntimeException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.sql.Date
import java.sql.Time
import java.time.LocalDate
import javax.persistence.*
import java.time.LocalTime
import java.util.*
import javax.persistence.AttributeConverter
import kotlin.reflect.KClass


@Converter(autoApply = true)
class LocalDateConverter : AttributeConverter<LocalDate, Date> {
    override fun convertToDatabaseColumn(entityValue: LocalDate?): Date? =
        if (entityValue == null) null else Date.valueOf(entityValue)

    override fun convertToEntityAttribute(databaseValue: Date?): LocalDate? =
        databaseValue?.toLocalDate()
}

@Converter(autoApply = true)
class LocalTimeConverter : AttributeConverter<LocalTime, Time> {
    override fun convertToDatabaseColumn(entityValue: LocalTime?) = entityValue?.let { Time.valueOf(it) }
    override fun convertToEntityAttribute(databaseValue: java.sql.Time?) = databaseValue?.toLocalTime()
}


fun defaultPageRequest(page: Int? = 0, limit: Int? = 100) =
        PageRequest(page ?: 0, limit ?: 100, Sort(Sort.Order("id")))


fun getCurrentUserId(): Long? =
        (SecurityContextHolder.getContext().authentication.principal as CustomUserDetails).userId

fun getCurrentUsername(): String =
        (SecurityContextHolder.getContext().authentication.principal as User).username

fun getCurrentRoles(): Set<SecurityRole> =
        getRoles(SecurityContextHolder.getContext().authentication)

fun isCurrentRole(vararg toCheck : SecurityRole): Boolean =
        getRoles(SecurityContextHolder.getContext().authentication).intersect(toCheck.toSet()).isNotEmpty()

fun getRoles(authentication: Authentication): Set<SecurityRole> =
        emptySet()




/*
package com.abstratt.easyalpha.core.domain

import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

fun getCurrentUserId(): Long? =
        (SecurityContextHolder.getContext().authentication.principal as CustomUserDetails).userId

fun getCurrentUsername(): String =
        (SecurityContextHolder.getContext().authentication.principal as User).username

fun getCurrentRoles(): Set<SecurityRole> =
        getRoles(SecurityContextHolder.getContext().authentication)

fun isCurrentRole(vararg toCheck : SecurityRole): Boolean =
        getRoles(SecurityContextHolder.getContext().authentication).intersect(toCheck.toSet()).isNotEmpty()

fun getRoles(authentication: Authentication): Set<SecurityRole> =
        emptySet()*/



package com.abstratt.easyalpha.core.domain;

interface SecurityRole {
}

fun SecurityRole.allAuthorities(): List<String> = emptyList()

fun SecurityRole.forAuthority(authority: String): SecurityRole? = null

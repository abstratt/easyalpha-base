/*
package com.abstratt.easyalpha.core.domain;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import java.util.*

@Component
class CustomUserDetailsService : UserDetailsService {
    @Autowired
    lateinit var applicationUserService: ApplicationUserService

    override fun loadUserByUsername(username: String): CustomUserDetails =
            Optional.ofNullable(applicationUserService.findUserByUsername(username))
                    .map { it -> it.toUserDetails() }
                    .orElseThrow { UsernameNotFoundException(username) }
}*/

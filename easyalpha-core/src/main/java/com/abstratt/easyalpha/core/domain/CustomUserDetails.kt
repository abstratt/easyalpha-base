package com.abstratt.easyalpha.core.domain;

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

class CustomUserDetails(var userId : Long, username: String, password: String, authorities: List<GrantedAuthority>) : User(username, password, authorities)
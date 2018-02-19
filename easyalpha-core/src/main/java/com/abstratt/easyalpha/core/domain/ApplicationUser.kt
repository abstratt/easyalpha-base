/*
package com.abstratt.easyalpha.core.domain;

import com.abstratt.kirra.spring.BaseEntity
import org.springframework.security.core.GrantedAuthority
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity
open class ApplicationUser(
        override var id: Long? = null,
        var username: String? = null,
        private var password: String? = null,
        @Enumerated(EnumType.STRING)
        var role: SecurityRole? = null
) : BaseEntity(id) {
    fun updatePassword(newPassword : String) {
        password = newPassword
    }
    fun readPassword() : String? =
            password

fun toUserDetails(): CustomUserDetails =
        CustomUserDetails(this.id!!, this.username!!, this.readPassword()!!, this.authorities())

    fun authorities(): List<GrantedAuthority> =
            emptyList()

}

*/

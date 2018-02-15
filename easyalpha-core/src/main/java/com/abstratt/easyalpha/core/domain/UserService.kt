package com.abstratt.easyalpha.core.domain;

import com.abstratt.kirra.spring.BaseService
import kotlin.reflect.KClass

abstract class UserService<U : ApplicationUser, R : UserRepository<U>>(entityClass : KClass<U>) : BaseService<U, R>(entityClass) {
    fun findUserByUsername(username: String) : U? = repository.findByUsername(username)

    fun findUserByUsernameAndPassword(username: String, password: String) = repository.findByUsernameAndPassword(username, password)

    override fun update(toUpdate: U): U? {
        val id: Long = toUpdate.id!!
        val existingInstance = repository.findById(id).orElse(null)
        if (existingInstance != null) {
            if (toUpdate.readPassword() != null) {
                existingInstance.updatePassword(toUpdate.readPassword()!!)
                return repository.save(existingInstance)
            }
        }
        return existingInstance
    }

    override fun create(toCreate: U): U {
        BusinessException.ensure(toCreate.readPassword() != null, ErrorCode.INVALID_OR_MISSING_DATA, "password")
        return super.create(toCreate)
    }
}


package com.abstratt.easyalpha.core.domain

import com.abstratt.easyalpha.uriql.CustomFilter
import com.abstratt.easyalpha.uriql.CustomFilterSpecification
import com.abstratt.kirra.spring.BaseEntity
import com.abstratt.kirra.spring.BaseRepository
import com.abstratt.kirra.spring.BaseService
import com.abstratt.kirra.spring.defaultPageRequest
import org.springframework.data.domain.Page
import org.springframework.data.jpa.domain.Specification
import kotlin.reflect.KClass

class FilteredService<T : BaseEntity, R : BaseRepository<T>>(entityClass: KClass<T>) : BaseService<T, R>(entityClass) {
    open fun list(filter : CustomFilter? = null, page: Int? = null, limit: Int? = null): Page<T> {
        return repository.findAll(filterAsSpecification(filter), defaultPageRequest(page, limit))
    }

    fun filterAsSpecification(filter: CustomFilter?): Specification<T>? {
        return CustomFilterSpecification<T>(entityClass, filter)
    }
}
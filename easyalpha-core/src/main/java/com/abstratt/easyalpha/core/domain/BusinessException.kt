package com.abstratt.easyalpha.core.domain;

import org.springframework.core.NestedRuntimeException

class BusinessException : NestedRuntimeException, ErrorCodeException {
    override var errorCode: ErrorCode

    constructor(message: String?, e: Exception) : super(message, e) {
        this.errorCode = ErrorCode.UNEXPECTED
    }

    constructor(errorCode: ErrorCode, message: String?) : super(message ?: errorCode.defaultMessage) {
        this.errorCode = errorCode
    }

    companion object {
        private val serialVersionUID = 1L

        fun ensure(condition: Boolean, errorCode: ErrorCode, messageSupplier: () -> String) {
            if (!condition) {
                throw BusinessException(errorCode, messageSupplier())
            }
        }

        fun ensure(condition: Boolean, errorCode: ErrorCode, message: String? = null) {
            if (!condition) {
                throw BusinessException(errorCode, message)
            }
        }

        fun wrapException(e: Exception): BusinessException {
            return if (e is BusinessException) {
                e
            } else BusinessException("Unexpected error", e)
        }
    }
}


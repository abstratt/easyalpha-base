package com.abstratt.easyalpha.core.domain;

enum class ErrorCode private constructor(val errorCode: Int?, val errorKind: ErrorKind, val defaultMessage: String) {
    UNEXPECTED(-1, ErrorKind.INTERNAL, "Unexpected error"),
    UNSPECIFIED(null, "Unspecified error"),
    UNKNOWN_OBJECT(1001, ErrorKind.UNKNOWN_OBJECT, "Object not found"),
    TOO_MANY_ITEMS(1002, "Too may items"),
    INVALID_OR_MISSING_DATA(1003, "Invalid or missing data");

    enum class ErrorKind {
        CLIENT,
        UNKNOWN_OBJECT,
        INTERNAL
    }

    private constructor(errorCode: Int?, defaultMessage: String) : this(errorCode, ErrorKind.CLIENT, defaultMessage) {}
}
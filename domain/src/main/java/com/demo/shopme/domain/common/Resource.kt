package com.demo.shopme.domain.common

import java.io.Serializable

/**
 * Created by Tran The Hien on 27,September,2024
 */
sealed class Resource<T>(
    val data: T? = null,
    val code: String? = null,
    val message: String? = null,
) : Serializable {
    class Success<T>(data: T) : Resource<T>(data)

    class Loading<T>(data: T? = null) : Resource<T>(data)

    open class Error<T>(code: String?, message: String?, data: T? = null) : Resource<T>(
        data,
        code,
        message,
    )
}
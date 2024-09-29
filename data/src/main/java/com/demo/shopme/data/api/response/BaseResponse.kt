package com.demo.shopme.data.api.response

import com.google.gson.annotations.SerializedName


/**
 * Created by Tran The Hien on 27,September,2024
 */
data class BaseResponse<T>(
    @SerializedName("result")
    var result: Int,
    @SerializedName("errorCode")
    var errorCode: String,
    @SerializedName("errorMsg")
    var errorMsg: String,
    @SerializedName("data")
    var data: T?,
) {
    fun isSuccess(): Boolean {
        return result == 1
    }

    fun getMessage(): String {
        return errorMsg
    }

    fun getCode(): String {
        return errorCode
    }
}
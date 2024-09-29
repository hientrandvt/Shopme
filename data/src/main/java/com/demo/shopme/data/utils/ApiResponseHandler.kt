package com.demo.shopme.data.utils

import com.demo.shopme.data.api.response.BaseResponse
import com.demo.shopme.domain.common.Resource
import org.json.JSONObject
import retrofit2.Response

/**
 * Created by Tran The Hien on 27,September,2024
 */
object ApiResponseHandler {
    fun <T : Any> processApiResponse(response: Response<BaseResponse<T?>>): Resource<T?> {
        return if (response.isSuccessful && response.body()!!.isSuccess()) {
            Resource.Success(data = response.body()!!.data)
        } else if (response.isSuccessful && response.body() != null) {
            Resource.Error(code = response.body()!!.errorCode, message = response.body()!!.errorMsg)
        } else {
            try {
                val jsonObj = JSONObject(response.errorBody()!!.charStream().readText())
                Resource.Error(
                    code = jsonObj.getString("errorCode"),
                    message = jsonObj.getString("errorMsg"),
                )
            } catch (e: Exception) {
                Resource.Error(
                    code = null,
                    message = null,
                )
            }
        }
    }
}
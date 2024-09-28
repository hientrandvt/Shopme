package com.demo.shopme.network

import com.demo.shopme.BuildConfig
import com.demo.shopme.data.network.BaseUrlProvider

/**
 * Created by Tran The Hien on 29,September,2024
 */
class AppBaseUrlProvider() : BaseUrlProvider {
    override fun getBaseUrl(): String {
        return BuildConfig.BASE_URL
    }
}
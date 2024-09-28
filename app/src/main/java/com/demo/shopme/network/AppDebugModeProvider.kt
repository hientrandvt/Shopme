package com.demo.shopme.network

import com.demo.shopme.BuildConfig
import com.demo.shopme.data.network.DebugModeProvider

/**
 * Created by Tran The Hien on 29,September,2024
 */
class AppDebugModeProvider : DebugModeProvider {
    override fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }
}
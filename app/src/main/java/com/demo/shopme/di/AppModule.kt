package com.demo.shopme.di

/**
 * Created by Tran The Hien on 29,September,2024
 */

import com.demo.shopme.data.network.BaseUrlProvider
import com.demo.shopme.data.network.DebugModeProvider
import com.demo.shopme.network.AppBaseUrlProvider
import com.demo.shopme.network.AppDebugModeProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideBaseUrlProvider(): BaseUrlProvider {
        return AppBaseUrlProvider()
    }

    @Singleton
    @Provides
    fun provideDebugModeProvider(): DebugModeProvider {
        return AppDebugModeProvider()
    }
}
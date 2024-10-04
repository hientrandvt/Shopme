package com.demo.shopme.data.di

import com.demo.shopme.data.api.ApiProductService
import com.demo.shopme.data.interceptor.MockDataInterceptor
import com.demo.shopme.data.network.BaseUrlProvider
import com.demo.shopme.data.network.DebugModeProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val CONNECT_TIMEOUT = 60L
private const val WRITE_TIMEOUT = 30L
private const val READ_TIMEOUT = 30L


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideBaseUrl(baseUrlProvider: BaseUrlProvider): String {
        return baseUrlProvider.getBaseUrl()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(debugModeProvider: DebugModeProvider): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(false)
            if (debugModeProvider.isDebug()) {
                val logging = HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
                addInterceptor(logging)
                addInterceptor(MockDataInterceptor())
            }
        }.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiProductService(retrofit: Retrofit): ApiProductService {
        return retrofit.create(ApiProductService::class.java)
    }
}
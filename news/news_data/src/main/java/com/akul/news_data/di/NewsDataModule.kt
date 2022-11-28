package com.akul.news_data.di

import com.akul.news_data.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            ) .addInterceptor { chain ->
            val authorizedRequest = chain.request().newBuilder()
                .addHeader(BuildConfig., apiKey)//todo send api key as dependency
                .build()

            chain.proceed(authorizedRequest)
        }

            .build()
    }
}
package com.tai.androidtai.dagger.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    companion object {
        private const val API_BASE = "https://rickandmortyapi.com/"
    }

    @Provides
    internal fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    internal fun provideOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        return httpClient.build()
    }

    @Provides
    internal fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(API_BASE)
                .client(okHttpClient)
                .build()
    }

}

package com.tai.androidtai.dagger.modules

import android.content.Context

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class AndroidModule(private val mContext: Context) {

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return mContext
    }
}

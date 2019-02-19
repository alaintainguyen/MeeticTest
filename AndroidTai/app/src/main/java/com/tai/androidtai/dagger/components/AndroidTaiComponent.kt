package com.tai.androidtai.dagger.components

import android.app.Application
import android.content.Context

import com.google.gson.Gson
import com.tai.androidtai.dagger.modules.NetworkModule
import com.tai.androidtai.domain.repository.DashboardRepository
import com.tai.androidtai.modules.core.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

import io.reactivex.Scheduler
import retrofit2.Retrofit

interface AndroidTaiComponent: AndroidInjector<DaggerApplication> {

    fun inject(activity: BaseActivity)

    fun inject(application: Application)

    fun inject(networkModule: NetworkModule)

}

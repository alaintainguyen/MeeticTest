package com.tai.androidtai.dagger.components

import android.app.Application
import com.tai.androidtai.AndroidTaiApplication
import com.tai.androidtai.dagger.modules.ActivityBuilder
import com.tai.androidtai.dagger.modules.AndroidModule
import com.tai.androidtai.dagger.modules.ApplicationModule
import com.tai.androidtai.dagger.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AndroidModule::class, ApplicationModule::class, NetworkModule::class, ActivityBuilder::class])
interface ApplicationComponent : AndroidTaiComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun androidModule(androidModule: AndroidModule): Builder
        fun applicationModule(applicationModule: ApplicationModule): Builder
        fun networkModule(networkModule: NetworkModule): Builder

        fun build(): ApplicationComponent
    }

    override fun inject(instance: DaggerApplication)

    fun inject(target: AndroidTaiApplication)

    class Initializer private constructor() {

        init {
            throw UnsupportedOperationException()
        }

        companion object {

            fun init(application: Application): ApplicationComponent {
                return DaggerApplicationComponent.builder()
                        .application(application)
                        .androidModule(AndroidModule(application))
                        .applicationModule(ApplicationModule())
                        .networkModule(NetworkModule())
                        .build()
            }
        }
    }
}


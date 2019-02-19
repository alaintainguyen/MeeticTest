package com.tai.androidtai.dagger.modules

import com.tai.androidtai.dagger.scope.PerActivity
import com.tai.androidtai.modules.dashboard.DashboardActivity
import com.tai.androidtai.modules.dashboard.DashboardActivityModule
import com.tai.androidtai.modules.userDetails.UserDetailsActivity
import com.tai.androidtai.modules.userDetails.UserDetailsActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(DashboardActivityModule::class))
    internal abstract fun bindDashboardActivity(): DashboardActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(UserDetailsActivityModule::class))
    internal abstract fun bindMealDetailsActivity(): UserDetailsActivity

}
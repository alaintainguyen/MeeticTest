package com.tai.androidtai.modules.userDetails

import com.tai.androidtai.dagger.scope.PerActivity
import com.tai.androidtai.domain.usecase.GetUserDetailsUseCase
import dagger.Module
import dagger.Provides

@Module
class UserDetailsActivityModule {

    @Provides
    @PerActivity
    internal fun provideMealDetailsPresenter(getUserDetailsUseCase: GetUserDetailsUseCase, router: UserDetailsContract.Router): UserDetailsContract.Presenter {
        return UserDetailsPresenter(getUserDetailsUseCase, router)
    }

    @Provides
    @PerActivity
    internal fun provideMealDetailsRouter(): UserDetailsContract.Router {
        return UserDetailsRouter()
    }

}
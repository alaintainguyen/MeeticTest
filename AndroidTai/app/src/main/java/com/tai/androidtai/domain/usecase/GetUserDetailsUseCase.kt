package com.tai.androidtai.domain.usecase

import com.tai.androidtai.dagger.scope.PerActivity
import com.tai.androidtai.domain.bean.ResultBean
import com.tai.androidtai.domain.repository.DashboardRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject

@PerActivity
class GetUserDetailsUseCase

@Inject
internal constructor(postExecutionThread: Scheduler, private val mRepository: DashboardRepository) : UseCase<ResultBean, Int>(postExecutionThread) {

    override fun buildObservable(id: Int?): Observable<ResultBean> {
        return mRepository.getUserDetails(id!!)
    }

}
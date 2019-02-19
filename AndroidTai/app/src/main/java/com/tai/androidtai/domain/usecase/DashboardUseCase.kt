package com.tai.androidtai.domain.usecase

import com.tai.androidtai.dagger.scope.PerActivity
import com.tai.androidtai.domain.bean.DashBoardResponseBean
import com.tai.androidtai.domain.repository.DashboardRepository

import javax.inject.Inject

import io.reactivex.Observable
import io.reactivex.Scheduler

@PerActivity
class DashboardUseCase

@Inject
internal constructor(postExecutionThread: Scheduler, private val mRepository: DashboardRepository) : UseCase<DashBoardResponseBean, Int>(postExecutionThread) {

    override fun buildObservable(currentPage: Int): Observable<DashBoardResponseBean> {
        return mRepository.getInfo(currentPage)
    }

}

package com.tai.androidtai.domain.repository

import com.tai.androidtai.domain.bean.DashBoardResponseBean
import com.tai.androidtai.domain.bean.ResultBean
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

class DashboardRepository @Inject
constructor(retrofit: Retrofit) {

    private val mService: DashboardService

    init {
        mService = retrofit.create(DashboardService::class.java)
    }

    fun getInfo(currentPage: Int): Observable<DashBoardResponseBean> {
        return mService.getInfo(currentPage)
    }

    fun getUserDetails(id: Int): Observable<ResultBean> {
        return mService.getUserDetails(id)
    }

    private interface DashboardService {

        @GET("api/character/")
        fun getInfo(@Query("page") currentPage: Int): Observable<DashBoardResponseBean>

        @GET("api/character/{id}")
        fun getUserDetails(@Path("id") id: Int): Observable<ResultBean>

    }
}

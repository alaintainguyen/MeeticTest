package com.tai.androidtai.modules.dashboard

import com.tai.androidtai.domain.bean.ResultBean
import com.tai.androidtai.modules.core.BaseContract

interface DashboardContract {

    interface View : BaseContract.View {
        fun displayInformation(userList: List<ResultBean>?)
    }

    interface Presenter : BaseContract.Presenter {
        fun getInfo(currentPage: Int)
        fun goToUserDetails(resultBean: ResultBean)
    }

    interface Router : BaseContract.Router {
        fun goToUserDetails(resultBean: ResultBean, view: View?)
    }

}

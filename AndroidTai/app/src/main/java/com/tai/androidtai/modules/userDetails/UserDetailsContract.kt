package com.tai.androidtai.modules.userDetails

import com.tai.androidtai.domain.bean.ResultBean
import com.tai.androidtai.modules.core.BaseContract

interface UserDetailsContract {

    interface View : BaseContract.View {
        fun displayAllUserInformation(resultBean: ResultBean)
    }

    interface Presenter : BaseContract.Presenter {
        fun getUserDetailsInformation(userId: Int?)
    }

    interface Router : BaseContract.Router {
    }
}

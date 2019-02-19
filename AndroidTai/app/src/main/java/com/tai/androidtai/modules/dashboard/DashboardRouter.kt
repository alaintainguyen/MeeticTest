package com.tai.androidtai.modules.dashboard

import android.content.Intent
import com.tai.androidtai.domain.bean.ResultBean
import com.tai.androidtai.modules.core.BaseRouter
import com.tai.androidtai.modules.userDetails.UserDetailsActivity
import com.tai.androidtai.modules.userDetails.UserDetailsActivity.Companion.USER_ID

class DashboardRouter : BaseRouter(), DashboardContract.Router {

    override fun goToUserDetails(resultBean: ResultBean, view: DashboardContract.View?) {
        val intent = Intent(getActivity(view!!), UserDetailsActivity::class.java)
        intent.putExtra(USER_ID, resultBean.getId())
        getActivity(view)?.startActivity(intent)
    }
}

package com.tai.androidtai.modules.userDetails

import android.util.Log
import com.tai.androidtai.domain.bean.ResultBean
import com.tai.androidtai.domain.usecase.GetUserDetailsUseCase
import com.tai.androidtai.modules.core.BaseContract
import com.tai.androidtai.modules.core.BasePresenter
import io.reactivex.annotations.NonNull
import io.reactivex.observers.ResourceObserver

class UserDetailsPresenter(private val mGetUserDetailsUseCase: GetUserDetailsUseCase, private val mRouter: UserDetailsContract.Router) : BasePresenter(), UserDetailsContract.Presenter {

    private var mView: UserDetailsContract.View? = null

    companion object {
        private val TAG = UserDetailsPresenter::class.java.simpleName
    }

    override fun subscribe(view: BaseContract.View) {
        mView = view as UserDetailsContract.View
    }

    override fun unsubscribe(view: BaseContract.View) {
        if (mView == view) {
            mView = null
        }
    }

    override fun getUserDetailsInformation(userId: Int?) {
        mGetUserDetailsUseCase.execute(GetUserDetailsSubscriber(), userId)
    }

    private inner class GetUserDetailsSubscriber : ResourceObserver<ResultBean>() {

        override fun onNext(@NonNull resultBean: ResultBean) {
            mView?.displayAllUserInformation(resultBean)
        }

        override fun onError(@NonNull e: Throwable) {
            Log.e(TAG, e.message)
        }

        override fun onComplete() {
            // Nothing to do
        }
    }

}

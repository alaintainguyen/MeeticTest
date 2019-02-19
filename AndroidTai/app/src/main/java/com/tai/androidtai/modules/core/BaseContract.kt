package com.tai.androidtai.modules.core

interface BaseContract {

    interface View

    interface Presenter {

        fun subscribe(view: BaseContract.View)

        fun unsubscribe(view: BaseContract.View)

    }

    interface Router
}


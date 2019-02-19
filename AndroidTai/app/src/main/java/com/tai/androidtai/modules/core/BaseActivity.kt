package com.tai.androidtai.modules.core

import android.os.Bundle

import com.tai.androidtai.AndroidTaiApplication
import com.tai.androidtai.dagger.components.AndroidTaiComponent
import com.tai.androidtai.dagger.modules.ActivityModule

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), BaseContract.View {

    protected val activityModule: ActivityModule get() = ActivityModule(this)

    protected val applicationComponent: AndroidTaiComponent get() = (application as AndroidTaiApplication).applicationComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}

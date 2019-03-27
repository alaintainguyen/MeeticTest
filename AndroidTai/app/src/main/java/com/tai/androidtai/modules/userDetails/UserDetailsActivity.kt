package com.tai.androidtai.modules.userDetails

import android.os.Bundle
import com.tai.androidtai.R
import com.tai.androidtai.domain.bean.ResultBean
import com.tai.androidtai.modules.core.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_user_details.*
import javax.inject.Inject

class UserDetailsActivity : BaseActivity(), UserDetailsContract.View {

    companion object {
        const val USER_ID: String = "id"
    }

    @Inject
    lateinit var mPresenter: UserDetailsContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        AndroidInjection.inject(this)
        mPresenter.subscribe(this)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbar.setNavigationIcon(R.drawable.back_arrow)
        toolbar.setNavigationOnClickListener { finish() }

        val userId = intent.getIntExtra(USER_ID, 0)
        mPresenter.getUserDetailsInformation(userId)
    }

    override fun displayAllUserInformation(resultBean: ResultBean) {
        user_image.setImageURI(resultBean.getImageUrl())
        user_name.text = resultBean.getName()
        user_status.text = resultBean.getStatus()
        gender.text = resultBean.getGender()
        user_species.text = resultBean.getSpecies()
        user_origin.text = resultBean.getOrigin()?.getName()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unsubscribe(this)
    }

}
package com.tai.androidtai.modules.userDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife
import com.facebook.drawee.view.SimpleDraweeView
import com.tai.androidtai.R
import com.tai.androidtai.domain.bean.ResultBean
import com.tai.androidtai.modules.core.BaseActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class UserDetailsActivity : BaseActivity(), UserDetailsContract.View {

    companion object {
        const val USER_ID: String = "id"
    }

    @Inject
    lateinit var mPresenter: UserDetailsContract.Presenter

    @BindView(R.id.user_image)
    lateinit var mImage: SimpleDraweeView

    @BindView(R.id.user_species)
    lateinit var mSpecies: TextView

    @BindView(R.id.gender)
    lateinit var mGender: TextView

    @BindView(R.id.user_status)
    lateinit var mStatus: TextView

    @BindView(R.id.toolbar)
    lateinit var mToolbar: Toolbar

    @BindView(R.id.user_name)
    lateinit var mName: TextView

    @BindView(R.id.user_origin)
    lateinit var mOrigin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        ButterKnife.bind(this)
        AndroidInjection.inject(this)
        mPresenter.subscribe(this)

        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        mToolbar.setNavigationIcon(R.drawable.back_arrow)
        mToolbar.setNavigationOnClickListener { finish() }

        val userId = intent.getIntExtra(USER_ID, 0)
        mPresenter.getUserDetailsInformation(userId)
    }

    override fun displayAllUserInformation(resultBean: ResultBean) {
        mImage.setImageURI(resultBean.getImageUrl())
        mName.text = resultBean.getName()
        mStatus.text = resultBean.getStatus()
        mGender.text = resultBean.getGender()
        mSpecies.text = resultBean.getSpecies()
        mOrigin.text = resultBean.getOrigin().getName()
    }

}
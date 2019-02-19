package com.tai.androidtai.modules.dashboard

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.tai.androidtai.R
import com.tai.androidtai.domain.bean.ResultBean
import com.tai.androidtai.modules.core.BaseActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class DashboardActivity : BaseActivity(), DashboardContract.View {

    @Inject
    lateinit var mPresenter: DashboardContract.Presenter

    @BindView(R.id.dashboard_rv)
    lateinit var mDashboardRecyclerView: RecyclerView

    private lateinit var mDashboardListAdapter: DashboardListAdapter
    private var mCurrentPage = 1
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        ButterKnife.bind(this)
        AndroidInjection.inject(this)
        mPresenter.subscribe(this)
        mDashboardListAdapter = DashboardListAdapter(mPresenter)
        mDashboardRecyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mDashboardRecyclerView.layoutManager = layoutManager
        mDashboardRecyclerView.adapter = mDashboardListAdapter
        mPresenter.getInfo(mCurrentPage)

        // Scroll infini
        mDashboardRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
                if (!isLoading) {
                    if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
                        loadMoreContact()
                    }
                }
            }
        })
    }

    private fun loadMoreContact() {
        isLoading = true
        mCurrentPage += 1
        mPresenter.getInfo(mCurrentPage)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.unsubscribe(this)
    }

    override fun displayInformation(userList: List<ResultBean>?) {
        isLoading = false;
        mDashboardListAdapter.addInformation(userList!!)
    }

}
package com.tai.androidtai.modules.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.facebook.drawee.view.SimpleDraweeView
import com.tai.androidtai.R
import com.tai.androidtai.domain.bean.ResultBean
import java.util.*

class DashboardListAdapter internal constructor(private val mPresenter: DashboardContract.Presenter) : RecyclerView.Adapter<DashboardListAdapter.DashboardViewHolder>() {

    private val mItems: ArrayList<Any> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_display_all_users_info, parent, false)
        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val resultBean = mItems[position] as ResultBean
        holder.mName.text = resultBean.getName()
        holder.mImage.setImageURI(resultBean.getImageUrl())
        holder.mStatus.text = resultBean.getStatus()
        holder.mGender.text = resultBean.getGender()
        holder.mLayout.setOnClickListener { mPresenter.goToUserDetails(resultBean) }
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun addInformation(resultInfo: List<ResultBean>) {
        mItems.addAll(resultInfo)
        notifyDataSetChanged()
    }

    inner class DashboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.layout)
        lateinit var mLayout: ConstraintLayout

        @BindView(R.id.dashboard_name)
        lateinit var mName: TextView

        @BindView(R.id.dashboard_gender)
        lateinit var mGender: TextView

        @BindView(R.id.dashboard_status)
        lateinit var mStatus: TextView

        @BindView(R.id.dashboard_image)
        lateinit var mImage: SimpleDraweeView

        init {
            ButterKnife.bind(this, itemView)
        }
    }
}

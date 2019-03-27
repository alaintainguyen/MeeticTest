package com.tai.androidtai.modules.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tai.androidtai.R
import com.tai.androidtai.domain.bean.ResultBean
import kotlinx.android.synthetic.main.item_display_all_users_info.view.*
import java.util.*

class DashboardListAdapter internal constructor(private val mPresenter: DashboardContract.Presenter) : RecyclerView.Adapter<DashboardListAdapter.DashboardViewHolder>() {

    private val mItems: ArrayList<Any> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_display_all_users_info, parent, false)
        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val resultBean = mItems[position] as ResultBean
        holder.itemView.dashboard_name.text = resultBean.getName()
        holder.itemView.dashboard_image.setImageURI(resultBean.getImageUrl())
        holder.itemView.dashboard_status.text = resultBean.getStatus()
        holder.itemView.dashboard_gender.text = resultBean.getGender()
        holder.itemView.layout.setOnClickListener { mPresenter.goToUserDetails(resultBean) }
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun addInformation(resultInfo: ArrayList<ResultBean>) {
        mItems.addAll(resultInfo)
    }

    inner class DashboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.dashboard_name
            itemView.dashboard_gender
            itemView.dashboard_status
            itemView.dashboard_image
            itemView.layout
        }
    }
}

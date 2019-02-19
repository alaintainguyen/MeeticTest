package com.tai.androidtai.domain.bean

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.SerializedName

class DashBoardResponseBean private constructor(parcel: Parcel) : Parcelable {

    @SerializedName("results")
    var mResultBean: List<ResultBean>

    init {
        mResultBean = parcel.createTypedArrayList(ResultBean.CREATOR)
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeTypedList<ResultBean>(mResultBean)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun getResultList(): List<ResultBean> {
        return mResultBean
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<DashBoardResponseBean> = object : Parcelable.Creator<DashBoardResponseBean> {
            override fun createFromParcel(parcel: Parcel): DashBoardResponseBean {
                return DashBoardResponseBean(parcel)
            }

            override fun newArray(size: Int): Array<DashBoardResponseBean?> {
                return arrayOfNulls(size)
            }
        }
    }
}


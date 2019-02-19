package com.tai.androidtai.domain.bean

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class OriginBean private constructor(parcel: Parcel) : Parcelable {

    @SerializedName("name")
    private var mName: String? = ""

    init {
        mName = parcel.readString()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(mName)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun getName(): String {
        if (mName == null) {
            mName = ""
        }
        return mName!!
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<OriginBean> = object : Parcelable.Creator<OriginBean> {
            override fun createFromParcel(parcel: Parcel): OriginBean {
                return OriginBean(parcel)
            }

            override fun newArray(size: Int): Array<OriginBean?> {
                return arrayOfNulls(size)
            }
        }
    }

}

package com.tai.androidtai.domain.bean

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class ResultBean private constructor(parcel: Parcel) : Parcelable {

    @SerializedName("id")
    private var mId: Int? = 0

    @SerializedName("name")
    private var mName: String? = ""

    @SerializedName("status")
    private var mStatus: String? = ""

    @SerializedName("species")
    private var mSpecies: String? = ""

    @SerializedName("gender")
    private var mGender: String? = ""

    @SerializedName("image")
    private var mImageUrl: String? = ""

    @SerializedName("origin")
    private var mOrigin: OriginBean? = null

    init {
        mId = parcel.readInt()
        mName = parcel.readString()
        mStatus = parcel.readString()
        mSpecies = parcel.readString()
        mGender = parcel.readString()
        mImageUrl = parcel.readString()
        mOrigin = parcel.readParcelable(OriginBean::class.java.classLoader)
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(mId!!)
        dest.writeString(mName)
        dest.writeString(mStatus)
        dest.writeString(mSpecies)
        dest.writeString(mGender)
        dest.writeString(mImageUrl)
        dest.writeParcelable(mOrigin, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun getId(): Int {
        return mId!!
    }

    fun getName(): String {
        if (mName == null) {
            mName = ""
        }
        return mName!!
    }

    fun getStatus(): String {
        if (mStatus == null) {
            mStatus = ""
        }
        return mStatus!!
    }

    fun getSpecies(): String {
        if (mSpecies == null) {
            mSpecies = ""
        }
        return mSpecies!!
    }

    fun getGender(): String {
        if (mGender == null) {
            mGender = ""
        }
        return mGender!!
    }

    fun getImageUrl(): String {
        if (mImageUrl == null) {
            mImageUrl = ""
        }
        return mImageUrl!!
    }

    fun getOrigin(): OriginBean {
        return mOrigin!!
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ResultBean> = object : Parcelable.Creator<ResultBean> {
            override fun createFromParcel(parcel: Parcel): ResultBean {
                return ResultBean(parcel)
            }

            override fun newArray(size: Int): Array<ResultBean?> {
                return arrayOfNulls(size)
            }
        }
    }
}

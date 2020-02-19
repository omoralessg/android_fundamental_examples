package com.example.androidfundamental.retrofitexample.github

import android.os.Parcel
import android.os.Parcelable

class GithubRepo() : Parcelable{
    @JvmField
    var name: String? = null
    @JvmField
    var owner: String? = null
    @JvmField
    var url: String? = null

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        owner = parcel.readString()
        url = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel?, flags: Int) {
        parcel?.writeString(name)
        parcel?.writeString(owner)
        parcel?.writeString(url)
    }


    override fun toString(): String {
        return "$name $url"
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object CREATOR : Parcelable.Creator<GithubRepo> {
        override fun createFromParcel(parcel: Parcel): GithubRepo {
            return GithubRepo(parcel)
        }

        override fun newArray(size: Int): Array<GithubRepo?> {
            return arrayOfNulls(size)
        }
    }
}
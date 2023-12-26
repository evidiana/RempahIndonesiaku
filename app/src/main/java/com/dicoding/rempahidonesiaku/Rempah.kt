package com.dicoding.rempahidonesiaku

import android.os.Parcel
import android.os.Parcelable


data class Rempah(
    val name: String?,
    val description: String?,
    val photo: Int,
    val detail_name: String?,
    val detail_description: String?,
    val detail_photo: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeInt(photo)
        parcel.writeString(detail_name)
        parcel.writeString(detail_description)
        parcel.writeInt(detail_photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Rempah> {
        override fun createFromParcel(parcel: Parcel): Rempah {
            return Rempah(parcel)
        }

        override fun newArray(size: Int): Array<Rempah?> {
            return arrayOfNulls(size)
        }
    }
}

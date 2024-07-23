package com.myfauzan.submission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album (
    var name: String = "",
    var detail: String = "",
    var photo: Int = 0
) : Parcelable
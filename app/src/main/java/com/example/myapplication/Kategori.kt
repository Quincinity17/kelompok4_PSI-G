package com.example.myapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class Kategori (
    var cover: Int,
    var title: String,
    var desc: String
        ) : Parcelable
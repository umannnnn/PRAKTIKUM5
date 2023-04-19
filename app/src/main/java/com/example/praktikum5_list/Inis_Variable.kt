package com.example.praktikum5_list

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Inis_Variable(
    val fotomhs:Int = 0,
    val Namamhs : String,
    val Nimmhs : String,
    val Telpmhs : String
) : Parcelable

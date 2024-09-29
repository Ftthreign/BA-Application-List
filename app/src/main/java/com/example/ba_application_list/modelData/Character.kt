package com.example.ba_application_list.modelData

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val name : String,
    val description : String,
    val school : String,
    val picture : String,
    val url : String,
    val weapon : String,
    val weapPic : String,
) : Parcelable

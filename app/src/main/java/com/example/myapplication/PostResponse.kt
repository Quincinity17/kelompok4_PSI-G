package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class PostResponse(

    val id: Int,
    val email: String?,
    val name: String?,
    val occupation: String?,
    val address: String?,
    val about: String?,
    val rate: String?
)
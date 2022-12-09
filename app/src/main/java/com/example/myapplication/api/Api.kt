package com.example.myapplication.api


import com.example.myapplication.model.CreateMentorRespons
import com.example.myapplication.model.Mentor
import com.example.myapplication.model.MentorRespons
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("mentor")
    fun getPosts(): Call<MentorRespons>

    @FormUrlEncoded
    @POST("mentor/register")
    fun createPost(
        @Field("nama") nama: String,
        @Field("email") email: String,
        @Field("password") occupation: String,
        @Field("desc") address: String
        ):Call<CreateMentorRespons>


}
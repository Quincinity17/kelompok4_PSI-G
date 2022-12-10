package com.example.myapplication.api


import com.example.myapplication.model.*
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @GET("mentor")
    fun getPosts(): Call<MentorRespons>

    @GET("mentee")
    fun getPostsMentee(): Call<MenteeRespons>

    @FormUrlEncoded
    @POST("mentor/register")
    fun createPost(
        @Field("nama") nama: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("desc") desc: String
        ):Call<CreateMentorRespons>

    @FormUrlEncoded
    @POST("mentee/register")
    fun createPostMentee(
        @Field("name") name: String,
        @Field("emailmentee") emailmentee: String,
        @Field("pass") pass: String,
        @Field("status") status: String
    ):Call<CreateMenteeRespons>

    @POST("mentor/login")
    fun getLoginMentor(
        @Body mentorRequestLogin: MentorRequestLogin
    ): Call<MentorResponseLogin>

    @GET("mentee/login")
    fun getLoginMentee(): Call<MentorRespons>

}
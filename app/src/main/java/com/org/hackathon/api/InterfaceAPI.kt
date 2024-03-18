package com.org.hackathon.api

import com.org.hackathon.model.DefaultResponse
import com.org.hackathon.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface InterfaceAPI {
    @FormUrlEncoded
    @POST("create_account")
    fun createUser(
        @Field("email") email:String,
        @Field("name") name: String

    ):Call<DefaultResponse>

    @FormUrlEncoded
    @POST("login")
    fun createLogin(
        @Field("email") email:String,
        @Field("password") name: String
    ):Call<LoginResponse>
}
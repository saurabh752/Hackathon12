package com.org.hackathon.api

import com.org.hackathon.model.DefaultResponse
import com.org.hackathon.model.LoginResponse
import com.org.hackathon.model.SlotResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

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

    @GET("get_slots")
    fun getSlotsForDate(@Query("date") date: String): Call<SlotResponse>
}
package com.example.retrofittest.retrofit

import com.example.retrofittest.model.MyDataModel
import retrofit2.http.GET

interface MyApiService {
    @GET("posts")
//    @GET("users")
    suspend fun getMyData(): List<MyDataModel>
}
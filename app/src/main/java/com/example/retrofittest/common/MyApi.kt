package com.example.retrofittest.common

import com.example.retrofittest.retrofit.MyApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyApi {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
//    private const val BASE_URL = "https://dummyjson.com/"

    fun create(): MyApiService{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(MyApiService::class.java)
    }
}
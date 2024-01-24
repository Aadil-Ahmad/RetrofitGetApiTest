package com.example.retrofittest.repository

import com.example.retrofittest.model.MyDataModel
import com.example.retrofittest.retrofit.MyApiService

class MyRepository(private val apiService: MyApiService) {

    suspend fun getMyData(): List<MyDataModel>{
        return apiService.getMyData()
    }
}
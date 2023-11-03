package com.abrsoftware.userapptest.data.remote

import com.abrsoftware.userapptest.data.model.ResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface MyApiService{
    @GET("api")
    suspend fun getUserInfo(): Response<ResponseModel>
}
package com.quoctran.joblogic.data.network

import com.quoctran.joblogic.data.model.PersonResponse
import com.quoctran.joblogic.data.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("call")
    suspend fun getListPerson(): Response<List<PersonResponse>>

    @GET("buy")
    suspend fun getListProduct(): Response<List<ProductResponse>>
}
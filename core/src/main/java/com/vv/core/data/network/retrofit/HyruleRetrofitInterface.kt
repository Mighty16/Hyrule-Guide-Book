package com.vv.core.data.network.retrofit

import com.vv.core.data.network.api_models.AbstractEntryApiModel
import com.vv.core.data.network.api_models.ApiResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface HyruleRetrofitInterface {

    @GET("/all")
    suspend fun getAll():ApiResponseModel<List<AbstractEntryApiModel>>

    @GET("/entry/{id}")
    suspend fun getEntry(@Path("id") idOrName: String): ApiResponseModel<AbstractEntryApiModel>

    @GET("/category/{category}")
    suspend fun getByCategory(@Path("category") category: String):ApiResponseModel<List<AbstractEntryApiModel>>

}
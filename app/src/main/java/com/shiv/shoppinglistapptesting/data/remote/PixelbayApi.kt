package com.shiv.shoppinglistapptesting.data.remote

import com.shiv.shoppinglistapptesting.BuildConfig
import com.shiv.shoppinglistapptesting.data.remote.responses.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixelbayApi {
    @GET("/api/")
    suspend fun searchForImage(
        @Query("q") searchQuery: String,
        @Query("key") apiKey : String = BuildConfig.API_KEY
    ) : Response<ImageResponse>
}
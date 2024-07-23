package com.myfauzan.githubusernavigationapi

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("/search/users")
    @Headers("Authorization: token <Personal Access Token>")
    suspend fun getUser(
        @Query("q") q: String
    ): Call<SearchResponse>
}
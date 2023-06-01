package com.kiko.movieappkotlin.API

import com.kiko.movieappkotlin.BuildConfig
import com.kiko.movieappkotlin.modelclass.MovieModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCalls {
    @GET("discover/movie")
    suspend fun getMovie(@Query("api_key") api_key:String=BuildConfig.API_KEY):MovieModel
}
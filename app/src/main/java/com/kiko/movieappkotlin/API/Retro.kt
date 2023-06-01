package com.kiko.movieappkotlin.API

import com.kiko.movieappkotlin.Constant.Const
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retro {
   private val retrofit=Retrofit.Builder().baseUrl(Const.BASE_URL).addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApi():ApiCalls{
        return retrofit.create(ApiCalls::class.java)
    }
}
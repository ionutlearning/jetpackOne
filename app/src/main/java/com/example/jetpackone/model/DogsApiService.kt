package com.example.jetpackone.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DogsApiService {

    companion object {
        const val BASE_URL = "https://raw.githubusercontent.com"
    }

    private val api = Retrofit.Builder().baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DogsApi::class.java)

    fun getDogs() = api.getDogs()
}
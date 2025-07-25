package com.example.firstappandmaybethelast.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceLocator {
    private const val BASE_URL = "https://intern-sunaster-default-rtdb.asia-southeast1.firebasedatabase.app/"
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiAction: ApiAction by lazy {
        ApiAction.retrofitService(retrofit)
    }
}
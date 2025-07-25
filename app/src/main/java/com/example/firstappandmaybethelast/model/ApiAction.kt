package com.example.firstappandmaybethelast.model

import com.example.firstappandmaybethelast.musicdata.Music
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiAction {
    @GET(".json")
    suspend fun getSong(): List<Music>

    companion object {
        fun retrofitService(retrofit: Retrofit): ApiAction {
            return retrofit.create(ApiAction::class.java)
        }
    }
}
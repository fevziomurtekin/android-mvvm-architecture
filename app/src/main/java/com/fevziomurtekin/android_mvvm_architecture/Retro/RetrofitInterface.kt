package com.fevziomurtekin.android_mvvm_architecture.Retro

import com.fevziomurtekin.android_mvvm_architecture.Model.userInfo
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("fevziomurtekin/repos")
    fun userInfo():Observable<userInfo>

    companion object {
        fun create(): RetrofitInterface {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.github.com/users/")
                .build()

            return retrofit.create(RetrofitInterface::class.java)
        }
    }
}
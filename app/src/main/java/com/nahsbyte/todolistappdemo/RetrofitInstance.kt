package com.nahsbyte.todolistappdemo

import retrofit2.Retrofit

object RetrofitInstance {
    val api: ApiServices by lazy {
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .build()
            .create(ApiServices::class.java)
    }
}
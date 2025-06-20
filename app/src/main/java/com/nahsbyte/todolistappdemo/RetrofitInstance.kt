package com.nahsbyte.todolistappdemo

import retrofit2.Retrofit

object RetrofitInstance {
    private const val BASE_URL = "https://dummyjson.com/"
    // Lazy initialization of Retrofit instance
    val api: ApiServices by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .client(
                okhttp3.OkHttpClient.Builder()
                    .addInterceptor(
                        okhttp3.logging.HttpLoggingInterceptor().apply {
                            level = okhttp3.logging.HttpLoggingInterceptor.Level.BODY
                        }
                    )
                    .build()
            )
            .build()
            .create(ApiServices::class.java)
    }
}
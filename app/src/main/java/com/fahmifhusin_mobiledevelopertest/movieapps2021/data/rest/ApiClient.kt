package com.fahmifhusin_mobiledevelopertest.movieapps2021.data.rest

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient{
    //set url server & key
        const val BASE_URL = "https://api.themoviedb.org/"
//      const val BASE_URL = "https://polls.apiblueprint.org/"
//    private const val BASE_URL: String = "https://jsonplaceholder.typicode.com/"
        const val API_KEY = "d34a01dac0385df0afc746a68c7d8759"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w500"
        //handle connection
//        private val gson : Gson by lazy {
//            GsonBuilder().setLenient().create()
//        }
//    private val httpClient : OkHttpClient by lazy {
//        OkHttpClient.Builder().build()
//    }

    private val retrofit : Retrofit by lazy {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    val apiService :  ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}
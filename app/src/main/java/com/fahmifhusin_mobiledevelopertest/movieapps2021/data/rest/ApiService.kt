package com.fahmifhusin_mobiledevelopertest.movieapps2021.data.rest

import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.RequestAcara
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiService {
//    @Headers("Content-Type:application/json")
//    @GET("movies")
//    fun getMovies():Call<RequestAcara>
    @GET("3/discover/movie?api_key=" + ApiClient.API_KEY)
    fun getMovies(): Call<RequestAcara>
    @GET("3/discover/tv?api_key="+ ApiClient.API_KEY)
    fun getSeries(): Call<RequestAcara>
}
package com.fahmifhusin_mobiledevelopertest.movieapps2021.data.rest

import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.RequestAcara
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("3/discover/movie?api_key=" + ApiClient.API_KEY)
    fun getMovies(): Call<RequestAcara>
    @GET("3/discover/tv?api_key="+ ApiClient.API_KEY)
    fun getSeries(): Call<RequestAcara>
}
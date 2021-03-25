package com.fahmifhusin_mobiledevelopertest.movieapps2021.data.rest

import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.RequestAcara
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.Results
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("3/discover/movie?api_key=" + ApiClient.API_KEY)
    fun getMovies(): Call<Results>
//@GET("users")
////@GET("movies")
//fun getMovies(): Call<MutableList<Results>>
@GET("users")
fun getSeries(): Call<MutableList<Results>>
}
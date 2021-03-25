package com.fahmifhusin_mobiledevelopertest.movieapps2021.data.rest

import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.RequestAcara
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.Results
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
//    @GET("3/discover/movie?api_key=" + ApiClient.API_KEY)
//    fun getMovies(): Call<MutableList<RequestAcara>>
@GET("users")
fun getUsers(): Call<MutableList<Results>>

}
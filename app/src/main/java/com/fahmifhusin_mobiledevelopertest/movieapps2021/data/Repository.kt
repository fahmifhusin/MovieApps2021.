package com.fahmifhusin_mobiledevelopertest.movieapps2021.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.Results
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.RequestAcara
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.rest.ApiClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repository {
    fun getMutableLiveDataMovie(context: Context) : MutableLiveData<ArrayList<Results>> {
        val hasil = MutableLiveData<ArrayList<Results>>()
        var dataMovies: List<Results>
//     context.showProgressBar()
        ApiClient.apiService.getMovies().enqueue(object : Callback<RequestAcara> {
            override fun onFailure(call: Call<RequestAcara>, t: Throwable) {
                Log.e("error", t.localizedMessage)
            }

            override fun onResponse(call: Call<RequestAcara>, response: Response<RequestAcara>) {
                dataMovies = response.body()?.getListAcara()!!
                    dataMovies.let { hasil.value = it as ArrayList<Results> }
            }
        })
        return hasil
        }
    fun getMutableLiveDataSeries(context: Context) : MutableLiveData<ArrayList<Results>> {
        val hasil = MutableLiveData<ArrayList<Results>>()
        var dataMovies: List<Results>
//     context.showProgressBar()
        ApiClient.apiService.getSeries().enqueue(object : Callback<RequestAcara> {
            override fun onFailure(call: Call<RequestAcara>, t: Throwable) {
                Log.e("error", t.localizedMessage)
            }

            override fun onResponse(call: Call<RequestAcara>, response: Response<RequestAcara>) {
                dataMovies = response.body()?.getListAcara()!!
                dataMovies.let { hasil.value = it as ArrayList<Results> }
            }
        })
        return hasil
    }
    }


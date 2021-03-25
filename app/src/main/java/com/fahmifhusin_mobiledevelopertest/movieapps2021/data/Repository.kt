package com.fahmifhusin_mobiledevelopertest.movieapps2021.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.RequestAcara
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.Results
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.rest.ApiClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repository {
    fun getMutableLiveDataMovie(context: Context) : MutableLiveData<ArrayList<RequestAcara>> {
//        val mutableLiveData = MutableLiveData<List<Results>>()
        val hasil = MutableLiveData<ArrayList<RequestAcara>>()
        var dataMovies: List<RequestAcara>
//     context.showProgressBar()
        ApiClient.apiService.getMovies().enqueue(object : Callback<Results> {
            override fun onFailure(call: Call<Results>, t: Throwable) {
                Log.e("error", t.localizedMessage)
            }

            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                dataMovies = response.body()?.getListAcara()!!
                    dataMovies.let { hasil.value = it as ArrayList<RequestAcara> }
            }
        })
        return hasil
        }
    fun getMutableLiveDataSeries(context: Context) : MutableLiveData<ArrayList<Results>> {
        val mutableLiveData = MutableLiveData<ArrayList<Results>>()
//        context.showProgressBar()
        ApiClient.apiService.getSeries().enqueue(object : Callback<MutableList<Results>> {
            override fun onFailure(call: Call<MutableList<Results>>, t: Throwable) {
                Log.e("error", t.localizedMessage)
            }

            override fun onResponse(
                call: Call<MutableList<Results>>,
                response: Response<MutableList<Results>>
            ) {
                val responseData = response.body()
                responseData?.let { mutableLiveData.value = it as ArrayList<Results> }
            }
        })
        return mutableLiveData
        }
    }


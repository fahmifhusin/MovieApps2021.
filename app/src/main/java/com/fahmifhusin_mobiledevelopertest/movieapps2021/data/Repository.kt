package com.fahmifhusin_mobiledevelopertest.movieapps2021.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.RequestAcara
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.Results
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.rest.ApiClient
import com.fahmifhusin_mobiledevelopertest.movieapps2021.util.Utility.hideProgressBar
import com.fahmifhusin_mobiledevelopertest.movieapps2021.util.Utility.showProgressBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repository {
    fun getMutableLiveData(context: Context) : MutableLiveData<ArrayList<Results>> {
        val mutableLiveData = MutableLiveData<ArrayList<Results>>()
        context.showProgressBar()
        ApiClient.apiService.getUsers().enqueue(object : Callback<MutableList<Results>> {
            override fun onFailure(call: Call<MutableList<Results>>, t: Throwable) {
                hideProgressBar()
                Log.e("error", t.localizedMessage)
            }

            override fun onResponse(
                call: Call<MutableList<Results>>,
                response: Response<MutableList<Results>>
            ) {
                hideProgressBar()
                val response = response.body()
                response?.let { mutableLiveData.value = it as ArrayList<Results> }
            }

        })

        return mutableLiveData
        }
    }


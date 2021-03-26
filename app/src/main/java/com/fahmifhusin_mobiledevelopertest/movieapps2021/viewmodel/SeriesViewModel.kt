package com.fahmifhusin_mobiledevelopertest.movieapps2021.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.Repository
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.RequestAcara
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.Results
import com.fahmifhusin_mobiledevelopertest.movieapps2021.util.Utility.isInternetAvailable

class SeriesViewModel(private val context: Context): ViewModel() {
    private var viewModelSeriesData = MutableLiveData<ArrayList<Results>>()

    init{
        val repository : Repository by lazy {
            Repository
        }
        if(context.isInternetAvailable()) {
            viewModelSeriesData = repository.getMutableLiveDataSeries(context)
//            Utility.hideProgressBar()
        }
    }

    fun getSeriesViewData() : MutableLiveData<ArrayList<Results>> {
        return viewModelSeriesData
    }

}
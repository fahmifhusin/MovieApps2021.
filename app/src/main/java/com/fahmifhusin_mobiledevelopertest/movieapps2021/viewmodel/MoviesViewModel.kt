package com.fahmifhusin_mobiledevelopertest.movieapps2021.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.Repository
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.Results
import com.fahmifhusin_mobiledevelopertest.movieapps2021.util.Utility.isInternetAvailable

class MoviesViewModel(private val context: Context):ViewModel() {

    private var viewModelMoviesData = MutableLiveData<ArrayList<Results>>()

    init{
        val repository : Repository by lazy {
            Repository
        }
        if(context.isInternetAvailable()) {
            viewModelMoviesData = repository.getMutableLiveDataMovie(context)
//            hideProgressBar()
        }
    }

    fun getMoviesViewData() : MutableLiveData<ArrayList<Results>> {
        return viewModelMoviesData
    }


}
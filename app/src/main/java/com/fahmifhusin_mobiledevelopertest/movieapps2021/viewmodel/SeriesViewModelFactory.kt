package com.fahmifhusin_mobiledevelopertest.movieapps2021.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SeriesViewModelFactory (private val context: Context) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SeriesViewModel(context) as T
    }

}
package com.fahmifhusin_mobiledevelopertest.movieapps2021.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fahmifhusin_mobiledevelopertest.movieapps2021.R
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.RequestAcara
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.Results
import com.fahmifhusin_mobiledevelopertest.movieapps2021.viewmodel.SeriesViewModel
import com.fahmifhusin_mobiledevelopertest.movieapps2021.viewmodel.SeriesViewModelFactory

class SeriesFragment: Fragment() {

    lateinit var rvSeries: RecyclerView
    lateinit var adapterSeries: SeriesAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var dataResult:MutableList<Results>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_series, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvSeries = view.findViewById(R.id.rv_series)
        layoutManager = GridLayoutManager(activity, 2)
        rvSeries.setLayoutManager(layoutManager)
        dataResult = mutableListOf()
        adapterSeries = SeriesAdapter(dataResult)
        rvSeries.setAdapter(adapterSeries)

        val seriesViewModel = ViewModelProviders.of(this,
            context?.let { SeriesViewModelFactory(it) }).get(SeriesViewModel::class.java)
        seriesViewModel.getSeriesViewData().observe(this,object: Observer<ArrayList<Results>> {
            override fun onChanged(t: ArrayList<Results>) {
                dataResult.clear()
                t.let { dataResult.addAll(it) }
                Log.d("dataResult", dataResult.size.toString())
                adapterSeries.notifyDataSetChanged()
            }
        })
    }
}
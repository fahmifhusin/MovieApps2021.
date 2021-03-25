package com.fahmifhusin_mobiledevelopertest.movieapps2021.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fahmifhusin_mobiledevelopertest.movieapps2021.R
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.Results
import com.fahmifhusin_mobiledevelopertest.movieapps2021.viewmodel.AcaraViewModelFactory
import com.fahmifhusin_mobiledevelopertest.movieapps2021.viewmodel.MoviesViewModel

class MoviesFragment: Fragment() {

    lateinit var rvMovies: RecyclerView
    lateinit var adapterMovies: MoviesAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager
//    lateinit var dataMovies: List<AcaraResponse>
    lateinit var dataResult:MutableList<Results>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies, container, false)
          return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMovies = view.findViewById(R.id.rv_movies)
//        menambahkan view model
        layoutManager = GridLayoutManager(activity, 2)
        rvMovies.setLayoutManager(layoutManager)
        dataResult = mutableListOf()
        adapterMovies = MoviesAdapter(dataResult)
        rvMovies.setAdapter(adapterMovies)

        val moviesViewModel = ViewModelProviders.of(this,
            context?.let { AcaraViewModelFactory(it) }).get(MoviesViewModel::class.java)
        moviesViewModel.getData().observe(this,object: Observer<ArrayList<Results>> {
            override fun onChanged(t: ArrayList<Results>?) {
                dataResult.clear()
                t?.let { dataResult.addAll(it) }
                adapterMovies.notifyDataSetChanged()
            }
        })
    }
}


package com.fahmifhusin_mobiledevelopertest.movieapps2021.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fahmifhusin_mobiledevelopertest.movieapps2021.R
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.Results

class MoviesAdapter(private var listMovies: MutableList<Results>) : RecyclerView.Adapter<MoviesAdapter.DaftarMoviesHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesAdapter.DaftarMoviesHolder {
        val mView : View = LayoutInflater.from(parent.getContext()).inflate(
            R.layout.item_daftar_acara,
            parent,
            false
        )
        return DaftarMoviesHolder(mView)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.DaftarMoviesHolder, position: Int) {
            val acaraMovies = listMovies.get(position)
            holder.titleAcara.setText(acaraMovies.toString())
    }

    override fun getItemCount() = listMovies.size

    inner class DaftarMoviesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleAcara:TextView = itemView.findViewById(R.id.title_acara)
    }
}
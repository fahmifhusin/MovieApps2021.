package com.fahmifhusin_mobiledevelopertest.movieapps2021.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fahmifhusin_mobiledevelopertest.movieapps2021.R
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.Results
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.rest.ApiClient.IMAGE_URL

class MoviesAdapter(private var listMovies: MutableList<Results>) : RecyclerView.Adapter<MoviesAdapter.DaftarMoviesHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesAdapter.DaftarMoviesHolder {
        val mView : View = LayoutInflater.from(parent.getContext()).inflate(
            R.layout.item_daftar_acara,
            parent, false
        )
        mView.setOnClickListener({
            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(parent.context)
            builder.setCancelable(true)
            builder.setMessage(R.string.msg_add_favorite)
            builder.setPositiveButton(R.string.ya,
                { dialog, which ->
                    Toast.makeText(parent.context, R.string.msg_add_menu_continue, Toast.LENGTH_SHORT).show()
                })
            builder.setNegativeButton(R.string.tidak,
                { dialog, which ->
                    Toast.makeText(parent.context, R.string.msg_abort_add_dialog, Toast.LENGTH_SHORT).show()
                })
            val dialog: android.app.AlertDialog? = builder.create()
            dialog?.show()
        })
        return DaftarMoviesHolder(mView)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.DaftarMoviesHolder, position: Int) {
        val dataMovie:Results = listMovies.get(position)
            Glide.with(holder.itemView.context)
                .load(IMAGE_URL+dataMovie.getPoster())
            .override(200, 200)
            .into(holder.imgMovie)
        holder.titleMovie.setText(dataMovie.getTitle())
        holder.tglReleaseMovie.setText(dataMovie.getRelease())
        holder.overViewMovie.setText(dataMovie.getOverView())
        val voteRange:Float = dataMovie.getVote()!!.toFloat()
        if (voteRange <= 8.0  || voteRange >= 10.0){
            holder.ratingMovie.setText("A")
        }else if(voteRange <= 6.0  || voteRange >= 7.0){
            holder.ratingMovie.setText("B")
        }else if(voteRange <= 4.0  || voteRange >= 5.0){
            holder.ratingMovie.setText("C")
        }else if(voteRange < 4.0){
            holder.ratingMovie.setText("D")
        }
    }


    override fun getItemCount() = listMovies.size

    inner class DaftarMoviesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bgCategoryMovie:RelativeLayout = itemView.findViewById(R.id.bg_category)
        val imgMovie:ImageView = itemView.findViewById(R.id.img_acara)
        val movieisFav:ImageView = itemView.findViewById(R.id.acara_isfav)
        val ratingMovie:TextView = itemView.findViewById(R.id.rating_acara)
        val titleMovie:TextView = itemView.findViewById(R.id.title_acara)
        val tglReleaseMovie:TextView = itemView.findViewById(R.id.release_acara)
        val kategoriMovie:TextView = itemView.findViewById(R.id.kategori_acara)
        val overViewMovie:TextView = itemView.findViewById(R.id.overview_acara)



    }
}
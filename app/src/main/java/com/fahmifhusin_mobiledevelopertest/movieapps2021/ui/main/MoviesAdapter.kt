package com.fahmifhusin_mobiledevelopertest.movieapps2021.ui.main

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.bumptech.glide.Glide
import com.fahmifhusin_mobiledevelopertest.movieapps2021.R
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.database.MovieAppDB
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.FavoritePojo
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
        return DaftarMoviesHolder(mView)
    }

    @SuppressLint("ResourceAsColor")
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
        holder.bgCategoryMovie.setBackgroundColor(R.color.ungu)
        holder.kategoriMovie.setText("Unknown")
        holder.bgItemMovie.setOnClickListener({
            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(holder.itemView.context)
            builder.setCancelable(true)
            builder.setMessage(R.string.msg_add_favorite)
            builder.setPositiveButton(R.string.ya,
                { dialog, which ->
                    val db:MovieAppDB = Room.databaseBuilder(
                        holder.itemView.context,
                        MovieAppDB::class.java, "movie_dua_satu"
                    ).allowMainThreadQueries().build()
                    val idParse = Integer.parseInt(dataMovie.getId())
                    val dataFavBaru =
                        FavoritePojo(
                            idParse,
                            IMAGE_URL+dataMovie.getPoster(),
                            dataMovie.getTitle()!!,
                            dataMovie.getVote()!!,
                            "unknown",
                            dataMovie.getRelease()!!,
                            dataMovie.getOverView()!!
                        )
                    db.showFavoriteAcara().insertFav(dataFavBaru)
                    Log.d("dataBaru", dataFavBaru.toString())
                    Toast.makeText(holder.itemView.context, R.string.msg_add_menu_continue, Toast.LENGTH_SHORT).show()
                })
            builder.setNegativeButton(R.string.tidak,
                { dialog, which ->
                    Toast.makeText(holder.itemView.context, R.string.msg_abort_add_dialog, Toast.LENGTH_SHORT).show()
                })
            val dialog: android.app.AlertDialog? = builder.create()
            dialog?.show()
        })
     }


    override fun getItemCount() = listMovies.size

    inner class DaftarMoviesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bgCategoryMovie:RelativeLayout = itemView.findViewById(R.id.bg_category)
        val bgItemMovie:RelativeLayout = itemView.findViewById(R.id.item_acara)
        val movieisFav:ImageView = itemView.findViewById(R.id.acara_isfav)
        val imgMovie:ImageView = itemView.findViewById(R.id.img_acara)
        val ratingMovie:TextView = itemView.findViewById(R.id.rating_acara)
        val titleMovie:TextView = itemView.findViewById(R.id.title_acara)
        val tglReleaseMovie:TextView = itemView.findViewById(R.id.release_acara)
        val kategoriMovie:TextView = itemView.findViewById(R.id.kategori_acara)
        val overViewMovie:TextView = itemView.findViewById(R.id.overview_acara)



    }
}
package com.fahmifhusin_mobiledevelopertest.movieapps2021.ui.main

import android.annotation.SuppressLint
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
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.rest.ApiClient

class SeriesAdapter(private var listSeries: MutableList<Results>) : RecyclerView.Adapter<SeriesAdapter.DaftarSeriesHolder>() {

    lateinit var db:MovieAppDB
    lateinit var dataSerie:Results

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SeriesAdapter.DaftarSeriesHolder {
        val mView : View = LayoutInflater.from(parent.getContext()).inflate(
            R.layout.item_daftar_acara,
            parent,
            false
        )
        mView.setOnClickListener({
            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(parent.context)
            builder.setCancelable(true)
            builder.setMessage(R.string.msg_add_favorite)
            builder.setPositiveButton(R.string.ya,
                { dialog, which ->
                    db = Room.databaseBuilder(
                        parent.context,
                        MovieAppDB::class.java, "movie_dua_satu"
                    ).allowMainThreadQueries().build()
                    val idParse = Integer.parseInt(dataSerie.getId())
                    val dataFavBaru =
                        FavoritePojo(
                        idParse,
                        ApiClient.IMAGE_URL +dataSerie.getPoster(),
                        dataSerie.getName()!!,
                        dataSerie.getVote()!!,
                        "unknown",
                        dataSerie.getFirstAir()!!,
                        dataSerie.getOverView()!!
                    )
                    db.showFavoriteAcara().insertFav(dataFavBaru)
                    Toast.makeText(parent.context, R.string.msg_add_menu_continue, Toast.LENGTH_SHORT).show()
                })
            builder.setNegativeButton(R.string.tidak,
                { dialog, which ->
                    Toast.makeText(parent.context, R.string.msg_abort_add_dialog, Toast.LENGTH_SHORT).show()
                })
            val dialog: android.app.AlertDialog? = builder.create()
            dialog?.show()
        })
        return DaftarSeriesHolder(mView)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: SeriesAdapter.DaftarSeriesHolder, position: Int) {
        dataSerie = listSeries.get(position)
        Glide.with(holder.itemView.context)
            .load(ApiClient.IMAGE_URL +dataSerie.getPoster())
            .override(200, 200)
            .into(holder.imgSerie)
        holder.titleSerie.setText(dataSerie.getName())
        holder.tglReleaseSerie.setText(dataSerie.getFirstAir())
        holder.overViewSerie.setText(dataSerie.getOverView())
        val voteRange:Float = dataSerie.getVote()!!.toFloat()
        if (voteRange <= 8.0  || voteRange >= 10.0){
            holder.ratingSerie.setText("A")
        }else if(voteRange <= 6.0  || voteRange >= 7.0){
            holder.ratingSerie.setText("B")
        }else if(voteRange <= 4.0  || voteRange >= 5.0){
            holder.ratingSerie.setText("C")
        }else if(voteRange < 4.0){
            holder.ratingSerie.setText("D")
        }
        holder.bgCategorySerie.setBackgroundColor(R.color.ungu)
        holder.kategoriSerie.setText("Unknown")
    }


    override fun getItemCount() = listSeries.size

    inner class DaftarSeriesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bgCategorySerie: RelativeLayout = itemView.findViewById(R.id.bg_category)
        val imgSerie: ImageView = itemView.findViewById(R.id.img_acara)
        val serieisFav: ImageView = itemView.findViewById(R.id.acara_isfav)
        val titleSerie:TextView = itemView.findViewById(R.id.title_acara)
        val ratingSerie:TextView = itemView.findViewById(R.id.rating_acara)
        val tglReleaseSerie:TextView = itemView.findViewById(R.id.release_acara)
        val kategoriSerie:TextView = itemView.findViewById(R.id.kategori_acara)
        val overViewSerie:TextView = itemView.findViewById(R.id.overview_acara)


    }
}
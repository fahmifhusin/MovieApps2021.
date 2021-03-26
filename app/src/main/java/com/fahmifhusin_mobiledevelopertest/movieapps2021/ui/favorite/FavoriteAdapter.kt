package com.fahmifhusin_mobiledevelopertest.movieapps2021.ui.favorite

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.bumptech.glide.Glide
import com.fahmifhusin_mobiledevelopertest.movieapps2021.R
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.database.MovieAppDB
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.FavoritePojo

class FavoriteAdapter(private var listFavorite: List<FavoritePojo>) : RecyclerView.Adapter<FavoriteAdapter.DaftarFavoriteHolder>() {

    lateinit var dataFav: FavoritePojo
    lateinit var db:MovieAppDB

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaftarFavoriteHolder {
        val mView : View = LayoutInflater.from(parent.getContext()).inflate(
            R.layout.item_daftar_acara,
            parent, false
        )
        mView.setOnClickListener({
            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(parent.context)
            builder.setCancelable(true)
            builder.setMessage(R.string.msg_rm_favorite)
            builder.setPositiveButton(
                R.string.ya,
                { dialog, which ->
                    Toast.makeText(parent.context, R.string.msg_rm_fav_continue, Toast.LENGTH_SHORT).show()
                db = Room.databaseBuilder(
                    parent.context,
                    MovieAppDB::class.java, "movie_dua_satu"
                ).allowMainThreadQueries().build()
                 db.showFavoriteAcara().deleteById(dataFav)
                 (parent.context as Activity).finish()
                 parent.context.startActivity(Intent(parent.context, FavoriteActivity::class.java))
                })
            builder.setNegativeButton(
                R.string.tidak,
                { dialog, which ->
                    Toast.makeText(parent.context, R.string.msg_abort_rm_fav_dialog, Toast.LENGTH_SHORT).show()
                })
            val dialog: android.app.AlertDialog? = builder.create()
            dialog?.show()
        })
        return DaftarFavoriteHolder(mView)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: DaftarFavoriteHolder, position: Int) {
        dataFav = listFavorite.get(position)
        Glide.with(holder.itemView.context)
            .load(dataFav.imgItem)
            .override(200, 200)
            .into(holder.imgFav)
        holder.titleFav.setText(dataFav.titleItem)
        holder.tglReleaseFav.setText(dataFav.releaseItem)
        holder.overViewFav.setText(dataFav.overViewItem)
        val voteRange:Float = dataFav.ratingItem!!.toFloat()
        if (voteRange <= 8.0  || voteRange >= 10.0){
            holder.ratingFav.setText("A")
        }else if(voteRange <= 6.0  || voteRange >= 7.0){
            holder.ratingFav.setText("B")
        }else if(voteRange <= 4.0  || voteRange >= 5.0){
            holder.ratingFav.setText("C")
        }else if(voteRange < 4.0){
            holder.ratingFav.setText("D")
        }
        holder.bgCategoryFav.setBackgroundColor(R.color.ungu)
        holder.kategoriFav.setText(dataFav.kategoriItem)
    }

    override fun getItemCount() = listFavorite.size

    inner class DaftarFavoriteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bgCategoryFav: RelativeLayout = itemView.findViewById(R.id.bg_category)
        val isFav: ImageView = itemView.findViewById(R.id.acara_isfav)
        val imgFav: ImageView = itemView.findViewById(R.id.img_acara)
        val ratingFav: TextView = itemView.findViewById(R.id.rating_acara)
        val titleFav: TextView = itemView.findViewById(R.id.title_acara)
        val tglReleaseFav: TextView = itemView.findViewById(R.id.release_acara)
        val kategoriFav: TextView = itemView.findViewById(R.id.kategori_acara)
        val overViewFav: TextView = itemView.findViewById(R.id.overview_acara)
    }



}

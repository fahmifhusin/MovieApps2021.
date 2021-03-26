package com.fahmifhusin_mobiledevelopertest.movieapps2021.ui.favorite

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Spinner
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.fahmifhusin_mobiledevelopertest.movieapps2021.R
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.database.MovieAppDB
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.FavoritePojo
import com.fahmifhusin_mobiledevelopertest.movieapps2021.ui.main.MainActivity

class FavoriteActivity : AppCompatActivity() {

    lateinit var rvFavorite: RecyclerView
    lateinit var adapterFavorite: FavoriteAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var db:MovieAppDB
    lateinit var favSort:Spinner
    var listFav:List<FavoritePojo> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        //set judul pada activity dan back button
        val actionBar: ActionBar? = supportActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar()?.setTitle(getResources().getString(R.string.favorite))
            actionBar?.setDisplayHomeAsUpEnabled(true)
        }
        db = Room.databaseBuilder(
            applicationContext,
            MovieAppDB::class.java, "movie_dua_satu"
        ).allowMainThreadQueries().build()
        rvFavorite = findViewById(R.id.rv_favorite)
        layoutManager = GridLayoutManager(this, 2)
        rvFavorite.setLayoutManager(layoutManager)
        favSort = findViewById(R.id.sort_by_fav)
//        //handle list
//        if(favSort.getSelectedItem().equals("Genre")){
//            db.showFavoriteAcara().getDaftarFavSortGenre().observe(this,
//                Observer<List<FavoritePojo>> { dataFav ->
//                    adapterFavorite = FavoriteAdapter(dataFav)
//                    rvFavorite.setAdapter(adapterFavorite)
//                    adapterFavorite.notifyDataSetChanged()
//                })
//        }
//        else if(favSort.getSelectedItem().equals("Release")){
//            db.showFavoriteAcara().getDaftarFavSortRelease().observe(this,
//                Observer<List<FavoritePojo>> { dataFav ->
//                    adapterFavorite = FavoriteAdapter(dataFav)
//                    rvFavorite.setAdapter(adapterFavorite)
//                    adapterFavorite.notifyDataSetChanged()
//                    finish()
//                    startActivity(Intent(this, FavoriteActivity::class.java))
//                    Log.d("sort_by",favSort.selectedItem.toString())
//                })
//        }else if(favSort.getSelectedItem().equals("Rating")){
//            db.showFavoriteAcara().getDaftarFavSortRating().observe(this,
//                Observer<List<FavoritePojo>> { dataFav ->
//                    adapterFavorite = FavoriteAdapter(dataFav)
//                    rvFavorite.setAdapter(adapterFavorite)
//                    adapterFavorite.notifyDataSetChanged()
//                })
//            rvFavorite.visibility = View.GONE
//        }else{
            db.showFavoriteAcara().getDaftarFav().observe(this,
                Observer<List<FavoritePojo>> { dataFav ->
                    adapterFavorite = FavoriteAdapter(dataFav)
                    rvFavorite.setAdapter(adapterFavorite)
                    adapterFavorite.notifyDataSetChanged()
                })
//                        }
                     }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }
}
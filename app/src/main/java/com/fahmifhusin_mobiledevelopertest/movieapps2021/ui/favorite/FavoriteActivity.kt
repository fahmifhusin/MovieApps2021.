package com.fahmifhusin_mobiledevelopertest.movieapps2021.ui.favorite

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.fahmifhusin_mobiledevelopertest.movieapps2021.R
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.database.MovieAppDB
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.FavoritePojo
import com.fahmifhusin_mobiledevelopertest.movieapps2021.viewmodel.FavoriteViewModel

class FavoriteActivity : AppCompatActivity() {

    private var favViewModel: FavoriteViewModel? = null
    lateinit var rvFavorite: RecyclerView
    lateinit var adapterFavorite: FavoriteAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager
//    var listFav:List<FavoritePojo> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        //set judul pada activity dan back button
        val actionBar: ActionBar? = supportActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar()?.setTitle(getResources().getString(R.string.favorite))
            actionBar?.setDisplayHomeAsUpEnabled(true)
        }
        rvFavorite = findViewById(R.id.rv_favorite)
        layoutManager = GridLayoutManager(this, 2)
        rvFavorite.setLayoutManager(layoutManager)
        //handle db
        favViewModel = ViewModelProviders.of(this).get(FavoriteViewModel::class.java)
        favViewModel?.getFavSortN()?.observe(this, Observer<List<FavoritePojo>>
        {
            adapterFavorite = FavoriteAdapter(it)
            rvFavorite.setAdapter(adapterFavorite)
             })
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
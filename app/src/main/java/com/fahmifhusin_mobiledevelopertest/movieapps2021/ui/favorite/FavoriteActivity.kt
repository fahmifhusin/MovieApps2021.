package com.fahmifhusin_mobiledevelopertest.movieapps2021.ui.favorite


import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Spinner
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fahmifhusin_mobiledevelopertest.movieapps2021.R
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.database.MovieAppDB
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.FavoritePojo
import com.fahmifhusin_mobiledevelopertest.movieapps2021.viewmodel.FavoriteViewModel

class FavoriteActivity : AppCompatActivity() {

    lateinit var rvFavorite: RecyclerView
    lateinit var adapterFavorite: FavoriteAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var favSort:Spinner
    private var favVm: FavoriteViewModel? = null

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
        favSort = findViewById(R.id.sort_by_fav)

        favVm = ViewModelProviders.of(this).get(FavoriteViewModel::class.java)

        favVm?.getFav()?.observe(this, Observer<List<FavoritePojo>> {
            adapterFavorite = FavoriteAdapter(it)
            rvFavorite.setAdapter(adapterFavorite)
            adapterFavorite.notifyDataSetChanged()
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
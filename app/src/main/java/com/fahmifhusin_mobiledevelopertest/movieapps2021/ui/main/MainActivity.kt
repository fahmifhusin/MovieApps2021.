package com.fahmifhusin_mobiledevelopertest.movieapps2021.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.room.Room.databaseBuilder
import com.fahmifhusin_mobiledevelopertest.movieapps2021.R
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.database.MovieAppDB
import com.fahmifhusin_mobiledevelopertest.movieapps2021.ui.favorite.FavoriteActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    val STATUS = "status"

    private val SELECTED_MENU = "selected_menu"
    protected lateinit var fragmentManager: FragmentManager
    private lateinit var fragment: Fragment
    private lateinit var navView: BottomNavigationView
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_movies -> {
                    fragment = MoviesFragment()
                    Log.d(STATUS, item.title.toString())
                }
                R.id.action_tv_show -> {
                    fragment = SeriesFragment()
                    Log.d(STATUS, item.title.toString())
                }
            }
            if (fragment != null) {
                supportFragmentManager
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.container, fragment)
                    .commit()
            }
            true
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //set bottom navbar
        navView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        //set judul pada activity
        if (getSupportActionBar() != null) {
            getSupportActionBar()?.setTitle(getResources().getString(R.string.dashboard))
        }
        //set default fragment
        if (savedInstanceState != null) {
            savedInstanceState.getInt(SELECTED_MENU)
        } else {
            navView.selectedItemId = R.id.action_movies
            fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.container, MoviesFragment()).commit()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.fav_item -> {
                val mFavIntent = Intent(this, FavoriteActivity::class.java)
                startActivity(mFavIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SELECTED_MENU, navView.selectedItemId)
        Log.d("id", navView.selectedItemId.toString())
    }
}
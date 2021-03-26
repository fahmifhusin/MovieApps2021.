package com.fahmifhusin_mobiledevelopertest.movieapps2021.data

import android.app.Application
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.dao.FavoriteDao
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.database.MovieAppDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class RepositoryLocal (application: Application) : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var favDao: FavoriteDao?

    init {
        val db = MovieAppDB.getDatabase(application)
        favDao = db?.showFavoriteAcara()
    }

    fun getListFav() = favDao?.getDaftarFav()
    fun getListFavSortGenre() = favDao?.getDaftarFavSortGenre()
    fun getListFavSortRelease() = favDao?.getDaftarFavSortRelease()
    fun getListFavSortRating() = favDao?.getDaftarFavSortRelease()

    }


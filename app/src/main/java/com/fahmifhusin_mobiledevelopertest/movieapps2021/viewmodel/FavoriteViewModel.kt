package com.fahmifhusin_mobiledevelopertest.movieapps2021.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.RepositoryLocal

class FavoriteViewModel  (application: Application) : AndroidViewModel(application) {

    private var repository:RepositoryLocal = RepositoryLocal(application)

    fun getFav() = repository.getListFav()
    fun getFavByGenre() = repository.getListFavSortGenre()
    fun getFavByRelease() = repository.getListFavSortRelease()
    fun getFavByRating() = repository.getListFavSortRating()

}
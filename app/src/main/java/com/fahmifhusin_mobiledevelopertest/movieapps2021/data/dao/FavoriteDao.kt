package com.fahmifhusin_mobiledevelopertest.movieapps2021.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.FavoritePojo


@Dao
interface FavoriteDao {
    //get all daftar menu
    @Query("SELECT * FROM favorite ORDER BY title_item ASC")
    fun getDaftarFav(): LiveData<List<FavoritePojo>>

    @Query("SELECT * FROM favorite ORDER BY kategori_item ASC")
    fun getDaftarFavSortGenre(): LiveData<List<FavoritePojo>>
    @Query("SELECT * FROM favorite ORDER BY release_item DESC")
    fun getDaftarFavSortRelease(): LiveData<List<FavoritePojo>>
    @Query("SELECT * FROM favorite ORDER BY rating_item ASC")
    fun getDaftarFavSortRating(): LiveData<List<FavoritePojo>>

    @Insert()
    fun insertFav(vararg menu:FavoritePojo)
    @Delete
    fun delete(menu: FavoritePojo)
}
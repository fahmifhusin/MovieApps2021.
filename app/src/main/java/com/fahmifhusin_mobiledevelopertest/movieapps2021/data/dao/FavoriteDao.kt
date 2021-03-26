package com.fahmifhusin_mobiledevelopertest.movieapps2021.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
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

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFav(vararg menu: FavoritePojo)
    @Query("DELETE FROM favorite WHERE id = :idFav")
    fun deleteById(idFav:Int)
}
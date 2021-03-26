package com.fahmifhusin_mobiledevelopertest.movieapps2021.data.database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.dao.FavoriteDao
import com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo.FavoritePojo

@Database(entities = arrayOf(FavoritePojo::class), version = 1)

abstract class MovieAppDB :RoomDatabase(){
abstract fun showFavoriteAcara(): FavoriteDao
 companion object {

  @Volatile
  private var INSTANCE: MovieAppDB? = null

  fun getDatabase(context: Context): MovieAppDB? {
   if (INSTANCE == null) {
    synchronized(MovieAppDB::class.java) {
     if (INSTANCE == null) {
      INSTANCE = Room.databaseBuilder(
       context.applicationContext,
       MovieAppDB::class.java, "movie_dua_satu"
      )
       .build()
     }
    }
   }
   return INSTANCE
  }
 }

 }

package com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "favorite")

data class FavoritePojo(
    //membuat tabel daftar menu
    @PrimaryKey
    @ColumnInfo(name = "id") @NonNull var id_makanan: Int,
    @ColumnInfo(name = "image_item") @Nullable var imgItem: String,
    @ColumnInfo(name = "title_item") @NonNull var titleItem: String,
    @ColumnInfo(name = "rating_item") @NonNull var ratingItem: String,
    @ColumnInfo(name = "kategori_item") @NonNull var kategoriItem: String,
    @ColumnInfo(name = "release_item") @NonNull var releaseItem: String,
    @ColumnInfo(name = "overview_item") @NonNull var overViewItem: String
)



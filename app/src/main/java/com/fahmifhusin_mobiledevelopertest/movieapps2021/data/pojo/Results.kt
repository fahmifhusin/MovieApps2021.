package com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Results{
    @SerializedName("id")
    private var id: String? = null
    @SerializedName("overview")
    private var overview: String? = null
    //variabel TV Show
    @SerializedName("name")
    private val name: String? = null
    @SerializedName("first_air_date")
    private var first_air_date: String? = null
    //variabel Movies
    @SerializedName("poster_path")
    private var poster_path: String? = null
    @SerializedName("title")
    private var title: String? = null
    @SerializedName("release_date")
    private var release_date: String? = null
    @SerializedName("vote_average")
    private var vote_acara:String? = null

    fun getVote():String? {
        return vote_acara
    }

    fun getId(): String? {
        return id
    }
    fun getName(): String? {
        return name
    }
    fun getOverView(): String? {
        return overview
    }
    fun getFirstAir(): String? {
        return first_air_date
    }
    fun getTitle(): String? {
        return title
    }
    fun getPoster(): String? {
        return poster_path
    }
    fun getRelease(): String? {
        return release_date
    }

}



package com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestAcara{
        @SerializedName("page")
        var page: String? = null
        @SerializedName("total_results")
        var total_results: String? = null
        @SerializedName("total_pages")
        var total_pages: String? = null
        @SerializedName("results") @Expose
        private var listAcara: List<Results>? = null
//        @SerializedName("name")
//        var name: String? = null

//        @JvmName("getListAcara1")
        fun getListAcara(): List<Results>? {
              return listAcara
        }
}
package com.fahmifhusin_mobiledevelopertest.movieapps2021.data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RequestAcara(
    @SerializedName("page")
    private var page: String? = null,
    @SerializedName("total_results")
    private var total_results: String? = null,
    @SerializedName("total_pages")
    private var total_pages: String? = null,
    @SerializedName("results")
    @Expose
    private var listAcara: List<Results>? = null
) {
    fun getListAcara(): List<Results?>? {
        return listAcara
    }
}


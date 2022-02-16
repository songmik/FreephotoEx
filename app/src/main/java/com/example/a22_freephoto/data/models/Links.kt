package com.example.a22_freephoto.data.models

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("download")
    val download: String? = null,
    @SerializedName("download_location")
    val downloadLocation: String? = null,
    @SerializedName("html")
    val html: String? = null,
    @SerializedName("self")
    val self: String? = null
)
package com.bakarvin.hunternoteskt.data.model.location

import com.google.gson.annotations.SerializedName

data class ModelLocation(
    @SerializedName("id")
    val idLocation: String,
    @SerializedName("zoneCount")
    val zoneCountLocation: String,
    @SerializedName("name")
    val nameLocation: String
)

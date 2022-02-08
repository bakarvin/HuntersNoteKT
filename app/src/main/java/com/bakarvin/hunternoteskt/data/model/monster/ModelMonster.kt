package com.bakarvin.hunternoteskt.data.model.monster

import com.bakarvin.hunternoteskt.data.model.location.ModelLocation
import com.google.gson.annotations.SerializedName

data class ModelMonster(
    @SerializedName("id")
    val idMonster: String = "",
    @SerializedName("type")
    val typeMonster: String = "",
    @SerializedName("species")
    val speciesMonster: String = "",
    @SerializedName("name")
    val nameMonster: String = "",
    @SerializedName("description")
    val descriptionMonster: String = "",
    @SerializedName("locations")
    val locationMonster: List<ModelLocation>
)

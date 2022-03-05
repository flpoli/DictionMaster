package com.example.dictionmaster.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Entry(
    @SerializedName("etymologies")
    val etymologies: List<String>,
    @SerializedName("grammaticalFeatures")
    val grammaticalFeatures: List<GrammaticalFeature>,
    @SerializedName("pronunciations")
    val pronunciations: List<Pronunciation>,
    @SerializedName("senses")
    val senses: List<Sense>
)
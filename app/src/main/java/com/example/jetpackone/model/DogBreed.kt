package com.example.jetpackone.model

import com.google.gson.annotations.SerializedName

data class DogBreed(
    @SerializedName("id")
    val breedId: String?,
    @SerializedName("name")
    val dogBreed: String?,
    @SerializedName("life_span")
    val lifeSpan: String?,
    @SerializedName("breed_group")
    val breedGroup: String?,
    @SerializedName("breed_for")
    val bredFor: String?,
    val temperament: String?,
    @SerializedName("url")
    val imageUrl: String?
)
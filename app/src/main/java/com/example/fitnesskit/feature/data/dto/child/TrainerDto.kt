package com.example.fitnesskit.feature.data.dto.child

import com.example.fitnesskit.feature.domaine.model.childe.Trainer
import com.google.gson.annotations.SerializedName

class TrainerDto(
    private val description: String,
    val id: String,
    private val name: String,
    private val position: String,
    @SerializedName("image_url") private val imageUrl: String,
    @SerializedName("image_url_medium") private val imageUrlMedium: String,
    @SerializedName("image_url_small") private val imageUrlSmall: String,
    @SerializedName("last_name") private val lastName: String,
    @SerializedName("full_name") private val fullName: String,
) {
    fun toTrainer() = Trainer(
        description,
        id,
        name,
        position,
        imageUrl,
        imageUrlMedium,
        imageUrlSmall,
        lastName,
        fullName
    )
}
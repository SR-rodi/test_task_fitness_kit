package com.example.fitnesskit.feature.data.dto.child

import com.example.fitnesskit.feature.domaine.model.childe.Option
import com.google.gson.annotations.SerializedName

class OptionDto(
    @SerializedName("club_name") private val clubName: String,
    @SerializedName("link_android") private val linkAndroid: String,
    @SerializedName("link_ios") private val linkIos: String,
    @SerializedName("primary_color") private val primaryColor: String,
    @SerializedName("secondary_color") private val secondaryColor: String,
) {
    fun toOption() = Option(clubName, linkAndroid, linkIos, primaryColor, secondaryColor)
}
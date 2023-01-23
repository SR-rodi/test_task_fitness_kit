package com.example.fitnesskit.feature.data.dto.child

import com.example.fitnesskit.feature.domaine.model.childe.Option
import com.google.gson.annotations.SerializedName

class OptionDto(
    @SerializedName("club_name") val clubName: String,
    @SerializedName("link_android") val linkAndroid: String,
    @SerializedName("link_ios") val linkIos: String,
    @SerializedName("primary_color") val primaryColor: String,
    @SerializedName("secondary_color") val secondaryColor: String,
) {
    fun toOption() = Option(clubName, linkAndroid, linkIos, primaryColor, secondaryColor)
}
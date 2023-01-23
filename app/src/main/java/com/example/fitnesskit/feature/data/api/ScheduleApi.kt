package com.example.fitnesskit.feature.data.api

import com.example.fitnesskit.feature.data.dto.ScheduleDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ScheduleApi {

    @GET("schedule/get_v3/")
    suspend fun getScheduleByClubId(@Query("club_id") clubId: Int): ScheduleDto
}
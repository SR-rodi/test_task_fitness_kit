package com.example.fitnesskit.feature.data.dto

import com.example.fitnesskit.feature.data.dto.child.LessonDto
import com.example.fitnesskit.feature.data.dto.child.OptionDto
import com.example.fitnesskit.feature.data.dto.child.TabDto
import com.example.fitnesskit.feature.data.dto.child.TrainerDto
import com.example.fitnesskit.feature.domaine.model.Schedule

class ScheduleDto(
    val lessons: List<LessonDto>,
    val option: OptionDto,
    val tabs: List<TabDto>,
    val trainers: List<TrainerDto>,
) {
    fun toSchedule() = Schedule(
        option.clubName,
        option.linkAndroid,
        option.linkIos,
        option.primaryColor,
        option.secondaryColor
    )
}
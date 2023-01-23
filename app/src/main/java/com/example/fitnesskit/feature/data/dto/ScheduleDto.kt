package com.example.fitnesskit.feature.data.dto

import com.example.fitnesskit.core.toMapTrainer
import com.example.fitnesskit.feature.data.dto.child.LessonDto
import com.example.fitnesskit.feature.data.dto.child.OptionDto
import com.example.fitnesskit.feature.data.dto.child.TrainerDto
import com.example.fitnesskit.feature.domaine.model.Schedule

class ScheduleDto(
    private val lessons: List<LessonDto>,
    private val option: OptionDto,
    private val trainers: List<TrainerDto>,
) {
    fun toSchedule() = Schedule(
        option.toOption(),
        lessons.map { lesson -> lesson.toLesson() },
        trainers.toMapTrainer()
    )
}
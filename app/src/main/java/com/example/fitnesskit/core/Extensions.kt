package com.example.fitnesskit.core

import com.example.fitnesskit.feature.data.dto.child.TrainerDto
import com.example.fitnesskit.feature.domaine.model.Schedule
import com.example.fitnesskit.feature.domaine.model.childe.Trainer
import com.example.fitnesskit.feature.presentation.model.ScheduleCard

fun List<TrainerDto>.toMapTrainer(): MutableMap<String, Trainer> {
    val newMap = mutableMapOf<String, Trainer>()
    this.forEach { trainer ->
        newMap[trainer.id] = trainer.toTrainer()
    }
    return newMap
}

@Suppress("UNUSED_EXPRESSION")
fun Schedule.toListScheduleCard(): List<ScheduleCard> = this.lessons.map { lesson ->
    ScheduleCard(
        this.trainers[lesson.coachId]?.fullName ?: "N/A",
        lesson.tab,
        lesson.startTime,
        lesson.endTime,
        lesson.place
    )
}

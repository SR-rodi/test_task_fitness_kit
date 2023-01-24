package com.example.fitnesskit.core

import android.annotation.SuppressLint
import com.example.fitnesskit.feature.data.dto.child.TrainerDto
import com.example.fitnesskit.feature.domaine.model.Schedule
import com.example.fitnesskit.feature.domaine.model.childe.Lesson
import com.example.fitnesskit.feature.domaine.model.childe.Trainer
import com.example.fitnesskit.feature.presentation.model.ScheduleCardDateUiModel
import com.example.fitnesskit.feature.presentation.model.ScheduleCardUiModel
import com.example.fitnesskit.feature.presentation.model.ScheduleUi
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun List<TrainerDto>.toMapTrainer(): MutableMap<String, Trainer> {
    val newMap = mutableMapOf<String, Trainer>()
    this.forEach { trainer ->
        newMap[trainer.id] = trainer.toTrainer()
    }
    return newMap
}

@Suppress("UNUSED_EXPRESSION")
fun Schedule.toListScheduleUi(): List<ScheduleUi> {
    this.lessons = this.lessons.sortedBy { lesson -> lesson.date }
    var currentDate = this.lessons.first().date

    return this.lessons.mapIndexed { index, lesson ->
        if (index == 0 || currentDate != lesson.date) {
            currentDate = lesson.date
            ScheduleCardDateUiModel(
                this.trainers[lesson.coachId]?.fullName ?: "N/A",
                lesson.tab,
                lesson.startTime,
                lesson.endTime,
                lesson.place,
                lesson.color,
                lesson.getDateByFormat()
            )
        } else
            ScheduleCardUiModel(
                this.trainers[lesson.coachId]?.fullName ?: "N/A",
                lesson.tab,
                lesson.startTime,
                lesson.endTime,
                lesson.place,
                lesson.color
            )
    }
}

@SuppressLint("SimpleDateFormat")
fun Lesson.getDateByFormat(): String {
    val formatter: DateFormat = SimpleDateFormat("yyyy-MM-DD")
    val date: Date = formatter.parse(this.date) as Date
    val newFormat = SimpleDateFormat("EEEE, dd MMMM")
    return newFormat.format(date).replaceFirstChar(Char::titlecase)
}
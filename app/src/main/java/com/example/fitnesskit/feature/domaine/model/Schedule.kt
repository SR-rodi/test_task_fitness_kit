package com.example.fitnesskit.feature.domaine.model

import com.example.fitnesskit.feature.domaine.model.childe.Lesson
import com.example.fitnesskit.feature.domaine.model.childe.Option
import com.example.fitnesskit.feature.domaine.model.childe.Trainer

class Schedule(
    val option: Option,
    var lessons: List<Lesson>,
    val trainers: Map<String,Trainer>,
)
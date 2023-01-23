package com.example.fitnesskit.feature.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnesskit.databinding.FragmentScheduleBinding
import com.example.fitnesskit.databinding.ItemScheduleBinding
import com.example.fitnesskit.feature.presentation.model.ScheduleCard

class ScheduleAdapter(private val items: List<ScheduleCard>) :
    RecyclerView.Adapter<ScheduleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ScheduleViewHolder(
        ItemScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(items[position])
    }
}

class ScheduleViewHolder(private val binding: ItemScheduleBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ScheduleCard) {
        binding.apply {
            couch.text = item.trainerName
            startTime.text = item.startTime
            endTime.text = item.endTime
            work.text = item.workoutName
            location.text = item.studio
        }
    }
}
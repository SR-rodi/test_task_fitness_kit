package com.example.fitnesskit.feature.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.fitnesskit.core.BaseFragment
import com.example.fitnesskit.databinding.FragmentScheduleBinding
import com.example.fitnesskit.feature.presentation.adapter.ScheduleAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScheduleFragment : BaseFragment<FragmentScheduleBinding>() {

    private val viewModel by viewModel<ScheduleViewModel>()

    private val adapter by lazy { ScheduleAdapter() }

    override fun initBinding(inflater: LayoutInflater) = FragmentScheduleBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scheduleObserve()
    }

    private fun scheduleObserve() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.schedule.collect { schedule ->
                adapter.items = schedule
                binding.scheduleRecycler.adapter = adapter
            }
        }
    }

}
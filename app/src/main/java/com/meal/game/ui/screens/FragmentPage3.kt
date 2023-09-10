package com.meal.game.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.meal.game.databinding.FragmentPage3Binding
import com.meal.game.ui.container.ContainerViewModel
import com.meal.game.ui.other.ViewBindingFragment

class FragmentPage3: ViewBindingFragment<FragmentPage3Binding>(FragmentPage3Binding::inflate) {
    private val viewModel: ContainerViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonBack.setOnClickListener {
            viewModel.changePage(2)
        }
        binding.buttonForward.setOnClickListener {
            viewModel.changePage(4)
        }
    }
}
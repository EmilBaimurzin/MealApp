package com.meal.game.ui.screens

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.meal.game.databinding.FragmentHomeBinding
import com.meal.game.ui.container.ContainerViewModel
import com.meal.game.ui.other.ViewBindingFragment

class FragmentHome: ViewBindingFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel: ContainerViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.readMoreButton.setOnClickListener {
            viewModel.changePage(2)
        }

        binding.privacyText.setOnClickListener {
            requireActivity().startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com")
                )
            )
        }
    }
}
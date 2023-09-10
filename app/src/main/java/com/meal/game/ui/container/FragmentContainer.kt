package com.meal.game.ui.container

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.meal.game.databinding.FragmentContainerBinding
import com.meal.game.domain.ContainerAdapter
import com.meal.game.ui.other.ViewBindingFragment
import com.meal.game.ui.screens.FragmentHome
import com.meal.game.ui.screens.FragmentLastPage
import com.meal.game.ui.screens.FragmentPage2
import com.meal.game.ui.screens.FragmentPage3
import com.meal.game.ui.screens.FragmentPage4
import com.meal.game.ui.screens.FragmentPage5
import com.meal.game.ui.screens.FragmentPage6
import com.meal.game.ui.screens.FragmentPage7

class FragmentContainer :
    ViewBindingFragment<FragmentContainerBinding>(FragmentContainerBinding::inflate) {
    private val callback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            viewModel.setPage(position)
        }
    }
    private val viewModel: ContainerViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.changePageCallback = {
            binding.viewPager.currentItem = it - 1
        }

        binding.viewPager.adapter =
            ContainerAdapter(
                childFragmentManager,
                lifecycle,
                arrayListOf(
                    FragmentHome(),
                    FragmentPage2(),
                    FragmentPage3(),
                    FragmentPage4(),
                    FragmentPage5(),
                    FragmentPage6(),
                    FragmentPage7(),
                    FragmentLastPage()
                )
            )
        binding.viewPager.registerOnPageChangeCallback(callback)
    }

    override fun onPause() {
        super.onPause()
        binding.viewPager.unregisterOnPageChangeCallback(callback)
    }
}
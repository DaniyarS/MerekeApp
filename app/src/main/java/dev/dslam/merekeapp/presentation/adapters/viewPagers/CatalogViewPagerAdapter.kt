package dev.dslam.merekeapp.presentation.adapters.viewPagers

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.dslam.merekeapp.presentation.fragments.catalog.*

class CatalogViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle)
: FragmentStateAdapter(fragmentManager, lifecycle) {

    companion object {
        private const val NUM_OF_PAGES = 5
    }

    override fun getItemCount(): Int = NUM_OF_PAGES

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return VenuesFragment()
            1 -> return SingersFragment()
            2 -> return ShowmansFragment()
            3 -> return DancersFragment()
        }
        return MusiciansFragment()
    }
}

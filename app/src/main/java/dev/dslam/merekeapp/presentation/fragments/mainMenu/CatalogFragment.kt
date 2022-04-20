package dev.dslam.merekeapp.presentation.fragments.mainMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dev.dslam.merekeapp.R
import dev.dslam.merekeapp.databinding.FragmentCatalogBinding
import dev.dslam.merekeapp.models.Category
import dev.dslam.merekeapp.presentation.adapters.viewPagers.CatalogViewPagerAdapter
import dev.dslam.merekeapp.utils.Constants.CATEGORY

class CatalogFragment : Fragment(R.layout.fragment_catalog) {

    private var _binding: FragmentCatalogBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCatalogBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CatalogViewPagerAdapter(childFragmentManager, lifecycle)
        val arg = requireArguments().getParcelable<Category>(CATEGORY)

        binding.viewPager.adapter = adapter
        if (arg != null) {
            binding.viewPager.currentItem = arg.id
        }

        setupTabLayout()
    }

    private fun setupTabLayout() {
        TabLayoutMediator(binding.viewPagerTab, binding.viewPager) { tab, position ->
            tab.text = when(position) {
                0 -> getString(R.string.str_venues)
                1 -> getString(R.string.str_singers)
                2 -> getString(R.string.str_showmans)
                3 -> getString(R.string.str_dancers)
                4 -> getString(R.string.str_musicians)
                else -> {""}
            }
        }.attach()

        binding.viewPagerTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.currentItem = binding.viewPagerTab.selectedTabPosition
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) { }

            override fun onTabReselected(tab: TabLayout.Tab?) { }
        })

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.viewPagerTab.selectTab(binding.viewPagerTab.getTabAt(position))
            }
        })
    }
}

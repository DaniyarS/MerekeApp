package dev.dslam.merekeapp.presentation.adapters.viewPagers

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import dev.dslam.merekeapp.presentation.fragments.mainMenu.DetailsImageFragment
import dev.dslam.merekeapp.models.Image

class ViewPagerAdapter(fm: FragmentManager)
    : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val images: MutableList<Image> = mutableListOf()

    override fun getItem(position: Int): Fragment {
        return DetailsImageFragment.newInstance(images[position])
    }

    override fun getCount(): Int {
        return images.size
    }

    fun setImages(images: List<Image>) {
        this.images.addAll(images)
    }
}

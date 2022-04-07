package dev.dslam.merekeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.dslam.merekeapp.databinding.ActivityMainBinding
import dev.dslam.merekeapp.fragments.HomeFragment
import dev.dslam.merekeapp.fragments.constants.Constants
import dev.dslam.merekeapp.fragments.details.SingerDetailsFragment
import dev.dslam.merekeapp.fragments.details.VenueDetailsFragment
import dev.dslam.merekeapp.models.Category
import dev.dslam.merekeapp.models.Singer
import dev.dslam.merekeapp.models.Venue

class MainActivity : AppCompatActivity(), HomeFragment.OnItemSelected {

    private lateinit var navController: NavController
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var binding: ActivityMainBinding
    private val mainContainerFragment: Int = R.id.containerFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.containerFragment) as NavHostFragment

        this.navController = navHostFragment.navController

        bottomNavigation = findViewById(R.id.bottomNav)
        bottomNavigation.setupWithNavController(this.navController)
    }

    override fun onSingerSelected(singer: Singer) {
        val singerDetailsFragment = SingerDetailsFragment.newInstance(singer)
        pushFragment(mainContainerFragment, singerDetailsFragment, "singerDetails")
    }

    override fun onVenueSelected(venue: Venue) {
        val venueDetailsFragment = VenueDetailsFragment.newInstance(venue)
        pushFragment(mainContainerFragment, venueDetailsFragment, "venueDetails")
    }

    override fun onViewAllClicked(categoryId: Int) {
        val bundle = bundleOf(Constants.CATEGORY_ID to categoryId)

        val navOptions = NavOptions.Builder()
            .setPopUpTo(R.id.homeFragment, inclusive = false, saveState = true)
            .setRestoreState(true)
            .build()

        navController.navigate(R.id.catalogFragment, bundle, navOptions)
    }

    private fun pushFragment(fragmentFrom: Int, fragmentTo: Fragment, key: String) {

        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.slide_out
            )
            .replace(fragmentFrom, fragmentTo, key)
            .addToBackStack(null)
            .commit()
    }
}

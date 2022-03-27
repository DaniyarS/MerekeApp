package dev.dslam.merekeapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.dslam.merekeapp.databinding.ActivityMainBinding
import dev.dslam.merekeapp.fragments.HomeFragment
import dev.dslam.merekeapp.fragments.details.SingerDetailsFragment
import dev.dslam.merekeapp.fragments.details.VenueDetailsFragment
import dev.dslam.merekeapp.models.Category
import dev.dslam.merekeapp.models.Singer
import dev.dslam.merekeapp.models.Venue

class MainActivity : AppCompatActivity(), HomeFragment.OnItemSelected {

    private lateinit var navController: NavController
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var binding: ActivityMainBinding
    private val detailsFragmentContainer: Int = R.id.detailsFragmentContainer
    private val mainContainerFragment: Int = R.id.containerFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.containerFragment) as NavHostFragment

        this.navController = navHostFragment.navController

        bottomNavigation = findViewById(R.id.bottomNav)
        bottomNavigation.setupWithNavController(this.navController)
    }

    override fun onSingerSelected(singer: Singer) {
        val singerDetailsFragment = SingerDetailsFragment.newInstance(singer)
        pushFragment(detailsFragmentContainer, singerDetailsFragment, "singerDetails")
    }

    override fun onVenueSelected(venue: Venue) {
        val venueDetailsFragment = VenueDetailsFragment.newInstance(venue)
        pushFragment(detailsFragmentContainer, venueDetailsFragment, "venueDetails")
    }

    override fun onViewAllClicked(category: Category) {
        val bundle = bundleOf("CATEGORY_ID" to category.id)
        navController.navigate(R.id.catalogFragment, bundle)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        binding.detailsFragmentContainer.visibility = View.GONE
        binding.containerFragment.visibility = View.VISIBLE
        binding.bottomNav.visibility = View.VISIBLE
    }

    private fun pushFragment(fragmentFrom: Int, fragmentTo: Fragment, key: String) {

        if (fragmentFrom == R.id.detailsFragmentContainer) {
            binding.detailsFragmentContainer.visibility = View.VISIBLE
            binding.containerFragment.visibility = View.GONE
            binding.bottomNav.visibility = View.GONE
        }

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

//        (R.anim.slide_in,
//        R.anim.fade_out,
//        R.anim.fade_in,
//        R.anim.slide_out
//        )
    }
}

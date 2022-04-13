package dev.dslam.merekeapp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.navArgs
import dev.dslam.merekeapp.databinding.ActivityVenueDetailsBinding
import dev.dslam.merekeapp.presentation.adapters.viewPagers.ViewPagerAdapter

class VenueDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVenueDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVenueDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val args = navArgs<VenueDetailsActivityArgs>()
        val venue = args.value.venue
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        venue.images.let { viewPagerAdapter.setImages(it) }

        with(binding) {
            productImageViewPager.adapter = viewPagerAdapter
            tabLayout.setupWithViewPager(binding.productImageViewPager)

            venueName.text = venue.name
            venueDescription.text = venue.description
            kitchen.text = venue.information.kitchen
            averageCheck.text = venue.information.averageCheck
            workingTime.text = venue.information.workingTime
            placeQuantity.text = venue.information.quantityPlace.toString()
            address.text = venue.address
            smokingArea.text = venue.extraFeatures.smokingArea
            karaoke.text = venue.extraFeatures.karaoke
            parking.text = venue.extraFeatures.parkingArea

            backButton.setOnClickListener {
                val activity = this@VenueDetailsActivity
                activity.finish()
            }
        }
    }
}

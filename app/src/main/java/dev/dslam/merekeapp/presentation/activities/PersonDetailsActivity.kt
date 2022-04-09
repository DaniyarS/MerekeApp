package dev.dslam.merekeapp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.navArgs
import dev.dslam.merekeapp.R
import dev.dslam.merekeapp.databinding.ActivityPersonDetailsBinding
import dev.dslam.merekeapp.models.Singer
import dev.dslam.merekeapp.presentation.adapters.ViewPagerAdapter

class PersonDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val args = navArgs<PersonDetailsActivityArgs>()
        val person = args.value.person
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        person.images.let { viewPagerAdapter.setImages(it) }

        with(binding) {
            productImageViewPager.adapter = viewPagerAdapter
            tabLayout.setupWithViewPager(binding.productImageViewPager)
            personName.text = person.name
            description.text = person.description
            backButton.setOnClickListener {
                val activity = this@PersonDetailsActivity
                activity.finish()
            }
        }

        when(person) {
            is Singer -> {
                binding.about.text = getString(R.string.str_about_singer)
            }
        }
    }
}
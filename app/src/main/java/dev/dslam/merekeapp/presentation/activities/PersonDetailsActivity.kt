package dev.dslam.merekeapp.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.ActivityNavigator
import androidx.navigation.navArgs
import dev.dslam.merekeapp.R
import dev.dslam.merekeapp.databinding.ActivityPersonDetailsBinding
import dev.dslam.merekeapp.models.Showman
import dev.dslam.merekeapp.models.Singer
import dev.dslam.merekeapp.presentation.adapters.viewPagers.ViewPagerAdapter
import dev.dslam.merekeapp.presentation.viewModels.PersonAction
import dev.dslam.merekeapp.presentation.viewModels.PersonState
import dev.dslam.merekeapp.presentation.viewModels.PersonViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PersonDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonDetailsBinding
    private val personViewModel: PersonViewModel by viewModel()

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

            shareButton.setOnClickListener {
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(Intent.EXTRA_TEXT, person.toString())
                sendIntent.type = "text/plain"
                startActivity(sendIntent)
            }

            saveButton.setOnClickListener {
                personViewModel.dispatch(PersonAction.SavePerson(person))
            }

            addToCartButton.setOnClickListener {

                val intent = Intent(this@PersonDetailsActivity, OrderActivity::class.java)
                intent.putExtra("PERSON", person)

                val nav = ActivityNavigator(this@PersonDetailsActivity)
                    .createDestination()
                    .setIntent(intent)

                ActivityNavigator(this@PersonDetailsActivity).navigate(
                    nav,
                    null,
                    null,
                    null
                )
            }

            about.text = when (person) {
                is Singer -> getString(R.string.str_about_artist)
                is Showman -> getString(R.string.str_about_showman)
                else -> getString(R.string.str_about)
            }
        }

        when (person) {
            is Singer -> {
                binding.about.text = getString(R.string.str_about_singer)
            }
        }

        configureObservers()
    }

    private fun configureObservers() {
        personViewModel.state.observe(this) {
            when (it) {
                is PersonState.PersonSaved -> {
                    binding.saveButton.setImageResource(R.drawable.ic_fav_pressed)
                    Toast.makeText(this, "Сохранили в Избранные", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

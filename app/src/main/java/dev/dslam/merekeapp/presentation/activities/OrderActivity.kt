package dev.dslam.merekeapp.presentation.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import dev.dslam.merekeapp.MainActivity
import dev.dslam.merekeapp.databinding.ActivityOrderBinding
import dev.dslam.merekeapp.models.Order
import dev.dslam.merekeapp.models.Person
import dev.dslam.merekeapp.presentation.viewModels.OrderAction
import dev.dslam.merekeapp.presentation.viewModels.OrderState
import dev.dslam.merekeapp.presentation.viewModels.OrderViewModel
import dev.dslam.merekeapp.utils.transformIntoDatePicker
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderBinding
    private lateinit var person: Person
    private val orderViewModel: OrderViewModel by viewModel()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setProduct()

        binding.backButton.setOnClickListener {
            this.onBackPressed()
        }

        binding.bookButton.setOnClickListener {
            if (!binding.bookTimeTextView.text.isNullOrBlank() && !binding.dateTextView.text.isNullOrBlank()) {
                handleBooking(
                    person,
                    binding.dateTextView.text.toString(),
                    binding.bookTimeTextView.text.toString()
                )
            }
        }

        configureObservers()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setProduct() {
        if (intent.hasExtra("PERSON")) {
            person = intent.getParcelableExtra("PERSON")!!

            Glide
                .with(binding.root)
                .load(person.images[0].imageUrl)
                .centerCrop()
                .into(binding.productImageView)

            binding.orderNameTextView.text = person.name
            binding.ordersDescription.text = person.description
        } else {
            binding.producContainer.isVisible = false
        }

        binding.dateTextView.transformIntoDatePicker(this, "dd/MM/yyyy")
    }

    private fun handleBooking(person: Person, date: String, time: String) {
        orderViewModel.dispatch(
            OrderAction.BookOrder(
                Order(
                    id = person.id.toString(),
                    name = person.name,
                    description = person.description,
                    date = date,
                    time = time,
                    image = person.images[0].imageUrl
                )
            )
        )
    }

    private fun configureObservers() {
        orderViewModel.state.observe(this) {
            when (it) {
                is OrderState.BookOrdered -> {
                    Toast.makeText(this, "Услуга забронирована", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
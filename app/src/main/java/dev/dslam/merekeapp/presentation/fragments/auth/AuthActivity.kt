package dev.dslam.merekeapp.presentation.fragments.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.dslam.merekeapp.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onBackPressed() {
        //super.onBackPressed()
    }
}
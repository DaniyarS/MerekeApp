package dev.dslam.merekeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.dslam.merekeapp.databinding.ActivityMainBinding
import dev.dslam.merekeapp.utils.Utils

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Utils.isAuthorized(context = this)) this.navController.navigate(R.id.signInFragment)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.containerFragment) as NavHostFragment

        this.navController = navHostFragment.navController

        bottomNavigation = findViewById(R.id.bottomNav)
        bottomNavigation.setupWithNavController(this.navController)
    }
}

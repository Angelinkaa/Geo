package ru.gb.geo.geonote.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import ru.gb.geo.geonote.R
import ru.gb.geo.geonote.databinding.ActivityMapsBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.main_activity_fragment_container) as NavHostFragment
        setupActionBarWithNavController(
            navHostFragment.navController,
            AppBarConfiguration(
                setOf(
                    R.id.navigation_map,
                    R.id.navigation_markers,
                )
            )
        )
        binding.mainActivityBottomNavigation
            .setupWithNavController(navHostFragment.navController)
    }

}
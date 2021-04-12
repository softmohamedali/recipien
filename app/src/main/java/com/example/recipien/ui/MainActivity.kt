package com.example.recipien.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.recipien.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val x=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        navController=findNavController(R.id.main_nav)
        val appBarConfig= AppBarConfiguration(setOf(
            R.id.recipienFrafment,
            R.id.favioretFragment,
            R.id.jokeFragment
        ))
        x.setupWithNavController(navController)
        setupActionBarWithNavController(navController,appBarConfig)


    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp() || navController.navigateUp()
    }

}
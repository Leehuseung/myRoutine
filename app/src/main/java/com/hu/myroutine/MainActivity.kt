package com.hu.myroutine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.hu.myroutine.databinding.ActivityMainBinding
import com.hu.myroutine.databinding.NavHeaderMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val topAppBar = binding.appBarMain.topAppBar

        val navHeaderView = binding.navView.getHeaderView(0)
        val navHeaderBinding = NavHeaderMainBinding.bind(navHeaderView)

        navHeaderBinding.addExercise.setOnClickListener {
            val intent = Intent(this,ExerciseAddActivity::class.java)
            startActivity(intent)
        }

        ActionBarDrawerToggle(this, drawerLayout, topAppBar, 0, 0)
    }
}
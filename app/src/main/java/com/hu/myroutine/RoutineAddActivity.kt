package com.hu.myroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hu.myroutine.databinding.ActivityRoutineAddBinding

class RoutineAddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoutineAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoutineAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val topAppBar = binding.addRoutineBarMain.topAppBar

        topAppBar.setNavigationOnClickListener{
            finish()
        }

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.confirm -> {
                    true
                }
                else -> false
            }
        }


    }
}
package com.hu.myroutine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hu.myroutine.databinding.ActivityExerciseAddBinding

class ExerciseAddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val topAppBar = binding.addExerciseBarMain.topAppBar

        topAppBar.setNavigationOnClickListener{
            finish()
        }

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.confirm -> {
                    Toast.makeText(applicationContext,"운동 등록하기",Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}
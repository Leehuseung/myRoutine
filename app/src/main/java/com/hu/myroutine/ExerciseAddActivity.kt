package com.hu.myroutine

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
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
                    val exercise = binding.addExerciseBarMain.exerciseAddMain.exerciseInput.text.toString()

                    if(exercise == ""){
                        Toast.makeText(applicationContext,"추가할 운동을 입력해주세요.",Toast.LENGTH_SHORT).show()
                    } else {
                        val returnIntent = Intent()
                        returnIntent.putExtra("exercise",exercise)
                        setResult(Activity.RESULT_OK,returnIntent)
                        finish()
                    }
                    true
                }
                else -> false
            }
        }
    }
}
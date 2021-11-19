package com.hu.myroutine

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        defaultHeaderUiSetting()
    }

    private fun defaultHeaderUiSetting(){
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val topAppBar = binding.appBarMain.topAppBar

        val navHeaderView = binding.navView.getHeaderView(0)
        val navHeaderBinding = NavHeaderMainBinding.bind(navHeaderView)

        //운동추가 event bindg
        navHeaderBinding.addExercise.setOnClickListener {
            val intent = Intent(this,ExerciseAddActivity::class.java)
            startActivityForResult(intent,99)
        }

        //우측상단 nav 버튼 toggle 동작하도록 변경
        ActionBarDrawerToggle(this, drawerLayout, topAppBar, 0, 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            when(requestCode) {
                //운동 추가
                99 -> {
                    Toast.makeText(applicationContext,data?.getStringExtra("exercise") + "을 추가합니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
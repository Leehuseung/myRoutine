package com.hu.myroutine

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.hu.myroutine.databinding.ActivityMainBinding
import com.hu.myroutine.databinding.NavHeaderMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //다른 Activity에서 넘어올 경우 callback
    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            Toast.makeText(applicationContext,data?.getStringExtra("exercise") + "을 추가합니다.", Toast.LENGTH_SHORT).show()
        }
    }

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
            resultLauncher.launch(intent)
        }

        //우측상단 nav 버튼 toggle 동작하도록 변경
        ActionBarDrawerToggle(this, drawerLayout, topAppBar, 0, 0)
    }

}
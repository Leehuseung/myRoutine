package com.hu.myroutine

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.hu.myroutine.databinding.ActivityMainBinding
import com.hu.myroutine.databinding.NavHeaderMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navView: NavigationView
    private lateinit var menu: Menu
    private val menuList = mutableListOf<Exercise>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        navView = binding.navView
        menu = navView.menu
        setContentView(binding.root)

        menuList.add(Exercise(1,"1번운동",1))
        menuList.add(Exercise(2,"2번운동",2))
        menuList.add(Exercise(3,"3번운동",3))

        defaultHeaderUiSetting()
    }

    //다른 Activity에서 넘어올 경우 callback
    private var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data

            //exercise를 만든다.
            menuList.add(Exercise(menuList.size,data?.getStringExtra("exercise").toString(),menuList.size))

            //menu list에 추가해준다.
            menu.add(0,menuList.get(menuList.size-1).id,menuList.get(menuList.size-1).order,menuList.get(menuList.size-1).name)
            Toast.makeText(applicationContext,data?.getStringExtra("exercise") + "을 추가합니다.", Toast.LENGTH_SHORT).show()
        }
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
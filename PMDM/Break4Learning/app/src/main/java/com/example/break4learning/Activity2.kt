package com.example.break4learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.break4learning.databinding.ActivityMainBinding

class Activity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        setSupportActionBar(binding.toolbar.toolbarApp2)
    }
}
package com.example.menucontextual2023_2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.menucontextual2023_2024.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crearObjetosDelXML()
    }

    private fun crearObjetosDelXML() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
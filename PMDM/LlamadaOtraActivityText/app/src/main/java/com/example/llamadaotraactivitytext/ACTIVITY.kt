package com.example.llamadaotraactivitytext

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import com.example.llamadaotraactivitytext.databinding.ActivityMainBinding



class ACTIVITY : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crearObjetosDelXML()
    }

    private fun crearObjetosDelXML(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun openSomeActivityForResultData(view: View) {
        val intent = Intent(this, ActivityDevel::class.java)
        activityResultLauncher.launch(intent)
    }
}
package com.example.preferencias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.preferencias.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var activityResourceLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crearObjetosDelXml()

        loadPref()

        activityResourceLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                loadPref()
            }
    }

    private fun crearObjetosDelXml() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun loadPref() {
        val mySharedPreferences = getSharedPreferences(packageName + "_preferences", MODE_PRIVATE)
        binding.textViewMoneda.text = mySharedPreferences.getString("moneda", "No hay moneda")

    }

    fun abrirPreferencias(view: View) {
        val intent = Intent(this, SettingsActivity::class.java)
        activityResourceLauncher.launch(intent)
    }
}
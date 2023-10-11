package com.example.comunicacionactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class devuelveDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devuelve_datos)
    }

    fun volver(view: View) {
        val intent = Intent()
        intent.putExtra("mensaje", binding.editText.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }
}
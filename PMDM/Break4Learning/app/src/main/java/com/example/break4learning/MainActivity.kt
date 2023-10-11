package com.example.break4learning

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.break4learning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crearObjetosDelXML()

        setSupportActionBar(binding.toolbar.toolbarApp2)

        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    private fun crearObjetosDelXML(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean{
        menuInflater.inflate(R.menu.menu_main_activity1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        return when(item.itemId){
            R.id.acercaDe -> {
                lanzarAcercaDe()
                true
            }
            R.id.Contactar_telefono -> {
                llamarTelefono()
                true
            }
            R.id.Web -> {
                abrirPagina()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun lanzarAcercaDe(){
        Toast.makeText(this, "Break4Learning v1.0", Toast.LENGTH_LONG).show()
    }

    fun llamarTelefono(){
        startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:555123456")))
    }

    fun abrirPagina(){
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com")))
    }
}
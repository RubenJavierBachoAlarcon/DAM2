package com.example.break4learning

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
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

    private fun crearObjetosDelXML() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
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

            R.id.Contactar_mail -> {
                mandarCorreo()
                true
            }

            R.id.Ubica -> {
                verMapa()
                true
            }

            R.id.Compartir_App -> {
                compartir()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun lanzarAcercaDe() {
        Toast.makeText(this, "Break4Learning v1.0", Toast.LENGTH_LONG).show()
    }

    fun llamarTelefono() {
        startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:555123456")))
    }

    fun abrirPagina() {
        startActivity(
            Intent(
                Intent.ACTION_VIEW, Uri.parse("http://www.google.com")
            )
        )
    }

    fun mandarCorreo() {
        startActivity(Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "Correo de prueba")
            putExtra(
                Intent.EXTRA_TEXT, "Esto es un mensaje de prueba para la asignatura de ProgMult."
            )
            putExtra(Intent.EXTRA_EMAIL, arrayOf("javierbacho1@gmail.com"))
        })
    }

    fun verMapa() {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("geo:41.656313,-0.877351")))
    }

    fun compartir(){
        startActivity(
            Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "Compartir App")
                putExtra(Intent.EXTRA_TEXT, "Te recomiendo esta app")
            }
        )
    }

    fun iniciarActivity2(view: View) {
        startActivity(Intent(this, Activity2::class.java))
    }
}

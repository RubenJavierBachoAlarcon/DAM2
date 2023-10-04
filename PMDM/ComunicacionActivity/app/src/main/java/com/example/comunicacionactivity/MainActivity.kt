package com.example.comunicacionactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.comunicacionactivity.databinding.ActivityMainBinding

/**
 * Demostracion de apertura de activities desde otra activity
 *
 * 1) Apertura normal
 *
 * @author Javier
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crearObjetosDelXML()
        // Resto del código de onCreate
    }

    /**
     * Crea los objetos del XML
     */
    private fun crearObjetosDelXML(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    /**
     * Apertura normal de una activity
     * Abre la activity MainActivity2
     *
     * @param view View que llama al metodo
     */
    fun openSomeActivity(view : View) {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    fun openSomeActivityData(view: View) {
        val mensaje = "Hola, esta es una prueba de envío de datos."
        val intent = Intent(this, RecibeDatos::class.java)
        intent.putExtra("mensaje", mensaje) // Aquí pasamos el mensaje como dato
        startActivity(intent)
    }

    fun openSomeActivityForResult(view: View){
        val intent = Intent(this, MainActivity2::class.java)
        activityResultLauncher.launch(intent)
    }

}

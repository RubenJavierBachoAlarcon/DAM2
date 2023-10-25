package com.example.cloudfirestore

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cloudfirestore.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // Firebase
    private val db = FirebaseFirestore.getInstance()
    private val myCollection = db.collection("empresas")

    //Visualizacion tiempo real
    private lateinit var registration: ListenerRegistration
    private var escuchando: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        crearObjetosDelXml()

        // Mover la llamada a guardarDatos() aquí, después de la inflación de la vista
        binding.buttonGuardar.setOnClickListener {
            guardarDatos()
        }

        binding.buttonCargar.setOnClickListener {
            cargarDatos()
        }

        binding.buttonEliminar.setOnClickListener {
            eliminarRegistro()
        }

        binding.buttonTraerTodos.setOnClickListener {
            listarTodos()
        }

        binding.buttonTraerTodos.setOnClickListener {
            listarTodos()
        }

        binding.buttonTiempoReal.setOnClickListener {
            activarTiempoReal()
        }
    }

    private fun crearObjetosDelXml() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun guardarDatos() {
        myCollection.document(binding.editTextNif.text.toString()).set(
            hashMapOf(
                "nombre" to binding.editTextNombre.text.toString(),
                "direccion" to binding.editTextDireccion.text.toString()
            )
        ).addOnSuccessListener { Log.d("FIREBASE", "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w("FIREBASE", "Error writing document", e) }

        resultadoOperacion("Registro guardado correctamente")
    }

    private fun cargarDatos() {
        myCollection.document(binding.editTextNif.text.toString()).get()
            .addOnSuccessListener { document ->
                if (document.exists()) {L
                    binding.editTextNombre.setText(document.get("nombre").toString())
                    binding.editTextDireccion.setText(document.get("direccion").toString())

                    resultadoOperacion("Registro cargado correctamente")
                } else {
                    resultadoOperacion("No existe el registro")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("FIREBASE", "get failed with ", exception)
            }
    }

    private fun eliminarRegistro() {
        myCollection.document(binding.editTextNif.text.toString()).delete()

        resultadoOperacion("Registro eliminado correctamente")
    }

    private fun listarTodos() {
        myCollection
            .get()
            .addOnSuccessListener { document ->
                binding.textViewLista.setText("")
                for (it in document) {
                    binding.textViewLista.append(
                        it.get("nombre").toString() + "\n" +
                                it.get("direccion").toString() + "\n"
                    )
                }
            }
    }

    private fun listarConFiltro() {
        myCollection
            .whereEqualTo("direccion", binding.editTextDireccion.text.toString())
            .get()
            .addOnSuccessListener { document ->
                binding.textViewLista.setText("")
                for (it in document) {
                    binding.textViewLista.append(
                        it.get("nombre").toString() + "\n" +
                                it.get("direccion").toString() + "\n"
                    )
                }
            }
    }

    private fun activarTiempoReal() {
        val docRef = myCollection.document("Empresa")
        val TAG = "FIREBASE"

        if (this.escuchando) {


            registration.remove()
            this.escuchando = false
        } else {

            registration = docRef.addSnapshotListener(this) { snapshot, e ->
                if (e != null) {
                    return@addSnapshotListener
                }

                if (snapshot != null && snapshot.exists()) {
                    binding.editTextNombre.setText(snapshot.get("nombre").toString())
                    binding.editTextDireccion.setText(snapshot.get("direccion").toString())
                    Log.d(TAG, "Current data: ${snapshot.data}")
                } else {
                    Log.d(TAG, "Current data: null")
                }
            }
            this.escuchando = true
        }
    }

    private fun resultadoOperacion(mensaje: String) {
        binding.editTextNif.setText("")
        binding.editTextNombre.setText("")
        binding.editTextDireccion.setText("")
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }

}

package com.example.firebaserecycledview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebaserecycledview.adapter.*
import com.example.firebaserecycledview.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    val db = Firebase.firestore
    private val myCollection = db.collection("productos")

    private lateinit var productoProvider: ProductoProvider
    private lateinit var productoAdapter: ProductosAdapter
    val manager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("Firestore", "onCreate")

        crearObjetosDelXml()

        initRecyclerView()

        binding.buttonInsertar.setOnClickListener {
            llamarActivity2()
        }

        val activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val producto = Producto(
                    siguienteId(),
                    data?.getStringExtra("nombre")!!,
                    data.getStringExtra("descripcion")!!,
                    data.getStringExtra("foto")!!
                )
                insertRegister(producto)
            }
        }
    }

    private fun crearObjetosDelXml() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun llamarActivity2() {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    private fun siguienteId(): Int {
        return productoProvider.mutableList.size
    }

    private fun initRecyclerView() {
        val decoration = DividerItemDecoration(this, manager.orientation)

        binding.recyclerProductos.layoutManager = manager
        productoProvider = ProductoProvider()
        productoAdapter = ProductosAdapter(productoProvider.mutableList)

        myCollection
            .get()
            .addOnSuccessListener { resultado ->
                productoProvider.actualizarLista(resultado)
                binding.recyclerProductos.adapter = productoAdapter
                binding.recyclerProductos.addItemDecoration(decoration)
            }
        Log.d("Firestore", "initRecyclerView")
    }

    private fun insertRegister(producto: Producto) {
        myCollection
            .document(producto.id.toString())
            .set(
                hashMapOf(
                    "nombre" to producto.nombre,
                    "descripcion" to producto.descripcion,
                    "foto" to producto.foto
                )
            )
            .addOnSuccessListener {
                productoProvider.mutableList.add(producto.id, producto)
                productoAdapter.notifyItemInserted(producto.id)
                Log.d("Firestore", "Producto agregado: $producto")
            }
    }

    private fun deleteRegister(producto: Producto) {
        myCollection
            .document(producto.id.toString())
            .delete()
            .addOnSuccessListener {
                productoProvider.mutableList.removeAt(producto.id)
                productoAdapter.notifyItemRemoved(producto.id)
                Log.d("Firestore", "Producto eliminado: $producto")
            }
    }

    private fun updateRegister(producto: Producto) {
        myCollection
            .document(producto.id.toString())
            .set(
                hashMapOf(
                    "nombre" to producto.nombre,
                    "descripcion" to producto.descripcion,
                    "foto" to producto.foto
                )
            )
            .addOnSuccessListener {
                productoProvider.mutableList[producto.id] = producto
                productoAdapter.notifyItemChanged(producto.id)
                Log.d("Firestore", "Producto actualizado: $producto")
            }
    }


}
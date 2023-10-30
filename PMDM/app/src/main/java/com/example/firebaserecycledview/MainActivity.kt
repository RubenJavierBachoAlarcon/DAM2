package com.example.firebaserecycledview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        crearObjetosDelXml()
    }

    private fun crearObjetosDelXml() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initRecyclerView() {
        val decoration = DividerItemDecoration(this, manager.orientation)

        binding.recyclerProductos.addItemDecoration(decoration)
        productoProvider = ProductoProvider()
        productoAdapter = ProductosAdapter(productoProvider.mutableList)

        myCollection
            .get()
            .addOnSuccessListener { resultado ->
                productoProvider.actualizarLista(resultado)
                binding.recyclerProductos.adapter = productoAdapter
                binding.recyclerProductos.addItemDecoration(decoration)
            }
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
            }
    }


}
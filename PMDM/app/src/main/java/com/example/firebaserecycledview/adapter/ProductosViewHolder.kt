package com.example.firebaserecycledview.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaserecycledview.databinding.ItemProductoBinding

class ProductosViewHolder (view: View): RecyclerView.ViewHolder(view){

    val binding = ItemProductoBinding.bind(view)

    fun render(producto: Producto){
        binding.textViewId.text = producto.id.toString()
        binding.textViewNombre.text = producto.nombre
        binding.textViewDescripcion.text = producto.descripcion
    }
}
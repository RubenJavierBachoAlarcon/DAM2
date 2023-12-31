package com.example.firebaserecycledview.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firebaserecycledview.Producto
import com.example.firebaserecycledview.databinding.ItemProductoBinding

class ProductosViewHolder (view: View): RecyclerView.ViewHolder(view){

    val binding = ItemProductoBinding.bind(view)

    fun render(
        producto: Producto

        ){
        binding.textViewId.text = producto.id.toString()
        binding.textViewNombre.text = producto.nombre
        binding.textViewDescripcion.text = producto.descripcion
        Glide.with(binding.imageViewProducto.context)
            .load(producto.foto)
            .into(binding.imageViewProducto)

        binding.imageViewProducto.setOnClickListener {
            Toast.makeText(
                binding.imageViewProducto.context,
                "Producto: ${producto.nombre}",
                Toast.LENGTH_SHORT
            ).show(
            )
        }

    }


}
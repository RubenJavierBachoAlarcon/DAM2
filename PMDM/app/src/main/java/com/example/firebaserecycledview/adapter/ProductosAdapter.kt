package com.example.firebaserecycledview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaserecycledview.Producto
import com.example.firebaserecycledview.R

class ProductosAdapter (private val productosList: MutableList<Producto>): RecyclerView.Adapter<ProductosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductosViewHolder(layoutInflater.inflate(R.layout.item_producto, parent, false))
    }

    override fun onBindViewHolder(holder: ProductosViewHolder, position: Int) {
        val producto = productosList[position]
        holder.render(producto)
    }

    override fun getItemCount(): Int {
        return productosList.size
    }
}





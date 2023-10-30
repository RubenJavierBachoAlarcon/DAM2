package com.example.firebaserecycledview

import com.example.firebaserecycledview.adapter.Producto
import com.google.firebase.firestore.QuerySnapshot

class ProductoProvider {
    var mutableList = mutableListOf<Producto>()

    fun actualizarLista(resultado: QuerySnapshot){
        for (document in resultado){
            val producto = Producto(
                document.id.toInt(),
                document.data["nombre"].toString(),
                document.data["descripcion"].toString(),
                document.data["foto"].toString()
            )
            mutableList.add(producto)
        }
    }

}
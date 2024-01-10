package com.example.pruebalocalizacionfarmacias

import OverpassAPI
import OverpassResponse
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val OVERPASS_API_BASE_URL = "https://overpass-api.de/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Construye la instancia de Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(OVERPASS_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Crea la instancia de la interfaz OverpassAPI
        val overpassAPI = retrofit.create(OverpassAPI::class.java)

        // Define la consulta Overpass
        val overpassQuery = "[out:json];\n" +
                "area[\"name\"=\"Ciudad Real\"]->.searchArea;\n" +
                "node[\"amenity\"=\"pharmacy\"](area.searchArea);\n" +
                "out;"

        // Realiza la solicitud Overpass para obtener farmacias en Ciudad Real
        val call = overpassAPI.getPharmacies(overpassQuery)
        call.enqueue(object : Callback<OverpassResponse> {
            override fun onResponse(call: Call<OverpassResponse>, response: Response<OverpassResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val pharmacies = response.body()?.elements
                    pharmacies?.forEach { pharmacy ->
                        val latitude = pharmacy.lat
                        val longitude = pharmacy.lon
                        // Manejar los datos de ubicación según sea necesario
                        Toast.makeText(
                            this@MainActivity,
                            "Lat: $latitude, Lon: $longitude",
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.d("MainActivity", "Lat: $latitude, Lon: $longitude")
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Error en la solicitud", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<OverpassResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error en la conexión", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
package com.example.osmdroid

import OverpassApi
import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.osmdroid.databinding.ActivityMainBinding
import org.osmdroid.views.MapView
import org.osmdroid.config.Configuration.getInstance
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.Polyline
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay
import okhttp3.Callback
import okhttp3.Response
import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var locListener: LocationListener
    private lateinit var locManager: LocationManager
    private lateinit var mLocationOverlay: MyLocationNewOverlay
    private lateinit var binding: ActivityMainBinding

    private val PETICION_PERMISO_LOCALIZACION = 101

    private lateinit var map: MapView
    private val ruta = Polyline()

    private var hospitalCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crearObjetosDelXml()

        // check permissions fine coarse internet y access network state and request them if needed
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != android.content.pm.PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != android.content.pm.PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.INTERNET
            ) != android.content.pm.PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_NETWORK_STATE
            ) != android.content.pm.PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION,
                    android.Manifest.permission.INTERNET,
                    android.Manifest.permission.ACCESS_NETWORK_STATE
                ),
                PETICION_PERMISO_LOCALIZACION
            )
        }

        accionesParaBotones()

        map = binding.mapView
        generarMapa()
        quitarRepeticionYLimitarScroll()

    }

    private fun accionesParaBotones() {
        binding.buttonOff.setOnClickListener {

        }
        binding.buttonOn.setOnClickListener {
            habilitarLocalizacion()
        }
        binding.button.setOnClickListener {

        }

    }

    private fun generarMapa() {
        getInstance().load(
            this,
            getSharedPreferences(packageName + "asmdroid", MODE_PRIVATE)
        )

        map.controller.setZoom(2.0)
        map.controller.setCenter(GeoPoint(38.9908, -3.9206))
        map.zoomController.setVisibility(org.osmdroid.views.CustomZoomButtonsController.Visibility.ALWAYS)
        map.setMultiTouchControls(true)
        map.setTileSource(org.osmdroid.tileprovider.tilesource.TileSourceFactory.MAPNIK)


    }

    private fun habilitarMiLocalizacion() {
        mLocationOverlay = MyLocationNewOverlay(GpsMyLocationProvider(this), map)
        mLocationOverlay.enableMyLocation()
        mLocationOverlay.enableFollowLocation()
        map.overlays.add(mLocationOverlay)
    }

    private fun quitarRepeticionYLimitarScroll() {
        map.isHorizontalMapRepetitionEnabled = false
        map.isVerticalMapRepetitionEnabled = false
        map.setScrollableAreaLimitLatitude(
            MapView.getTileSystem().maxLatitude,
            MapView.getTileSystem().minLatitude,
            0
        )
        map.setScrollableAreaLimitLongitude(
            MapView.getTileSystem().minLongitude,
            MapView.getTileSystem().maxLongitude,
            0
        )
        //set zoom adjust to map size
        map.setTilesScaledToDpi(true)


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val permissionToRequest = ArrayList<String>()
        for (i in grantResults.indices) {
            if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                permissionToRequest.add(permissions[i])
            }
        }
        if (permissionToRequest.size > 0) {
            ActivityCompat.requestPermissions(
                this,
                permissionToRequest.toArray(arrayOfNulls<String>(permissionToRequest.size)),
                PETICION_PERMISO_LOCALIZACION
            )
        }

    }

    private fun crearObjetosDelXml() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    @SuppressLint("MissingPermission")
    private fun habilitarLocalizacion() {
        binding.buttonOff.isEnabled = true
        binding.buttonOn.isEnabled = false

        locManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val loc: Location? = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)

        locListener = LocationListener { location ->
            pintarRuta(location)
        }


        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0f, locListener)
    }

    private fun pintarRuta(location: Location) {
        val geoPoint = GeoPoint(location.latitude, location.longitude)
        map.controller.setCenter(geoPoint)

        // Dibuja una línea de la ruta en la versión actual
        ruta.addPoint(geoPoint)
        ruta.apply {
            color = Color.RED
            width = 30f
        }
        map.overlays.add(ruta)
        map.invalidate()
    }

    private fun pintarRuta2(loc:Location){

    }

    private fun añadirMarcador(posicion_new: GeoPoint) {
        var marker = Marker(map)
        marker.position = posicion_new
        marker.icon =
            ContextCompat.getDrawable(this, org.osmdroid.library.R.drawable.ic_menu_compass)
    }





}
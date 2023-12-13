package com.example.grabarvideo

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import androidx.activity.result.ActivityResultLauncher
import androidx.core.app.ActivityCompat
import com.example.grabarvideo.databinding.ActivityMainBinding
import android.Manifest
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.MediaController
import androidx.activity.result.contract.ActivityResultContracts
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var videoView: VideoView? = null
    val PETICION_GRABAR_VIDEO = 1

    var mediaController: android.widget.MediaController? = null

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crearObjetosDelXml()

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED ||
            ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED){

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO), PETICION_GRABAR_VIDEO)
        }
        else {
            Log.d("PERMISOS", "Permisos aceptados123")
            binding.buttonGrabacion.isEnabled = true
        }


        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result ->
            if (result.data != null){
                val data: Intent? = result.data

                if (result.resultCode == RESULT_OK){
                    binding.videoView.setVideoURI(data?.data)
                }
            }

        }

        binding.videoView.setOnPreparedListener {
            binding.videoView.start()
            binding.videoView.requestFocus()
            ponerControles()
            binding.buttonGrabacion.isEnabled = false
        }


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        Log.d("PERMISOS", "Permisos aceptados Result")

        if (requestCode == PETICION_GRABAR_VIDEO){
            Log.d("PERMISOS", "Permisos aceptados")
            if (grantResults.size == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                binding.buttonGrabacion.isEnabled = true
            }
        }
    }

    private fun ponerControles(){
        mediaController = MediaController(this)
        mediaController?.setAnchorView(binding.videoView)
        binding.videoView.setMediaController(mediaController)
    }



    fun comenzarGrabacion(view: View){
        val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        activityResultLauncher.launch(intent)

    }

    private fun crearObjetosDelXml(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

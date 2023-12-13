package com.example.reproductorconvideoview


import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import com.example.reproductorconvideoview.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

lateinit var mVideoView: VideoView
lateinit var mediaController: MediaController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crearObjetosDelXml()

        mVideoView = binding.videoView
        mVideoView.setOnPreparedListener{
            mVideoView.start()
            mVideoView.requestFocus()
            ponerControles(mVideoView)
            binding.botonReproducirVideo.isEnabled = false
        }

        mVideoView.setOnCompletionListener{
            binding.botonReproducirVideo.isEnabled = true
        }
    }

    fun cargarMultimedia(v: View){
        mVideoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.video))
    }

    fun ponerControles(videoView: VideoView) {
        mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
    }


    private fun crearObjetosDelXml(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
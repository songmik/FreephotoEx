package com.example.a22_freephoto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a22_freephoto.data.Repository
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchRandomPhotos()
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    private fun fetchRandomPhotos(query: String ?= null) = scope.launch{
        Repository.getRandomPhotos(query)?.let { photos ->
            photos

        }

    }
}
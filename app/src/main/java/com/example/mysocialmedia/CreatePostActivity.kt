package com.example.mysocialmedia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mysocialmedia.databinding.ActivityCreatePostBinding

class CreatePostActivity : AppCompatActivity() {
    private lateinit var mbinding: ActivityCreatePostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mbinding = ActivityCreatePostBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        mbinding.postbtn.setOnClickListener {
            val input = mbinding.postInput.text.toString().trim()
            if(input.isNotEmpty()) {

            }
        }


    }
}
package com.example.mysocialmedia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mysocialmedia.daos.PostDao
import com.example.mysocialmedia.databinding.ActivityCreatePostBinding

class CreatePostActivity : AppCompatActivity() {
    private lateinit var mbinding: ActivityCreatePostBinding
    private lateinit var postDao: PostDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mbinding = ActivityCreatePostBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        mbinding.postbtn.setOnClickListener {
            val input = mbinding.postInput.text.toString().trim()
            if(input.isNotEmpty()) {
                postDao.addPost(input)
                finish()
            }
        }


    }
}
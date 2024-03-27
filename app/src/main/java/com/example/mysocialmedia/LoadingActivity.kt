package com.example.mysocialmedia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil.setContentView
import com.example.mysocialmedia.databinding.ActivityLoadingBinding

class LoadingActivity : AppCompatActivity() {
    private lateinit var mbinding: ActivityLoadingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityLoadingBinding.inflate(layoutInflater)
        setContentView(mbinding.root)


        }
    }
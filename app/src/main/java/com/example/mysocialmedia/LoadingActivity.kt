package com.example.mysocialmedia

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mysocialmedia.databinding.ActivityLoadingBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadingActivity : AppCompatActivity() {
    private lateinit var mbinding: ActivityLoadingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityLoadingBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        CoroutineScope(Dispatchers.Main).launch {
            delay(5000) // 5000 milliseconds = 5 seconds
            startMainActivity()
        }

    }
    private fun startMainActivity() {
        val intent = Intent(this@LoadingActivity, MainActivity::class.java)
        startActivity(intent)
        finish() // Finish the LoadingActivity so it's not accessible via back button
    }


}


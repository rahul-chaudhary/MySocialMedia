package com.example.mysocialmedia

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mysocialmedia.Adapters.PostAdapter
import com.example.mysocialmedia.daos.PostDao
import com.example.mysocialmedia.databinding.ActivityMainBinding
import com.example.mysocialmedia.models.Post
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.Query

class MainActivity : AppCompatActivity() {
    private lateinit var mbinding: ActivityMainBinding
    private lateinit var adapter: PostAdapter
    private lateinit var postDao: PostDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        postDao = PostDao()

        mbinding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity, CreatePostActivity::class.java)
            startActivity(intent)
        }
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val postsCollections = postDao.postCollections
        val query = postsCollections.orderBy("createdAt", Query.Direction.DESCENDING)
        val recyclerViewOptions =
            FirestoreRecyclerOptions.Builder<Post>().setQuery(query, Post::class.java).build()

        adapter = PostAdapter(recyclerViewOptions)

        mbinding.recyclerView.adapter = adapter
        mbinding.recyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }


}
package com.example.kotlin.moviles.framework.views.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.moviles.R
import com.example.kotlin.moviles.framework.adapters.NinjaAdapter
import com.example.kotlin.moviles.framework.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var ninjaAdapter: NinjaAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        ninjaAdapter = NinjaAdapter(listOf())
        recyclerView.adapter = ninjaAdapter

        viewModel.records.observe(this) { records ->
            ninjaAdapter.updateData(records ?: listOf()) 

        viewModel.getDnsLookup("google.com")
    }
}


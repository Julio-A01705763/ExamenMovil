package com.example.kotlin.moviles.framework.views.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.moviles.R
import com.example.kotlin.moviles.framework.adapters.NinjaAdapter
import com.example.kotlin.moviles.framework.viewmodel.MainViewModel
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var ninjaAdapter: NinjaAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var editTextDomain: EditText
    private lateinit var buttonLookup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        ninjaAdapter = NinjaAdapter(listOf())
        recyclerView.adapter = ninjaAdapter
        editTextDomain = findViewById(R.id.editTextDomain)
        buttonLookup = findViewById(R.id.buttonLookup)

        viewModel.records.observe(this) { records ->
            ninjaAdapter.updateData(records ?: listOf())
        }

        buttonLookup.setOnClickListener {
            val domain = editTextDomain.text.toString().trim()
            if (domain.isNotEmpty()) {
                viewModel.getDnsLookup(domain)
            }
        }
    }
}

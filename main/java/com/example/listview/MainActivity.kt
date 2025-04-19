package com.example.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listView = findViewById(R.id.listView)
        var names = arrayOf("java", "kotlin", "C++", "C", "C#", "python", "ruby", "dart", "javascript", "PHP")

        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names)
        listView.adapter =adapter

        listView.setOnItemClickListener{
            parent, view, position, id ->
            val item = parent.getItemAtPosition(position) as String
            Toast.makeText(this, item, Toast.LENGTH_SHORT).show()
        }
    }
}
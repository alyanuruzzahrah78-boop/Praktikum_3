package com.example.praktikum2

import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat.enableEdgeToEdge
import androidx.core.view.WindowInsetsCompat

class Latihan1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etHasilLat1 = findViewById<EditText>(R.id.etHasilLat1)
        val btProsesLat1 = findViewById<Button>(R.id.btProsesLat1)

        btProsesLat1.setOnClickListener {
        val nama = etHasilLat1.text.toString()
            if (nama == "teal") {
                btProsesLat1.setBackgroundColor(ContextCompat.getColor( this, R.color.teal_700))
            }else {
                btProsesLat1.setBackgroundColor(ContextCompat.getColor( this, R.color.purple_500))
            }
        }
    }
}

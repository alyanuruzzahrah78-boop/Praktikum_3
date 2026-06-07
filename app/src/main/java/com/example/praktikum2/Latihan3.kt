package com.example.praktikum2

import android.os.Bundle
import android.widget.Spinner
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat.enableEdgeToEdge
import androidx.core.view.WindowInsetsCompat

class Latihan3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        delegate.localNightMode = AppCompatActivity.MODE_NO_LOCALIZED_COLLATORS
        setContentView(R.layout.activity_latihan3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinner = findViewById<Spinner>(R.id.spinner)
        val btProsesLatihanWarna2 = findViewById<Button>(R.id.btProsesLatihanWarna2)

        btProsesLatihanWarna2.setOnClickListener {
            val spinner = spinner.selectedItem.toString()
            when (spinner) {
                "red" ->
                    btProsesLatihanWarna2.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
                "green" ->
                    btProsesLatihanWarna2.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                "blue" ->
                    btProsesLatihanWarna2.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))

            else -> {
                val builder = AlertDialog.Builder(this)
                builder
                    .setTitle("Peringatan")
                    .setMessage("Warna akan direset ke awal, apakah anda yakin?")
                    .setPositiveButton("OK"){
                        dialog, _ ->
                        dialog.dismiss()
                        btProsesLatihanWarna2.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_500))
                    }
                    .setNegativeButton("Batal") {
                        dialog, _ -> dialog.dismiss()
                    }
                    .show()
            }
            }
        }
    }
}
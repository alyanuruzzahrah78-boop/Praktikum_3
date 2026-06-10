package com.example.praktikum2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AlertDialog

class Latihan5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etSisiKubus = findViewById<EditText>(R.id.etSisiKubus)
        val cbLuasPersegi = findViewById<CheckBox>(R.id.cbPilihan1)
        val cbLuasPermukaanKubus = findViewById<CheckBox>(R.id.cbPilihan2)
        val cbVolumeKubus = findViewById<CheckBox>(R.id.cbPilihan3)
        val btnProsesCheckBox = findViewById<Button>(R.id.btnProsesCheckBox)
        val tvHasilCheckBox = findViewById<TextView>(R.id.tvHasilCheckBox)

        btnProsesCheckBox.setOnClickListener {
            val sisi = etSisiKubus.text.toString().toDoubleOrNull() ?: 0.0
            val builder = AlertDialog.Builder(this)
            val hasil1 = sisi * sisi
            val hasil2 = 6 * sisi * sisi
            val hasil3 = sisi * sisi * sisi

            if (cbLuasPersegi.isChecked && cbLuasPermukaanKubus.isChecked && cbVolumeKubus.isChecked) {
            tvHasilCheckBox.text = "Luas Persegi: "+hasil1.toString()+"\nLuas Permukaan Kubus: "+hasil2.toString()+"\nVolume Kubus: "+hasil3.toString()
            }else{
                builder.setTitle("Peringatan")
                builder.setMessage("Silahkan Centang Dua Pilihan")
                builder.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                builder.show()
                tvHasilCheckBox.text = "--------"
            }
        }
    }
}
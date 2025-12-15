package com.daviddam.projectecafeteriadavidgelmacorral2ndam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import sharedPreference.SharedPreference

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val campUsuari = findViewById<EditText>(R.id.etUsuari)
        val campContrasenya = findViewById<EditText>(R.id.etContrasenya)

        val btnRegistre = findViewById<Button>(R.id.btnRegistre)

        val sharedPref = SharedPreference(this)

        btnRegistre.setOnClickListener {
            val usuari = campUsuari.text.toString()
            val contrasenya = campContrasenya.text.toString()

            sharedPref.guardarUsuari(usuari,contrasenya)

            val intent = Intent(this, LoginActivity::class.java)

            startActivity(intent)
        }
    }
}
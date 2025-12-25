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
            val usuari = campUsuari.text.toString().trim()
            val contrasenya = campContrasenya.text.toString().trim()

            if (usuari.isEmpty() || contrasenya.isEmpty()) {
                android.widget.Toast.makeText(this, "Omple usuari i contrasenya", android.widget.Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val comprovar = sharedPref.registrarUsuari(usuari, contrasenya)
            if (comprovar) {
                android.widget.Toast.makeText(this, "Usuari registrat", android.widget.Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                android.widget.Toast.makeText(this, "L'usuari ja existeix", android.widget.Toast.LENGTH_SHORT).show()
            }
        }
    }
}
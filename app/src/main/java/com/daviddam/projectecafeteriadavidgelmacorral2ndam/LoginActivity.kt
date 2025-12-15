package com.daviddam.projectecafeteriadavidgelmacorral2ndam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import sharedPreference.SharedPreference

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val etUser = findViewById<EditText>(R.id.etUsuari)
        val etContrasenya = findViewById<EditText>(R.id.etContrasenya)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        val sharedPref = SharedPreference(this)

        btnLogin.setOnClickListener {

            val usuariInput = etUser.text.toString()
            val contrasenyaInput = etContrasenya.text.toString()

            val usuariGuardat = sharedPref.getUsuari()
            val contrasenyaGuardada = sharedPref.getContrasenya()

            if (usuariInput == usuariGuardat && contrasenyaInput == contrasenyaGuardada) {

                sharedPref.setEstaLogat(true)
                val intent = Intent(this, MainActivity::class.java)

                intent.putExtra("USER", usuariGuardat)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, "Usuari o contrasenya incorrectes", Toast.LENGTH_SHORT).show()
            }
        }

        val btnRegistre = findViewById<Button>(R.id.btnRegistre)

        btnRegistre.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
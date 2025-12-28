package com.daviddam.projectecafeteriadavidgelmacorral2ndam

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.daviddam.projectecafeteriadavidgelmacorral2ndam.databinding.ActivityRegisterBinding
import sharedPreference.SharedPreference

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = SharedPreference(this)

        binding.btnRegistre.setOnClickListener {
            val usuari = binding.etUsuari.text.toString().trim()
            val contrasenya = binding.etContrasenya.text.toString().trim()

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
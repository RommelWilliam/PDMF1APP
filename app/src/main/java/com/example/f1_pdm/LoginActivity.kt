package com.example.f1_pdm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsuario: EditText
    private lateinit var etContrasena: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsuario = findViewById(R.id.etUsuario)
        etContrasena = findViewById(R.id.etContrasena)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val usuario = etUsuario.text.toString()
            val contrasena = etContrasena.text.toString()

            if (usuario == "admin" && contrasena == "admin123") {
                // Si es administrador
                val intent = Intent(this, InicioAdministradorActivity::class.java)
                startActivity(intent)
                finish()
            } else if (usuario == "usuario" && contrasena == "usuario123") {
                // Si es usuario normal
                val intent = Intent(this, CarritoComprasActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Si son incorrectos
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

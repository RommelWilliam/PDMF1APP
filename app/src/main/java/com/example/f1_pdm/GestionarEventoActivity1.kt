package com.example.f1_pdm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GestionarEventoActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gestionar_evento1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencias a los botones del XML
        val btnAgregar = findViewById<Button>(R.id.button)
        val btnConsultar = findViewById<Button>(R.id.button2)
        val btnModificar = findViewById<Button>(R.id.button5)
        val btnEliminar = findViewById<Button>(R.id.button6)

        // Configurar listeners para cada botón
        btnAgregar.setOnClickListener {
            startActivity(Intent(this, AgregarEventoActivity::class.java))
        }

        btnConsultar.setOnClickListener {
            startActivity(Intent(this, ConsultarEventoActivity::class.java))
        }

        btnModificar.setOnClickListener {
            startActivity(Intent(this, ModificarEventoActivity::class.java))
        }

        btnEliminar.setOnClickListener {
            startActivity(Intent(this, EliminarEventoActivty::class.java))
        }
    }
}
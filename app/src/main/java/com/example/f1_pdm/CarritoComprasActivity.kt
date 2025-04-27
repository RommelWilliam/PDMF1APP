package com.example.f1_pdm

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class CarritoComprasActivity : AppCompatActivity() {

    private lateinit var lvCompras: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito_compras)

        lvCompras = findViewById(R.id.lvCompras)

        // Datos de ejemplo para mostrar en el carrito
        val compras = listOf(
            "Gran Premio de Mónaco - VIP",
            "Gran Premio de España - Normal",
            "Gran Premio de México - VIP"
        )

        // Adaptador para mostrar las compras en el ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, compras)
        lvCompras.adapter = adapter
    }
}

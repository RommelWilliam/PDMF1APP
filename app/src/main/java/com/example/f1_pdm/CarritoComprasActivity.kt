package com.example.f1_pdm

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar

class CarritoComprasActivity : AppCompatActivity() {

    private lateinit var lvCompras: ListView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito_compras)

        // Inicializamos el ListView
        lvCompras = findViewById(R.id.lvCompras)

        // Datos de ejemplo
        val compras = listOf(
            "Gran Premio de Mónaco - VIP",
            "Gran Premio de España - Normal",
            "Gran Premio de México - VIP"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, compras)
        lvCompras.adapter = adapter

        // Inicializamos el DrawerLayout, NavigationView y Toolbar
        drawerLayout = findViewById(R.id.drawer_layout_usuario)
        navigationView = findViewById(R.id.navigation_view_usuario)
        toolbar = findViewById(R.id.toolbar_usuario)

        setSupportActionBar(toolbar)

        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_mis_compras -> {
                    Toast.makeText(this, "Estás en Mis Compras", Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_logout -> {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                else -> false
            }
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(androidx.core.view.GravityCompat.START)) {
            drawerLayout.closeDrawer(androidx.core.view.GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}

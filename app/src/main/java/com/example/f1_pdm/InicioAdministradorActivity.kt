package com.example.f1_pdm

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class InicioAdministradorActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_administrador)

        drawerLayout = findViewById(R.id.drawer_layout_admin)
        navigationView = findViewById(R.id.navigation_view_admin)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_gestion_usuarios -> {
                    Toast.makeText(this, "Ir a Gestión de Usuarios", Toast.LENGTH_SHORT).show()
                    // Aquí puedes abrir otra Activity si quieres
                    true
                }
                R.id.nav_gestion_eventos -> {
                    Toast.makeText(this, "Ir a Gestión de Eventos", Toast.LENGTH_SHORT).show()
                    // Aquí puedes abrir otra Activity si quieres
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
}

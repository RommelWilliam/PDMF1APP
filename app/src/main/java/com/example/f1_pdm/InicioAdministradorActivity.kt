package com.example.f1_pdm

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class InicioAdministradorActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_administrador)

        drawerLayout = findViewById(R.id.drawer_layout_admin)
        navigationView = findViewById(R.id.navigation_view_admin)
        toolbar = findViewById(R.id.toolbar_admin)

        // 🔵 Configuramos la Toolbar como ActionBar
        setSupportActionBar(toolbar)

        // 🔵 Configuramos el botón de menú hamburguesa
        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // 🔵 Acciones al seleccionar ítems del menú
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_gestion_usuarios -> {
                    Toast.makeText(this, "Ir a Gestión de Usuarios", Toast.LENGTH_SHORT).show()
                    // TODO: Aquí luego puedes abrir la actividad de gestionar usuarios
                    true
                }
                R.id.nav_gestion_eventos -> {
                    Toast.makeText(this, "Ir a Gestión de Eventos", Toast.LENGTH_SHORT).show()
                    // TODO: Aquí luego puedes abrir la actividad de gestionar eventos
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

    // 🔵 Para cerrar el Drawer cuando el usuario presione back
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(androidx.core.view.GravityCompat.START)) {
            drawerLayout.closeDrawer(androidx.core.view.GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}

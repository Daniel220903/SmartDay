package com.example.smartdays

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RoutineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routine)

        // Configurar la Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val principianteButton: Button = findViewById(R.id.principiante_button)
        val avanzadoButton: Button = findViewById(R.id.Avanzado_btn)
        val expertoButton: Button = findViewById(R.id.Experto_btn)
        val recyclerView: RecyclerView = findViewById(R.id.exercise_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        principianteButton.setOnClickListener {
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }

        avanzadoButton.setOnClickListener {
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }

        expertoButton.setOnClickListener {
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }

        // Crear un PopupMenu para mostrar un menú emergente
        val menuButton: Button = findViewById(R.id.Experto_btn) // Puedes usar cualquier botón
        menuButton.setOnLongClickListener { view ->
            showPopupMenu(view) // Llamar al método para mostrar el menú emergente
            true
        }
    }

    // Función para mostrar el menú emergente
    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.menu_popup, popupMenu.menu) // Inflar el menú desde un recurso

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.popup_option_1 -> {
                    Toast.makeText(this, "Opción 1 seleccionada", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.popup_option_2 -> {
                    Toast.makeText(this, "Opción 2 seleccionada", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.popup_option_3 -> {
                    Toast.makeText(this, "Opción 3 seleccionada", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        popupMenu.show() // Mostrar el menú emergente
    }

    // Inflar el menú
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_routine, menu)
        return true
    }

    // Manejar las opciones del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(this, "Ajustes seleccionados", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_feedback -> {
                Toast.makeText(this, "Comentarios seleccionados", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

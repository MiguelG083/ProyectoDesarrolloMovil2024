package com.fei.apartados

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random


class EmployeeMainListActivity : AppCompatActivity() {
    private lateinit var adapter: WidgetListAppartAdapter
    private val widgetsList = mutableListOf<WidgetListAppart>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_main_list)

        val lv_apparts = findViewById<ListView>(R.id.lv_apparts)

        // Crear widgets de ejemplo
        val cantidadElementos = 15
        for (i in 1..cantidadElementos) {
            val numeroAleatorio = Random.nextInt(1000)

            val widget = WidgetListAppart(
                numeroAleatorio,
                "Eduardo Lozada Anastacio",
                "28/04/2024",
                "$450",
                "4 articulos",
                'n'
            )
            widgetsList.add(widget)
        }

        // Crear el adaptador y asignarlo al ListView
        adapter = WidgetListAppartAdapter(this, widgetsList)
        lv_apparts.adapter = adapter



        val floatingActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        floatingActionButton.setOnClickListener{
            val intent = Intent(this, EmployeeNewAppartView::class.java)
            startActivity(intent)
        }
    }

    fun pupopMenuFilter(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.setOnMenuItemClickListener { item ->
            // Manejar la selección del usuario aquí
            when (item.itemId) {
                R.id.opc1 -> {
                    ordenarPorNombre()
                    true
                }
                R.id.opc2 -> {
                    ordenarPorFecha()
                    true
                }
                // Agregar más casos según sea necesario
                else -> false
            }
        }
        popupMenu.inflate(R.menu.filter_menu)
        popupMenu.show()
    }

    private fun ordenarPorNombre() {
        widgetsList.sortBy { it.id } // Cambia "nombre" por el atributo real del widget que deseas ordenar
        adapter.notifyDataSetChanged() // Notificar al adaptador que los datos han cambiado
    }

    private fun ordenarPorFecha() {
        widgetsList.sortBy { it.client } // Cambia "fecha" por el atributo real del widget que deseas ordenar
        adapter.notifyDataSetChanged() // Notificar al adaptador que los datos han cambiado
    }
}

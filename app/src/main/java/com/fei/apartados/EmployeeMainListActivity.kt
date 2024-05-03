package com.fei.apartados

import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity


class EmployeeMainListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_main_list)



        val lv_apparts = findViewById<ListView>(R.id.lv_apparts)

        // Aquí deberías obtener los datos de tu base de datos y crear instancias de MyCustomWidget
        // Para este ejemplo, vamos a suponer que ya tienes una lista de widgets

//        val widgetsList = listOf<WidgetListAppart>(
//            WidgetListAppart(404, "Eduardo Lozada Anastacio", "28/04/2024", "$450", "4 articulos"),
//        )
        val widgetsList = mutableListOf<WidgetListAppart>()
        val cantidadElementos = 15
        for (i in 1..cantidadElementos) {
            val widget = WidgetListAppart(
                i,
                "Eduardo Lozada Anastacio",
                "28/04/2024",
                "$450",
                "4 articulos",
                'e'
            )
            widgetsList.add(widget)
        }


        // Crear el adaptador y asignarlo al ListView
        val adapter = WidgetListAppartAdapter(this, widgetsList)
        lv_apparts.adapter = adapter
    }

    fun pupopMenuFilter(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.setOnMenuItemClickListener { item ->
            // Manejar la selección del usuario aquí
            when (item.itemId) {
                R.id.opc1 -> {
                    // Ordenar por nombre
                    true
                }
                R.id.opc2 -> {
                    // Ordenar por fecha
                    true
                }
                // Agregar más casos según sea necesario
                else -> false
            }
        }
        popupMenu.inflate(R.menu.filter_menu)
        popupMenu.show()
    }

}
package com.fei.apartados

import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class EmployeeMainListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_main_list)

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
package com.fei.apartados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EmployeeAppartView : AppCompatActivity() {
    private lateinit var buttonBack: ImageView
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_appart_view)

        buttonBack = findViewById(R.id.imageViewBack)
        floatingActionButton = findViewById(R.id.floatingActionButtonAV)

        floatingActionButton.setOnClickListener{
            pupopActionMenu(it)
        }

        buttonBack.setOnClickListener {
            backAllert()
        }
    }

    private fun backAllert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmación")
        builder.setMessage("¿Estás seguro de que quieres salir?")

        // Agrega los botones de confirmación y cancelación
        builder.setPositiveButton("Sí") { dialog, which ->
            // Si el usuario confirma, cierra la actividad actual y vuelve a la anterior
            finish()
        }
        builder.setNegativeButton("Cancelar", null)

        // Muestra el cuadro de diálogo
        val dialog = builder.create()
        dialog.show()
    }

    private fun pupopActionMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.menu_personalizado)
        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.opcion1 -> {
                    // Acción para la opción 1
                    Toast.makeText(this, "Opción 1 seleccionada", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.opcion2 -> {
                    // Acción para la opción 2
                    Toast.makeText(this, "Opción 2 seleccionada", Toast.LENGTH_SHORT).show()
                    true
                }
                // Agregar más casos según sea necesario
                else -> false
            }
        }
        popupMenu.show()
    }
}
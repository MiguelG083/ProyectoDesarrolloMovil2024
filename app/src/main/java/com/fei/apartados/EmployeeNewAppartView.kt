package com.fei.apartados

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class EmployeeNewAppartView : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var linearLayout: LinearLayout
    private lateinit var addButton: Button
    private lateinit var saveButton: Button
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_new_appart_view)

        linearLayout = findViewById(R.id.linearLayoutList)
        addButton = findViewById(R.id.btnAdd)
        saveButton = findViewById(R.id.btnSave)
        backButton = findViewById(R.id.imageViewBack)


        addButton.setOnClickListener {
            addItem()
        }


        saveButton.setOnClickListener {
            saveData()
        }


        backButton.setOnClickListener {
            backAllert()
        }

    }

    private fun addItem() {
        val customWidget = LayoutInflater.from(this).inflate(R.layout.widget_new_appart_item, null) // Crear instancia del widget personalizado
        linearLayout.addView(customWidget) // Agregar el widget personalizado al LinearLayout
        // Recorrer todos los elementos en el LinearLayout
        for (i in 0 until linearLayout.childCount) {
            val widgetPersonalizado = linearLayout.getChildAt(i)
            if (widgetPersonalizado is RelativeLayout) {
                val editTextCantidad = widgetPersonalizado.findViewById<EditText>(R.id.cant)
                val editTextPrecio = widgetPersonalizado.findViewById<EditText>(R.id.price)
                val textViewTotal = widgetPersonalizado.findViewById<TextView>(R.id.total)

                // Agregar listeners a los EditText de cantidad y precio
                editTextCantidad.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                    override fun afterTextChanged(s: Editable?) {
                        calcularTotal(editTextCantidad, editTextPrecio, textViewTotal)
                    }
                })

                editTextPrecio.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                    override fun afterTextChanged(s: Editable?) {
                        calcularTotal(editTextCantidad, editTextPrecio, textViewTotal)
                    }
                })
            }
        }
    }

    private fun saveData() {
        val cantidadList = mutableListOf<String>()
        val descripcionList = mutableListOf<String>()
        val precioList = mutableListOf<String>()
        val totalList = mutableListOf<String>()

        // Recorrer todos los elementos en el LinearLayout
        for (i in 0 until linearLayout.childCount) {
            val widgetPersonalizado = linearLayout.getChildAt(i)
            if (widgetPersonalizado is RelativeLayout) {
                val editTextCantidad = widgetPersonalizado.findViewById<EditText>(R.id.cant)
                val editTextDescripcion = widgetPersonalizado.findViewById<EditText>(R.id.desc)
                val editTextPrecio = widgetPersonalizado.findViewById<EditText>(R.id.price)
                val textViewTotal = widgetPersonalizado.findViewById<TextView>(R.id.total)

                val cantidad = editTextCantidad.text.toString()
                val descripcion = editTextDescripcion.text.toString()
                val precio = editTextPrecio.text.toString()
                val total = textViewTotal.text.toString()

                cantidadList.add(cantidad)
                descripcionList.add(descripcion)
                precioList.add(precio)
                totalList.add(total)

                Log.d("VALORES", "Cantidad: $cantidad, Descripción: $descripcion, Precio: $precio, Total: $total")
            }
        }

        // Aquí puedes hacer lo que necesites con las listas de datos
        // Por ejemplo, guardar en una base de datos o realizar alguna acción.
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

    private fun calcularTotal(editTextCantidad: EditText, editTextPrecio: EditText, textViewTotal: TextView) {
        val cantidad = editTextCantidad.text.toString().toDoubleOrNull() ?: 0.0
        val precio = editTextPrecio.text.toString().toDoubleOrNull() ?: 0.0
        val total = cantidad * precio
        textViewTotal.text = total.toString()
    }


}
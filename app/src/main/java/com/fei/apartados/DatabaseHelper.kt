package com.fei.apartados

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper  // Constructor
    (context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    // Método que se ejecuta cuando la base de datos es creada por primera vez
    override fun onCreate(db: SQLiteDatabase) {
        // Crear las tablas
        val createClienteTableQuery = "CREATE TABLE Cliente (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, " +
                "telefono TEXT, " +
                "informacion_adicional TEXT)"
        db.execSQL(createClienteTableQuery)
        val createApartadoTableQuery = "CREATE TABLE Apartado (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "fecha_creacion TEXT, " +
                "cantidad_articulos INTEGER, " +
                "estado TEXT, " +
                "fecha_tolerancia TEXT, " +
                "restante REAL, " +
                "id_cliente INTEGER, " +
                "FOREIGN KEY(id_cliente) REFERENCES Cliente(id))"
        db.execSQL(createApartadoTableQuery)
        val createArticuloTableQuery = "CREATE TABLE Articulo (" +
                "id_apartado INTEGER, " +
                "descripcion TEXT, " +
                "cantidad INTEGER, " +
                "precio_unitario REAL, " +
                "FOREIGN KEY(id_apartado) REFERENCES Apartado(id))"
        db.execSQL(createArticuloTableQuery)
        val createAbonosTableQuery = "CREATE TABLE Abonos (" +
                "id_apartado INTEGER, " +
                "cantidad REAL, " +
                "fecha TEXT, " +
                "FOREIGN KEY(id_apartado) REFERENCES Apartado(id))"
        db.execSQL(createAbonosTableQuery)
    }

    // Método que se ejecuta cuando la base de datos necesita ser actualizada
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Aquí puedes realizar cambios en el esquema de la base de datos si es necesario
        db.execSQL("DROP TABLE IF EXISTS Cliente")
        db.execSQL("DROP TABLE IF EXISTS Apartado")
        db.execSQL("DROP TABLE IF EXISTS Articulo")
        db.execSQL("DROP TABLE IF EXISTS Abonos")
        onCreate(db)
    }

    companion object {
        private const val DATABASE_NAME = "Database.db"
        private const val DATABASE_VERSION = 1
    }
}


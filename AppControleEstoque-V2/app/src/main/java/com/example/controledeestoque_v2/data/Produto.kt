package com.example.controledeestoque_v2.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "produtos")

data class Produto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val nome: String,
    val categoria: String,
    val quantidade: Int,
    val precoUnitario: Double
)

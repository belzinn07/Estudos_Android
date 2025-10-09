package com.example.controledeestoque_v2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "produtos")

data class Produto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val nome: String,
    val categoria: Categoria,
    val quantidade: Int,
    val precoUnitario: Double
)
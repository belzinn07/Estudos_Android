package com.example.controledeestoque_v2.data

data class Produto(
    val nome: String,
    val categoria: Categoria,
    val quantidade: Int,
    val precoUnitario: Double
)

package com.example.controledeestoque

data class Produtos(
    val nome:String,
    val categoria: Categorias,
    val quantidade: Int,
    val precoUnitario: Double
)

package com.example.controledeestoque_v2.data.repository

import com.example.controledeestoque_v2.data.model.Produto
import com.example.controledeestoque_v2.data.dao.ProdutoDao

class ProdutoRepository (private val dao: ProdutoDao){
    val produtos = dao.listarProdutos()

    suspend fun inserir(produto: Produto) = dao.inserir(produto)
    suspend fun atualizar(produto: Produto) = dao.atualizar(produto)
    suspend fun deletar(produto: Produto) = dao.deletar(produto)

}
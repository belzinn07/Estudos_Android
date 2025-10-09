package com.example.controledeestoque_v2.viewmodel

import android.util.Log.i
import androidx.lifecycle.ViewModel
import com.example.controledeestoque_v2.data.repository.ProdutoRepository
import kotlinx.coroutines.flow.SharingStarted
import androidx.lifecycle.viewModelScope
import com.example.controledeestoque_v2.data.model.Produto
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch



class ProdutoViewModel (private val  repository: ProdutoRepository): ViewModel(){

     val produtos = repository.produtos.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val valorTotalEstoque = repository.produtos
        .map { lista -> lista.sumOf { it.quantidade * it.precoUnitario } }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = 0.0
        )



    fun inserir(produto: Produto) = viewModelScope.launch {
        if (produto.nome.isNotBlank() || produto.quantidade > 0 || produto.precoUnitario > 0)
            repository.inserir(produto)

    }

    fun atualizar(produto: Produto) = viewModelScope.launch {
        repository.atualizar(produto)
    }

    fun deletar(produto: Produto) = viewModelScope.launch {
        repository.deletar(produto)
    }

}


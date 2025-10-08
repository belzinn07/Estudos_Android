package com.example.controledeestoque_v2.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update

@Dao
interface ProdutoDao {

    @Insert suspend fun inserir(produto: Produto)
    @Update suspend fun atualizar(produto: Produto)






}
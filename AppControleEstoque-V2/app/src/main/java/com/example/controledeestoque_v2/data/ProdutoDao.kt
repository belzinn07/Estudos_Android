package com.example.controledeestoque_v2.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import  androidx.room.Delete
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface ProdutoDao {

    @Insert suspend fun inserir(produto: Produto)
    @Update suspend fun atualizar(produto: Produto)
    @Delete suspend fun deletar(produto: Produto)

@Query("SELECT * FROM produto ORDER BY nome ASC")
fun  listarProdutos(): Flow<List<Produto>>

}
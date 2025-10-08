package com.example.controledeestoque_v2.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.controledeestoque_v2.data.Produto


@Database(entities = [Produto:class], version = 1, exportSchema =  false ])
abstrac class ProdutoDataBase : RoomDatabase(){
    abstract fun ProdutoDao(): ProdutoDao





}
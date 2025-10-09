package com.example.controledeestoque_v2.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.controledeestoque_v2.data.model.Produto
import com.example.controledeestoque_v2.data.dao.ProdutoDao


@Database(entities = [Produto::class], version = 1, exportSchema = false)
abstract class ProdutoDatabase : RoomDatabase() {
    abstract fun produtoDao(): ProdutoDao

    companion object {
        @Volatile
        private var INSTANCE: ProdutoDatabase? = null

        fun getDatabase(context: Context): ProdutoDatabase {
            return INSTANCE ?: synchronized(this) {
                val  instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProdutoDatabase::class.java,
                    "produto_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}


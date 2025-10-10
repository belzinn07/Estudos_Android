package com.example.controledeestoque_v2.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.controledeestoque_v2.data.model.Produto
import com.example.controledeestoque_v2.ui.theme.ControleDeEstoqueV2Theme
import com.example.controledeestoque_v2.viewmodel.ProdutoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ControleDeEstoqueV2Theme {
                TelaPricipal(onAddProduto = {});

            }
        }
    }
}

@Composable
fun TelaPricipal(
    viewModel: ProdutoViewModel = viewModel(),
    onAddProduto: () -> Unit
) {
    val produtos by viewModel.produtos.collectAsState(initial = emptyList())
    val totalEstoque by viewModel.valorTotalEstoque.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddProduto) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar produto")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "Valor total do estoque: R$ ${"2.f".format(totalEstoque)}",
                style = MaterialTheme.typography.titleMedium

            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(produtos) { produto ->
                    produtoItem(produto)

                }
            }

        }

    }
}

@Composable
fun produtoItem(produto: Produto){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ){
        Row  (
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column {
                Text(produto.nome, style = MaterialTheme.typography.titleMedium)
                Text("Qtd: ${produto.quantidade}", style = MaterialTheme.typography.bodySmall)
            }
            Text("R$ ${"2.f".format(produto.precoUnitario * produto.quantidade)}",
                style = MaterialTheme.typography.titleMedium)

        }
    }
}






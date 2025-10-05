package com.example.controledeestoque

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.controledeestoque.ui.theme.ControleDeEstoqueTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ControleDeEstoqueTheme {
                ControleDeEstoqueApp()
            }
        }
    }
}

@Composable
fun ControleDeEstoqueApp() {
    val produtos = remember { mutableStateListOf<Produtos>() }

    var nome by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf(Categorias.ALIMENTO) }
    var quantidade by remember { mutableStateOf("") }
    var preco by remember { mutableStateOf("") }
    var mensagem by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Controle de Estoque",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome do Produto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = quantidade,
            onValueChange = { quantidade = it },
            label = { Text("Quantidade em Estoque: ") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            onValueChange = { preco = it },
            value = preco,
            label = { Text("Preço Unitário: ") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(Categorias.values()) { cat ->
                Button(onClick = { categoria = cat }) {
                    Text(text = cat.name)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val quant = quantidade.toIntOrNull()
            val prec = preco.toDoubleOrNull()

            if (nome.isBlank() || quant == null || prec == null) {
                mensagem = "Preencha todos os campos corretamente"
            } else {
                val produto = Produtos(nome, categoria, quant, prec)
                produtos.add(produto)
                mensagem = "Produto ${produto.nome} adicionado com sucesso!"
                nome = ""
                quantidade = ""
                preco = ""
            }
        }) {
            Text("Adicionar Produto")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = mensagem)

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(items = produtos) { produto ->
                Text(
                    "${produto.nome} | ${produto.categoria} | " +
                            "Quantidade: ${produto.quantidade} | " +
                            "Preço: ${produto.precoUnitario}"
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        val valorTotal = produtos.sumOf { it.quantidade * it.precoUnitario }
        Text("Valor total do estoque: $valorTotal")

        val dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
        Text(
            "Ultima atualização: $dataHora", style =
            MaterialTheme.typography.bodySmall
        )
    }
}

package com.example.controledeestoque

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.controledeestoque.ui.theme.ControleDeEstoqueTheme

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
    val produtos = remember {mutableListOf<Produtos>()}

    var nome by remember { mutableStateOf("") }
    var categoria by remember {mutableStateOf("")}
    var quantidade by remember {mutableStateOf("")}
    var preco by remember {mutableStateOf("")}
    var mensagem by remember {mutableStateOf("")}

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
        Text( "Controle de Estoque",
          style = MaterialTheme.typography.headlineMedium
        )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome do Produto") },
                modifier = Modifier.fillMaxSize()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = categoria,
                onValueChange = { categoria = it},
                label =  { Text("Categoria do Produto") },
                modifier = Modifier.fillMaxSize()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = quantidade,
                onValueChange = { quantidade = it},
                label = { Text("Quantidade em Estoque: ")},
                modifier = Modifier.fillMaxSize()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                onValueChange = { preco = it},
                value = preco,
                label = { Text("Preço Unitário: ")},
                modifier = Modifier.fillMaxSize()
            )







        }




}
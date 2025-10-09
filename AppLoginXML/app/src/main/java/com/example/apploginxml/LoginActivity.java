package com.example.apploginxml;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText editEmail, editSenha;
    Button btnEntrar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        btnEntrar = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(v->{
            String email = editEmail.getText().toString();
            String senha = editSenha.getText().toString();

            if(email.equals("admin") && senha.equals("0707")){
                Toast.makeText(this, "Login feito com sucesso", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, InicioActivity.class));
            }else{
                Toast.makeText(this,"Email ou senha incorretos", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
package com.example.portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EsqueceuSenha extends AppCompatActivity {

    private EditText editEmailRecuperacao;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_esqueceu_senha);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editEmailRecuperacao = findViewById(R.id.edit_email);
        dbHelper = new DatabaseHelper(this);

        findViewById(R.id.ButtonVerificar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarEmail();
            }
        });

        TextView EfetuarLogin = findViewById(R.id.textEfetuarLogin);
        EfetuarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EsqueceuSenha.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void verificarEmail() {
        String email = editEmailRecuperacao.getText().toString().trim();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Por favor, insira um email válido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (dbHelper.checkUser(email)) {
            // Enviar email de recuperação
            sendPasswordResetEmail(email);
        } else {
            Toast.makeText(this, "Email não cadastrado", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendPasswordResetEmail(String email) {
        // Implementar envio de email
        // Isso geralmente é feito usando uma biblioteca de terceiros ou um serviço de email.
        // Aqui, vamos apenas simular com uma mensagem Toast.

        Toast.makeText(this, "Email de recuperação enviado para " + email, Toast.LENGTH_SHORT).show();
    }
}

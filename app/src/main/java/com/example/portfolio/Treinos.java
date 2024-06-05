package com.example.portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Treinos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_treinos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView supinoReto, supinoInclinado, peckDeck, Crossover, supinoDeclinado;

        supinoReto = findViewById(R.id.supinoReto);
        supinoInclinado = findViewById(R.id.supinoInclinado);
        peckDeck = findViewById(R.id.PeckDeck);
        Crossover = findViewById(R.id.Crossover);
        supinoDeclinado = findViewById(R.id.supinoDeclinado);


        supinoReto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Treinos.this, treino_supino_reto.class);
                startActivity(intent);
            }
        });

        supinoInclinado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Treinos.this, treino_supino_inclinado.class);
                startActivity(intent);
            }
        });

        peckDeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Treinos.this, treino_peckDeck.class);
                startActivity(intent);
            }
        });

        Crossover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Treinos.this, treino_crossover.class);
                startActivity(intent);
            }
        });

        supinoDeclinado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Treinos.this, treino_supino_declinado.class);
                startActivity(intent);
            }
        });

    }
}
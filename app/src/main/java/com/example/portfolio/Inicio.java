package com.example.portfolio;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Inicio extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    private TextView tvExercicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);

        bottomNavigationView = findViewById(R.id.bottomNavView);
        frameLayout = findViewById(R.id.framelayout);
        tvExercicio = findViewById(R.id.tv_exercicio);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int itemId = menuItem.getItemId();

                if (itemId == R.id.home) {
                    loadFragment(new HomeFragment(), false);

                } else if (itemId == R.id.treinos) {
                    loadFragment(new TreinosFragment(), false);

                } else if (itemId == R.id.perfil) {
                    loadFragment(new PerfilFragment(), false);
                } else {
                    loadFragment(new ConfigFragment(), false);
                }

                loadFragment(new HomeFragment(), true);
                return true;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);

        // Inicializar a lógica dos dias da semana e exercícios
        initializeDaysOfWeek();
    }

    private void loadFragment(Fragment fragment, boolean isAppInitialized) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialized) {
            fragmentTransaction.add(R.id.framelayout, fragment);

        } else {
            fragmentTransaction.replace(R.id.framelayout, fragment);
        }

        fragmentTransaction.commit();
    }

    private void initializeDaysOfWeek() {
        int[] diasIds = {
                R.id.tv_seg, R.id.tv_ter,
                R.id.tv_qua, R.id.tv_qui, R.id.tv_sex
        };

        String[] exercicios = {
                "Supinos", "Pulleys", "PeckDeck",
                "Crossover", "Remada"
        };

        for (int i = 0; i < diasIds.length; i++) {
            final int index = i;
            final String exercicio = exercicios[i];
            findViewById(diasIds[i]).setOnClickListener(v -> {
                tvExercicio.setText(exercicio);
                tvExercicio.setTextColor(getResources().getColor(android.R.color.black));

                // Reset background of all days
                for (int j = 0; j < diasIds.length; j++) {
                    TextView dayView = findViewById(diasIds[j]);
                    GradientDrawable background = (GradientDrawable) dayView.getBackground();
                    background.setColor(getResources().getColor(android.R.color.white));
                    dayView.setTextColor(getResources().getColor(android.R.color.black));
                }

                // Set background of the selected day
                TextView selectedDay = findViewById(diasIds[index]);
                GradientDrawable selectedBackground = (GradientDrawable) selectedDay.getBackground();
                selectedBackground.setColor(getResources().getColor(android.R.color.holo_green_light));
                selectedDay.setTextColor(getResources().getColor(android.R.color.white));
            });
        }
    }
}

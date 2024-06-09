package com.example.portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class TreinosFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_treinos, container, false);

        TextView supinoRetoTextView,
                supinoInclinadoTextView,
                PeckDeckTextView,
                CrossoverTextView,
                supinoDeclinadoTextView,
                PulleyFrenteTextView,
                PulleyCostaTextView,
                PulleyTrianguloTextView,
                RemadaUnilateralTextView;

        supinoRetoTextView = view.findViewById(R.id.supinoReto);
        supinoRetoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a nova atividade (substitua "MinhaAtividade.class" pelo nome da sua atividade)
                Intent intent = new Intent(getActivity(), treino_supino_reto.class);
                startActivity(intent);
            }
        });


        supinoInclinadoTextView = view.findViewById(R.id.supinoInclinado);
        supinoInclinadoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), treino_supino_inclinado.class);
                startActivity(intent);
            }
        });


        PeckDeckTextView = view.findViewById(R.id.PeckDeck);
        PeckDeckTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), treino_peckDeck.class);
                startActivity(intent);
            }
        });


        CrossoverTextView = view.findViewById(R.id.Crossover);
        CrossoverTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), treino_crossover.class);
                startActivity(intent);
            }
        });


        supinoDeclinadoTextView = view.findViewById(R.id.supinoDeclinado);
        supinoDeclinadoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), treino_supino_declinado.class);
                startActivity(intent);
            }
        });


        PulleyFrenteTextView = view.findViewById(R.id.pulleyFrente);
        PulleyFrenteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), treino_pulley_frente.class);
                startActivity(intent);
            }
        });

        PulleyCostaTextView = view.findViewById(R.id.pulleyCostas);
        PulleyCostaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), treino_pulley_costas.class);
                startActivity(intent);
            }
        });

        PulleyTrianguloTextView = view.findViewById(R.id.pulleyTriangulo);
        PulleyTrianguloTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), treino_pulley_triangulo.class);
                startActivity(intent);
            }
        });

        RemadaUnilateralTextView = view.findViewById(R.id.remadaUnilateral);
        RemadaUnilateralTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), treino_remada_unilateral.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

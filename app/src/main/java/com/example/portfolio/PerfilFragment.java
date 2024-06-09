package com.example.portfolio;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PerfilFragment extends Fragment {

    private EditText pesoEditText;
    private EditText idadeEditText;
    private EditText alturaEditText;
    private EditText sexoEditText;
    private Button saveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        // Inicializar os campos e botões
        pesoEditText = view.findViewById(R.id.pesoEditText);
        idadeEditText = view.findViewById(R.id.idadeEditText);
        alturaEditText = view.findViewById(R.id.alturaEditText);
        sexoEditText = view.findViewById(R.id.sexoEditText);
        saveButton = view.findViewById(R.id.saveButton);

        // Carregar informações do usuário ao iniciar o fragmento
        loadUserInfo();

        // Configurar o botão de salvar
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserInfo();
            }
        });

        return view;
    }

    private void saveUserInfo() {
        // Obter as informações do usuário
        String peso = pesoEditText.getText().toString();
        String idade = idadeEditText.getText().toString();
        String altura = alturaEditText.getText().toString();
        String sexo = sexoEditText.getText().toString();

        // Salvar as informações usando SharedPreferences
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("peso", peso);
        editor.putString("idade", idade);
        editor.putString("altura", altura);
        editor.putString("sexo", sexo);
        editor.apply();

        Toast.makeText(getActivity(), "Informações salvas!", Toast.LENGTH_SHORT).show();
    }

    private void loadUserInfo() {
        // Carregar as informações do usuário usando SharedPreferences
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String peso = sharedPref.getString("peso", "");
        String idade = sharedPref.getString("idade", "");
        String altura = sharedPref.getString("altura", "");
        String sexo = sharedPref.getString("sexo", "");

        // Configurar os campos com as informações carregadas
        pesoEditText.setText(peso);
        idadeEditText.setText(idade);
        alturaEditText.setText(altura);
        sexoEditText.setText(sexo);
    }
}

package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView TXTresultado;
    private Button BTNmostrar;
    private EditText ETnombre, ETcelular;
    private Button BTNinvertir;

    private String nombre;
    private int celular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        BTNmostrar.setOnClickListener(this::onClick);
        BTNinvertir.setOnClickListener(this::onClick);
    }

    private void inicializarVistas() {
        TXTresultado = findViewById(R.id.TXTresultado);
        BTNmostrar = findViewById(R.id.BTNmostrar);
        BTNinvertir = findViewById(R.id.BTNinvertir);
        ETnombre = findViewById(R.id.ETnombre);
        ETcelular = findViewById(R.id.ETcelular);
    }

    private void MostrarTexto(){

        TXTresultado.setText("Nombre: " + this.nombre + "\nCelular: " + this.celular);
    }

    private void InvertirNumero(){
        int resto = 0, invertido = 0;
        while (this.celular > 0)
        {
            resto = this.celular % 10;
            invertido = resto + (10 * invertido);
            this.celular /= 10;
        }

        TXTresultado.setText(("Invertido: " + invertido));
    }

    public void ObtenerValores() {
        nombre = ETnombre.getText().toString();
        celular = Integer.parseInt(ETcelular.getText().toString());

    }

    @Override
    public void onClick(View view) {
        ObtenerValores();
        switch (view.getId()) {
            case R.id.BTNmostrar:
                MostrarTexto();
                break;
            case R.id.BTNinvertir:
                InvertirNumero();
                break;

        }
    }
}
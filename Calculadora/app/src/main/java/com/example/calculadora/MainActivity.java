package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText numeroUno;
    private EditText numeroDos;
    private TextView showResultado;
    private double n1, n2;
    private double result;

    private boolean camposVacios(String... fields) {
        for (String field : fields) {
            if (field.isEmpty()) {
                return true;
            }
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numeroUno = (EditText) findViewById(R.id.txtPrimerValor); // El id se encuentra en el activity_main.xml
        numeroDos = (EditText) findViewById(R.id.txtSegundoValor);
        showResultado = (Textiew) findViewById(R.id.lblResultado);
    }

    // Metodo asociado al boton del activity_main.xml
    public void Suma(View v) {
        if (!camposVacios(numeroUno.getText().toString(), numeroDos.getText().toString())) {
            n1 = Double.parseDouble(numeroUno.getText().toString());
            n2 = Double.parseDouble(numeroDos.getText().toString());
            result = n1 + n2;

            showResultado.setText(String.format("%.0f", result));
        } else {
            Toast.makeText(MainActivity.this, "Debe ingresar algún valor . . .", Toast.LENGTH_SHORT).show();
        }
    }

    // Metodo asociado al boton del activity_main.xml
    public void Resta(View v) {
        if (!camposVacios(numeroUno.getText().toString(), numeroDos.getText().toString())) {
            n1 = Double.parseDouble(numeroUno.getText().toString());
            n2 = Double.parseDouble(numeroDos.getText().toString());
            result = n1 - n2;

            showResultado.setText(String.format("%.0f", result));
        } else {
            Toast.makeText(MainActivity.this, "Debe ingresar algún valor . . .", Toast.LENGTH_SHORT).show();
        }
    }

    // Metodo asociado al boton del activity_main.xml
    public void Multiplicacion(View v) {
        if (!camposVacios(numeroUno.getText().toString(), numeroDos.getText().toString())) {
            n1 = Double.parseDouble(numeroUno.getText().toString());
            n2 = Double.parseDouble(numeroDos.getText().toString());
            result = n1 * n2;

            showResultado.setText(String.format("%.0f", result));
        } else {
            Toast.makeText(MainActivity.this, "Debe ingresar algún valor . . .", Toast.LENGTH_SHORT).show();
        }
    }

    // Metodo asociado al boton del activity_main.xml
    public void Division(View v) {
        if (!camposVacios(numeroUno.getText().toString(), numeroDos.getText().toString())) {
            n1 = Double.parseDouble(numeroUno.getText().toString());
            n2 = Double.parseDouble(numeroDos.getText().toString());

            if (n2 == 0) {
                showResultado.setText("No se puede dividir entre cero");
            } else {
                result = n1 / n2;
                showResultado.setText(String.valueOf(result));
            }
        } else {
            Toast.makeText(MainActivity.this, "Debe ingresar algún valor . . .", Toast.LENGTH_SHORT).show();
        }
    }
}

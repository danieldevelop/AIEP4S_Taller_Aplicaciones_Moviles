package com.example.practica_navegar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.txt_Web);
    }

    public void PaginaWeb(View v) {
        Intent p = new Intent(this, PaginaWeb.class);
        p.putExtra("sitio", et1.getText().toString());
        startActivity(p);
    }
}
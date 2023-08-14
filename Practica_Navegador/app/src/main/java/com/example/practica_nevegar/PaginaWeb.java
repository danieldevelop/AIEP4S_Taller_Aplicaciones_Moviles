package com.example.practica_navegar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PaginaWeb extends AppCompatActivity {

    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_web);

        wv1 = (WebView) findViewById(R.id.wb_1);
        String url = getIntent().getStringExtra("sitio");
        wv1.setWebViewClient(new WebViewClient()); // Navegador por defecto del dispositivo
        // wv1.setWebChromeClient();
        wv1.loadUrl("https://"+url);
    }

    public void Cerrar(View v) {
        finish();
    }
}
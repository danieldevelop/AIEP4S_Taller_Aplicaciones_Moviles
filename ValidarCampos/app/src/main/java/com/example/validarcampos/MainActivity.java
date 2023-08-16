package com.example.validarcampos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edt1;
    private EditText edt2;
    private Context main = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.txt_Nombre);
        edt2 = (EditText) findViewById(R.id.txt_Clave);
    }


    public void validateField(View view) 
    {
        String username = edt1.getText().toString();
        String password = edt2.getText().toString();

        try {
            if (username.equals("") && password.equals("")) {
                Toast.makeText(main, "Ups! los campos no pueden estar vacios.", Toast.LENGTH_LONG).show();
            } else {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(main);
                alertDialog.setTitle("Sign In");
                alertDialog.setMessage("!Bienvenido Sr/a usuario")
                    .setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).show();
            }

        } catch (Exception e) {
            Log.e("DG-1", e.getMessage());
        }
    }
}

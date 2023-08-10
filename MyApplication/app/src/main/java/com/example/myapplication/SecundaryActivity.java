package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SecundaryActivity extends AppCompatActivity {

    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundary);
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();

        Toast.myToast(context);
    }

    // Live cycle onStart
    // onStart
    @Override protected void onStart() {
        super.onStart();
        Test.Start(context);
    }
    // onResume
    @Override protected void onResume() {
        super.onResume();
        Test.Resume(context);
    }
    // onPause
    @Override protected void onPause() {
        Test.Pause(context);
        super.onPause();
    }
    // onStop
    @Override protected void onStop() {
        super.onStop();
        Test.Stop(context);
    }
    // onRestart
    @Override protected void onRestart() {
        super.onRestart();
        Test.Restart(context);
    }
    // onDestroy
    @Override protected void onDestroy() {
        Test.Destroy(context);
        super.onDestroy();
    }
}
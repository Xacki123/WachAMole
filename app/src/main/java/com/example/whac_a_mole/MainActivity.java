package com.example.whac_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences pref;
    private int i;
    private TextView record;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    public void goGame(View view) {
        Intent intent = new Intent(MainActivity.this,ActivityGame.class);
        startActivity(intent);
    }
    private void init()
    {
        record = findViewById(R.id.score);
        pref = getSharedPreferences("record", MODE_PRIVATE);
        i = pref.getInt("TopRecord", 0);
        record.setText("Record = " + i);
    }
}
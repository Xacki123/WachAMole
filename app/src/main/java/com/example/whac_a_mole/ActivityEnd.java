package com.example.whac_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityEnd extends AppCompatActivity {
    public TextView score, record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        init();
        getIntentMain();
    }
    public void agane (View view){
        Intent intent = new Intent(ActivityEnd.this,ActivityGame.class);
        startActivity(intent);
    }
    public void menu (View view){
        Intent intent = new Intent(ActivityEnd.this,MainActivity.class);
        startActivity(intent);
    }
    public void init(){
        score = findViewById(R.id.youscore);
        record = findViewById(R.id.score);
    }
    private void getIntentMain() {

        Intent intent = getIntent();
        if (intent != null) {
            score.setText("Score = " + intent.getIntExtra("score", 0));
            record.setText("Record = " + intent.getIntExtra("record", 0));
        }
    }

}
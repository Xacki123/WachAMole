package com.example.whac_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ActivityGame extends AppCompatActivity {

    private ImageView a1,a2,a3,a4,a5,a6,a7,a8,a9;
    public TextView score, timer;
    public int sc = 0;
    private SharedPreferences pref;
    private Button str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        init();



    }
    public void init()
    {
    a1 = findViewById(R.id.a1);
    a2 = findViewById(R.id.a2);
    a3 = findViewById(R.id.a3);
    a4 = findViewById(R.id.a4);
    a5 = findViewById(R.id.a5);
    a6 = findViewById(R.id.a6);
    a7 = findViewById(R.id.a7);
    a8 = findViewById(R.id.a8);
    a9 = findViewById(R.id.a9);
    score = findViewById(R.id.score);
    timer = findViewById(R.id.time);
    score.setText("Score= " + sc);
    str = findViewById(R.id.start);
    pref = getSharedPreferences("record", MODE_PRIVATE);
    a1.setClickable(false);
    a2.setClickable(false);
    a3.setClickable(false);
    a4.setClickable(false);
    a5.setClickable(false);
    a6.setClickable(false);
    a7.setClickable(false);
    a8.setClickable(false);
    a9.setClickable(false);

    }
    public void svapSetRe()
    {
        switch (getRandomIntegerBetweenRange())
        {
            case 1:
                a1.setImageResource(R.drawable.krot2);
                a1.setClickable(true);
                timerAct(a1);
                break;
            case 2:
                a2.setImageResource(R.drawable.krot2);
                a2.setClickable(true);
                timerAct(a2);
                break;
            case 3:
                a3.setImageResource(R.drawable.krot2);
                a3.setClickable(true);
                timerAct(a3);
                break;
            case 4:
                a4.setImageResource(R.drawable.krot2);
                a4.setClickable(true);
                timerAct(a4);
                break;
            case 5:
                a5.setImageResource(R.drawable.krot2);
                a5.setClickable(true);
                timerAct(a5);
                break;
            case 6:
                a6.setImageResource(R.drawable.krot2);
                a6.setClickable(true);
                timerAct(a6);
                break;
            case 7:
                a7.setImageResource(R.drawable.krot2);
                a7.setClickable(true);
                timerAct(a7);
                break;
            case 8:
                a8.setImageResource(R.drawable.krot2);
                a8.setClickable(true);
                timerAct(a8);
                break;
            case 9:
                a9.setImageResource(R.drawable.krot2);
                a9.setClickable(true);
                timerAct(a9);
                break;
        }
    }




    public void timer()
    {
        CountDownTimer my_timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished)
            {
                timer.setText(Long.toString(millisUntilFinished/1000));
                svapSetRe();
            }

            @Override
            public void onFinish()
            {
                recordChek();
                Intent intent = new Intent(ActivityGame.this,ActivityEnd.class);
                intent.putExtra("score", sc);
                intent.putExtra("record", pref.getInt("TopRecord", 0));
                startActivity(intent);
            }
        };
        my_timer.start();
    }

    public void start (View view)
    {
        timer();
        str.setVisibility(View.GONE);
    }
    public void a1clik (View view)
    {
        sc = sc+1;
        score.setText("Score= "+sc);
    }
    public void a2clik (View view)
    {
        sc = sc+1;
        score.setText("Score= "+sc);
    }
    public void a3clik (View view)
    {
        sc = sc+1;
        score.setText("Score= "+sc);
    }
    public void a4clik (View view)
    {
        sc = sc+1;
        score.setText("Score= "+sc);
    }
    public void a5clik (View view)
    {
        sc = sc+1;
        score.setText("Score= "+sc);
    }
    public void a6clik (View view)
    {
        sc = sc+1;
        score.setText("Score= "+sc);
    }
    public void a7clik (View view)
    {
        sc = sc+1;
        score.setText("Score= "+sc);
    }
    public void a8clik (View view)
    {
        sc = sc+1;
        score.setText("Score= "+sc);
    }
    public void a9clik (View view)
    {
        sc = sc+1;
        score.setText("Score= "+sc);
    }
    public int getRandomIntegerBetweenRange() // randomazer
    {
        int x = (int)(Math.random()*((9-1)+1))+1;
        return x;
    }
    public void timerAct(ImageView f) // timer active mole
    {
        CountDownTimer my_timer2 = new CountDownTimer(500, 1000) {
            @Override
            public void onTick(long millisUntilFinished)
            {

                            }

            @Override
            public void onFinish()
            {
                f.setImageResource(R.drawable.krot);
                f.setClickable(false);
            }
        };
        my_timer2.start();
    }
    public void recordChek() // record comparison
    {
        int u = pref.getInt("TopRecord", 0);
        if (u < sc) {
            SharedPreferences.Editor edit = pref.edit();
            edit.putInt("TopRecord", sc);
            edit.apply();
        }
    }



}
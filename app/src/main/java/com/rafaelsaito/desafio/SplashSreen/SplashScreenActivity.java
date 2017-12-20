package com.rafaelsaito.desafio.SplashSreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rafaelsaito.desafio.Acoes_Sociais.AcaoActivity;
import com.rafaelsaito.desafio.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, AcaoActivity.class);
                startActivity(intent);
            }
        }, 2000);

    }
}

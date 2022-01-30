package br.ufjf.dcc196.filipehaider.prototipoapptcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {

    TextView textView01, textView02, textView03;
    Animation uptodown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        textView01 = findViewById(R.id.textView01);
        textView02 = findViewById(R.id.textView02);
        textView03 = findViewById(R.id.textView03);

        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);

        textView01.setAnimation(uptodown);
        textView02.setAnimation(uptodown);
        textView03.setAnimation(uptodown);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(IntroActivity.this, ApresentacaoActivity.class);
                startActivity(i);
            }
        },3500);
    }
}
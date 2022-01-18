package br.ufjf.dcc196.filipehaider.prototipoapptcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EscolhaNarrativaActivity extends AppCompatActivity {
    Button buttonVoltar2;
    TextView textViewJavaEE, textViewArq01, textViewArq02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_narrativa);

        buttonVoltar2 = findViewById(R.id.buttonVoltar2);
        textViewJavaEE = findViewById(R.id.textViewJavaEE);
        textViewArq01 = findViewById(R.id.textViewArq01);
        textViewArq02 = findViewById(R.id.textViewArq02);

        textViewJavaEE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EscolhaNarrativaActivity.this, CreditosActivity.class);
                startActivity(i);
            }
        });


        buttonVoltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EscolhaNarrativaActivity.this, ApresentacaoActivity.class);
                startActivity(i);
            }
        });
    }
}
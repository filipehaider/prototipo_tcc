package br.ufjf.dcc196.filipehaider.prototipoapptcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InstrucoesActivity extends AppCompatActivity {

    Button buttonIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucoes);

        buttonIniciar = findViewById(R.id.buttonIniciar);

        buttonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InstrucoesActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
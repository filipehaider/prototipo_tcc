package br.ufjf.dcc196.filipehaider.prototipoapptcc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonOp1, buttonOp2, buttonOp3;
    TextView textViewTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOp1 = findViewById(R.id.buttonOp1);
        buttonOp2 = findViewById(R.id.buttonOp2);
        buttonOp3 = findViewById(R.id.buttonOp3);
        textViewTexto = findViewById(R.id.textViewTexto);


        buttonOp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewTexto.setText("Voce escolheu a opção 1");
                //story.chooseChoiceIndex(0);
            }
        });

        buttonOp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewTexto.setText("Parabéns o caminho escolhido foi o 2");
                //story.chooseChoiceIndex(0);
            }
        });

        buttonOp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewTexto.setText("Caminho de número 3");
                //story.chooseChoiceIndex(0);
            }
        });



    }
}
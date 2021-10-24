package br.ufjf.dcc196.filipehaider.prototipoapptcc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bladecoder.ink.runtime.Choice;
import com.bladecoder.ink.runtime.Story;

public class MainActivity extends AppCompatActivity {

    Button buttonOp1, buttonOp2, buttonOp3;
    TextView textViewTexto;
    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOp1 = findViewById(R.id.buttonOp1);
        buttonOp2 = findViewById(R.id.buttonOp2);
        buttonOp3 = findViewById(R.id.buttonOp3);
        textViewTexto = findViewById(R.id.textViewTexto);
        String  sourceJsonString = getString(R.string.historia_1);
        story = null;
        try {
            story = new Story(sourceJsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }


        buttonOp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewTexto.setText("Voce escolheu a opção 1");
                try {
                    story.chooseChoiceIndex(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        buttonOp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewTexto.setText("Parabéns o caminho escolhido foi o 2");
                //story.chooseChoiceIndex(1);
            }
        });

        buttonOp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewTexto.setText("Caminho de número 3");
                //story.chooseChoiceIndex(2);
            }
        });
    }

    public void atualizaTela(){
        try {
        // 2) Game content, line by line
        while (story.canContinue()) {
            String line = null;
                line = story.Continue();
                // Carregar o trecho do texto


// 3) Display story.currentChoices list, allow player to choose one
        if (story.getCurrentChoices().size() > 0) {
            for (Choice c : story.getCurrentChoices()) {
                System.out.println(c.getText());
                // Carregar o texto dos botoes
            }


        } }
        } catch (Exception e) {
                e.printStackTrace();
            }

    }


}
package br.ufjf.dcc196.filipehaider.prototipoapptcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bladecoder.ink.runtime.Choice;
import com.bladecoder.ink.runtime.Story;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button buttonOp1, buttonOp2, buttonOp3;
    TextView textViewTexto;
    Story story;
    Integer j;
    Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new Button[3];
        buttonOp1 = findViewById(R.id.buttonOp1);
        buttonOp2 = findViewById(R.id.buttonOp2);
        buttonOp3 = findViewById(R.id.buttonOp3);
        //Insere os botões em um vetor;
        buttons[0]=buttonOp1;
        buttons[1]=buttonOp2;
        buttons[2]=buttonOp3;
        textViewTexto = findViewById(R.id.textViewTexto);

       /*String  sourceJsonString = getJsonFromAssets(getApplicationContext(),"ExemploPokemon.ink.json");
        try {
            System.out.println(sourceJsonString);
            story = new Story(sourceJsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        // Indicado pelo bladecoder
        String json = null;
        try {
            json = getJsonString("ExemploPokemon.ink.json", getApplicationContext());
            story = new Story(json);
            StringBuilder sb = new StringBuilder();
            while (story.canContinue()) {
                String line = story.Continue();
                sb.append(line);
            }
            textViewTexto.setText(sb.toString());
            if (story.getCurrentChoices().size() > 0) {
                for (int i=0; i<story.getCurrentChoices().size();i++) {
                    Choice c  = story.getCurrentChoices().get(i);
                    buttons[i].setText(c.getText());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            textViewTexto.setText(e.toString());
        } catch (Exception e) {
            e.printStackTrace();
            textViewTexto.setText(e.toString());
        }


        buttonOp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // textViewTexto.setText("Voce escolheu a opção 1");
                try {
                    story.chooseChoiceIndex(0);
                    atualizaTela();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        buttonOp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //textViewTexto.setText("Parabéns o caminho escolhido foi o 2");
                try {
                    story.chooseChoiceIndex(1);
                    atualizaTela();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        buttonOp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // textViewTexto.setText("Caminho de número 3");
                try {
                    story.chooseChoiceIndex(2);
                    atualizaTela();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        // Pode haver mais botões de opções;
    }




    /*static String getJsonFromAssets(Context context, String filename) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return jsonString;
    }*/




    // Indicado pelo bladecoder
    private String getJsonString(String filename, Context context) throws IOException {
        AssetManager manager = context.getAssets();
        InputStream is = manager.open(filename);

        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            // Replace the BOM mark
            if(line != null)
                line = line.replace('\uFEFF', ' ');

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }





    public void atualizaTela(){
        try {
                // Mostrar no TextView o texto principal linha por linha
            while (story.canContinue()) {
                String line;
                    line = story.Continue();
                    textViewTexto.setText(line);

                // Exibir o texto da lista story.currentChoices (opções) nos botões
            if (story.getCurrentChoices().size() > 0) {
                for (j=0; j<story.getCurrentChoices().size(); j++){
                    buttons[j].setText(story.getCurrentChoices().get(j).getText());
                }

            } }
        } catch (Exception e) {
                e.printStackTrace();
            }
    }

}
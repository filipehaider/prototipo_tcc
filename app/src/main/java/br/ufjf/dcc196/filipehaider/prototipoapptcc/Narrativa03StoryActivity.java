package br.ufjf.dcc196.filipehaider.prototipoapptcc;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bladecoder.ink.runtime.Choice;
import com.bladecoder.ink.runtime.Story;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Narrativa03StoryActivity extends AppCompatActivity {

    TextView textViewTexto, textViewAlternativa01, textViewAlternativa02, textViewAlternativa03;
    Story story;
    Integer j;
    TextView[] textviews;
    ScrollView scrollView01;
    Animation fade_in;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javaee_story);
        scrollView01 = findViewById(R.id.scrollView01);
        textViewTexto = findViewById(R.id.textViewTexto);

        textviews = new TextView[3];
        textViewAlternativa01 = findViewById(R.id.textViewAlternativa01);
        textViewAlternativa02 = findViewById(R.id.textViewAlternativa02);
        textViewAlternativa03 = findViewById(R.id.textViewAlternativa03);
        //Insere os textviews em um vetor;
        textviews[0] = textViewAlternativa01;
        textviews[1] = textViewAlternativa02;
        textviews[2] = textViewAlternativa03;
        textviews[0].setVisibility(View.INVISIBLE);
        textviews[1].setVisibility(View.INVISIBLE);
        textviews[2].setVisibility(View.INVISIBLE);


        fade_in = AnimationUtils.loadAnimation(this,R.anim.fade_in);


        String json = null;
        try {
            json = getJsonString("Narrativa_03.ink.json", getApplicationContext());
            story = new Story(json);
            StringBuilder sb = new StringBuilder();
            while (story.canContinue()) {
                String line = story.Continue();
                sb.append(line);
            }
            textViewTexto.setText(sb.toString());

            if (story.getCurrentChoices().size() > 0) {
                for (int i = 0; i < story.getCurrentChoices().size(); i++) {
                    Choice c = story.getCurrentChoices().get(i);
                    textviews[i].setText(c.getText());
                    textViewTexto.setAnimation(fade_in);
                    textviews[i].setAnimation(fade_in);
                    textviews[i].setVisibility(View.VISIBLE);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            textViewTexto.setText(e.toString());
        } catch (Exception e) {
            e.printStackTrace();
            textViewTexto.setText(e.toString());
        }


        textViewAlternativa01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    story.chooseChoiceIndex(0);
                    atualizaTela();
                     textViewTexto.setAnimation(fade_in);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        textViewAlternativa02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    story.chooseChoiceIndex(1);
                    atualizaTela();
                    textViewTexto.setAnimation(fade_in);
                 } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        textViewAlternativa03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    story.chooseChoiceIndex(2);
                    atualizaTela();
                    textViewTexto.setAnimation(fade_in);
                 } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }




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

                // Exibir o texto da lista story.currentChoices (alternativas) nos textviews que possuem opções (visiveis)
                for (int i = 0; i < 3; i++) {
                    textviews[i].setVisibility(View.INVISIBLE);
                    textViewTexto.setAnimation(fade_in);

                }
            if (story.getCurrentChoices().size() > 0) {
                for (j=0; j<story.getCurrentChoices().size(); j++){
                    textviews[j].setText(story.getCurrentChoices().get(j).getText());
                    textViewTexto.startAnimation(fade_in);
                    textviews[j].startAnimation(fade_in);
                    textviews[j].setVisibility(View.VISIBLE);
                }
            } }
        } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
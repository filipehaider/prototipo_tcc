package br.ufjf.dcc196.filipehaider.prototipoapptcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreditosActivity extends AppCompatActivity {
    Button buttonVoltar;
    TextView textViewFilipe, textViewIgor;
    String emailFilipe = "filipe.haider@ice.ufjf.br";
    String emailIgor = "igorknop@ice.ufjf.br";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);
        buttonVoltar = findViewById(R.id.buttonVoltar);
        textViewFilipe = findViewById(R.id.textViewFilipe);
        textViewIgor = findViewById(R.id.textViewIgor);


        textViewFilipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                     Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + emailFilipe));
                           // i.putExtra(Intent.EXTRA_EMAIL, emailFilipe);
                            i.putExtra(Intent.EXTRA_SUBJECT, "Dúvida sobre o app");
                            i.putExtra(Intent.EXTRA_TEXT, "Enviado através do app ES Interativa");
                            startActivity(Intent.createChooser(i, "Chooser"));
            }
        });

        textViewIgor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + emailIgor));
                // i.putExtra(Intent.EXTRA_EMAIL, emailIgor);
                i.putExtra(Intent.EXTRA_SUBJECT, "Dúvida sobre o app");
                i.putExtra(Intent.EXTRA_TEXT, "Enviado através do app ES Interativa");
                startActivity(Intent.createChooser(i, "Chooser"));
            }
        });


        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CreditosActivity.this, ApresentacaoActivity.class);
                startActivity(i);
            }
        });
    }
}
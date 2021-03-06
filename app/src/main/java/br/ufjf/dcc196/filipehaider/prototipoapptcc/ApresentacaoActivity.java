package br.ufjf.dcc196.filipehaider.prototipoapptcc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ApresentacaoActivity extends AppCompatActivity {

    Button buttonJogar, buttonInstrucoes, buttonCreditos, buttonSair;
    TextView textViewTitulo;
    Animation lefttoright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresentacao);

        buttonJogar = findViewById(R.id.buttonJogar);
        buttonInstrucoes = findViewById(R.id.buttonInstrucoes);
        buttonCreditos = findViewById(R.id.buttonCreditos);
        buttonSair = findViewById(R.id.buttonSair);
        textViewTitulo = findViewById(R.id.textViewTitulo);

        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);

        textViewTitulo.setAnimation(lefttoright);
        buttonJogar.setAnimation(lefttoright);
        buttonInstrucoes.setAnimation(lefttoright);
        buttonCreditos.setAnimation(lefttoright);
        buttonSair.setAnimation(lefttoright);


        buttonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ApresentacaoActivity.this, EscolhaNarrativaActivity.class);
                startActivity(i);
            }
        });

        buttonInstrucoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ApresentacaoActivity.this, InstrucoesActivity.class);
                startActivity(i);
            }
        });

        buttonCreditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ApresentacaoActivity.this, CreditosActivity.class);
                startActivity(i);
            }
        });

        buttonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                exibirConfirmacaoSaida();
            }
        });
    }

    // Encerra o app clicando no bot??o "Sair"
    public void exibirConfirmacaoSaida() {
        AlertDialog.Builder msgBox = new AlertDialog.Builder(this);
        msgBox.setTitle("Saindo. . .");
        msgBox.setMessage("Deseja realmente sair do sistema?");
        msgBox.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getBaseContext(),"Obrigado por utilizar o nosso aplicativo!",Toast.LENGTH_LONG).show();
                finish();
                // O usu??rio encerra o app e recebe a mensagem
            }
        });
        msgBox.setNegativeButton("N??o", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // o usu??rio permanece no app
            }
        });
        msgBox.show();
    }

    // Encerra o app clicando na seta de voltar do Android somente na ApresentacaoActivity
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja realmente sair do sistema?")
                .setTitle("Saindo. . .")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ApresentacaoActivity.super.onBackPressed();
                        finish();
                        Toast.makeText(getBaseContext(),"Obrigado por utilizar o nosso aplicativo!",Toast.LENGTH_LONG).show();
                        // O usu??rio encerra o app e recebe a mensagem
                    }
                })
                .setNegativeButton("N??o", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        // o usu??rio permanece no app
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
    }
}
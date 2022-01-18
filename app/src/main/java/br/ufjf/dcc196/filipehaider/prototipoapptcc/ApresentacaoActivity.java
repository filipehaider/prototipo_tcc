package br.ufjf.dcc196.filipehaider.prototipoapptcc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ApresentacaoActivity extends AppCompatActivity {

    Button buttonJogar, buttonInstrucoes, buttonCreditos, buttonSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresentacao);

        buttonJogar = findViewById(R.id.buttonJogar);
        buttonInstrucoes = findViewById(R.id.buttonInstrucoes);
        buttonCreditos = findViewById(R.id.buttonCreditos);
        buttonSair = findViewById(R.id.buttonSair);


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

    // Encerra o app clicando no botão "Sair"
    public void exibirConfirmacaoSaida() {
        AlertDialog.Builder msgBox = new AlertDialog.Builder(this);
        msgBox.setTitle("Saindo. . .");
        msgBox.setMessage("Deseja realmente sair do sistema?");
        msgBox.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getBaseContext(),"Obrigado por utilizar o nosso aplicativo!",Toast.LENGTH_LONG).show();
                finish();
                // O usuário encerra o app e recebe a mensagem
            }
        });
        msgBox.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // o usuário permanece no app
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
                        Toast.makeText(getBaseContext(),"Obrigado por utilizar o nosso aplicativo!",Toast.LENGTH_LONG).show();
                        // O usuário encerra o app e recebe a mensagem
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        // o usuário permanece no app
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
    }
}
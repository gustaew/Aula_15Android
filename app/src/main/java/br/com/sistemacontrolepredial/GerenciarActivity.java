package br.com.sistemacontrolepredial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class GerenciarActivity extends AppCompatActivity {

    private EditText campoNomeEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenciar);
        campoNomeEmpresa = null;
    }

    public void cadastrarEmpresa(View view){
        Intent intent = new Intent(this,CadastrarActivity.class);
        startActivity(intent);
    }

    public void pesquisarEmpresa(View view){
        campoNomeEmpresa = (EditText)findViewById(R.id.campoPesquisar);
        String empresaPesquisada = campoNomeEmpresa.getText().toString();
        Intent intent = new Intent(this,ListaEmpresasActivity.class);
        intent.putExtra("empresaPesquisada",empresaPesquisada);
        startActivity(intent);
    }
}

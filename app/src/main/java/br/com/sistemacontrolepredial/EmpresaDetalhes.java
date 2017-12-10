package br.com.sistemacontrolepredial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EmpresaDetalhes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_detalhes);
        Intent intent = getIntent();
        TextView nomeEmpresa = (TextView)findViewById(R.id.tituloFormEmpresaDetalhes);
        nomeEmpresa.setText(intent.getStringExtra("nomeEmpresa"));
    }
}

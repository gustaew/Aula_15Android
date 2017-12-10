package br.com.sistemacontrolepredial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class ListaEmpresasActivity extends AppCompatActivity {

    private List<String> empresas;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_empresas);
        preencherLista();
        Intent intent = getIntent();
        String empresaPesquisada = intent.getStringExtra("empresaPesquisada");
        listView = (ListView) findViewById(R.id.listaEmpresa);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,buscaEmpresa(empresaPesquisada));
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new ListView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListaEmpresasActivity.this,EmpresaDetalhes.class);
                intent.putExtra("nomeEmpresa",listView.getItemAtPosition(i) + "");
                startActivity(intent);
            }
        });

    }

    public List<String>buscaEmpresa(String empresaPesquisada){
        List<String>listaEmpresas = new ArrayList<String>();

        if(!empresaPesquisada.isEmpty()){

            for(String elemento : empresas){
                if(elemento.contains(empresaPesquisada)){
                    listaEmpresas.add(elemento);
                }
            }

        } else {
            listaEmpresas = empresas;
        }

        return listaEmpresas;
    }

    public void preencherLista(){
        empresas = new ArrayList<String>();
        empresas.add("TransporteInc");
        empresas.add("MyFindComida");
        empresas.add("Sistema predial");
        empresas.add("Portland");
        empresas.add("MixStudio");
        empresas.add("Lutx Importação e Exportação");
        empresas.add("Advocacia Lima");
        empresas.add("BlockBit Consultoria");
    }
}

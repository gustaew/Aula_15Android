package br.com.sistemacontrolepredial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usuarioCampo;
    private EditText senhaCampo;
    private final String ADMIN = "admin@sistemapredial.com";
    private final String SENHA = "predio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuarioCampo = null;
        senhaCampo = null;
    }

    public void realizarLogin(View view){
        usuarioCampo = (EditText)findViewById(R.id.campoNome);
        senhaCampo = (EditText)findViewById(R.id.campoSenha);

        String usuario = usuarioCampo.getText().toString();
        String senha =  senhaCampo.getText().toString();

        if(usuario.isEmpty() || senha.isEmpty()){
            Toast.makeText(this, R.string.camposVazio, Toast.LENGTH_LONG).show();
        }else {
            if (usuario.equals(ADMIN) && senha.equals(SENHA)) {

                Intent intent = new Intent(this, GerenciarActivity.class);
                startActivity(intent);

                this.getWindow().setTitle(usuario);
                Toast.makeText(this, R.string.loginRealizado, Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(this, R.string.SenhaUsuarioErrado, Toast.LENGTH_LONG).show();
            }
        }



    }
}

package br.com.controlecolesterol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaInicialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
    }

    public void telaMedicamentos(View view) {
        Intent intent = new Intent(this, MedicamentosActivity.class);
        startActivity(intent);
    }

    public void telaAlimentos(View view) {
        Intent intent = new Intent(this, AlimentoActivity.class);
        startActivity(intent);
    }

    public void telaUsuario(View view) {
        Intent intent = new Intent(this, UsuarioActivity.class);
        startActivity(intent);
    }
}
package br.com.controlecolesterol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AlimentoActivity extends AppCompatActivity {

    private EditText edNomeAlim;
    private CheckBox cbAlimentoBom, cbAlimentoRuim;
    private String nome;
    private int cbSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimento);

        edNomeAlim = (EditText) findViewById(R.id.edNomeAlim);
        cbAlimentoBom = (CheckBox) findViewById(R.id.cbBomAlim);
        cbAlimentoRuim = (CheckBox) findViewById(R.id.cbRuimAlim);

    }

    public void limparAlim(View view) {

        edNomeAlim.setText("");
        cbAlimentoBom.setChecked(false);
        cbAlimentoRuim.setChecked(false);
        mostrarMensagem(getString(R.string.mensagem_limpar));

    }

    private void mostrarMensagem(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }

    public void salvarAlim(View view) {

        nome = edNomeAlim.getText().toString();

        if(nome == "" || nome.trim().isEmpty()) {
            mostrarMensagem("Informe o nome do alimento");
            edNomeAlim.requestFocus();
            return;
        }

        if(!cbAlimentoBom.isChecked() && !cbAlimentoRuim.isChecked()) {
            mostrarMensagem("informe a qualidade do alimento");
            cbAlimentoBom.requestFocus();
            return;
        }

        if(cbAlimentoBom.isChecked()){
            cbSelecionado = R.id.cbBomAlim;
            mostrarMensagem("Alimento " +getString(R.string.alimento_bom) + " selecionado");
        }
        if(cbAlimentoRuim.isChecked()){
            cbSelecionado = R.id.cbRuimAlim;
            mostrarMensagem("Alimento " +getString(R.string.alimento_ruim) + " selecionado");
        }

        mostrarMensagem(getString(R.string.mensagem_salvar));

    }
}
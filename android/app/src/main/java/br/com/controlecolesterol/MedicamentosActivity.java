package br.com.controlecolesterol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import static java.util.Arrays.asList;

public class MedicamentosActivity extends AppCompatActivity {

    private EditText edNomeMed, edTratamentoMed, edDiasMed, edIntervaloMed;
    private String nome, tratamento, dias, intervalo;
    private Spinner spDoenca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamentos);

        edNomeMed = (EditText) findViewById(R.id.edNomeMed);
        edTratamentoMed = (EditText) findViewById(R.id.edTratamentoMed);
        edDiasMed = (EditText) findViewById(R.id.edDiasMed);
        edIntervaloMed = (EditText) findViewById(R.id.edIntervaloMed);
        spDoenca = (Spinner) findViewById(R.id.spDoenca);
    }

    public void limparMed(View view) {

        edNomeMed.setText("");
        edTratamentoMed.setText("");
        edDiasMed.setText("");
        edIntervaloMed.setText("");
        edNomeMed.requestFocus();
        mostrarMensagem(getString(R.string.mensagem_limpar));
    }

    private void mostrarMensagem(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }

    public void salvarMed(View view) {

        nome = edNomeMed.getText().toString();
        tratamento = edTratamentoMed.getText().toString();
        dias = edDiasMed.getText().toString();
        intervalo = edIntervaloMed.getText().toString();

        if(nome == "" || nome.trim().isEmpty()) {
            mostrarMensagem("Informe o nome do medicamento");
            edNomeMed.requestFocus();
            return;
        }
        if(tratamento == "" || tratamento.trim().isEmpty()) {
            mostrarMensagem("Descreva o tratamento indicado pelo medico");
            edTratamentoMed.requestFocus();
            return;
        }
        if(dias == "" || dias.trim().isEmpty()) {
            mostrarMensagem("Informe a quantidade de dias que você deve tomar o remedio");
            edDiasMed.requestFocus();
            return;
        }
        if(intervalo == "" || intervalo.trim().isEmpty()) {
            mostrarMensagem("Informe o intervalo em 'horas' para tomar o medicamento");
            edIntervaloMed.requestFocus();
            return;
        }

        mostrarMensagem(getString(R.string.mensagem_salvar));

    }

    public void mostrarDoencas(View view) {

        List<String> doencas = asList(getString(R.string.colesterol), getString(R.string.outras));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, doencas);
        spDoenca.setAdapter(arrayAdapter);

    }
}
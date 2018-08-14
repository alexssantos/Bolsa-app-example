package br.edu.infnet.bolsa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtNome;
    private EditText mEdtValor;
    private EditText mEdtData;
    private ListView mLvwAcoes;
    private List<Acao> mLista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtNome = findViewById(R.id.edtNome);
        mEdtValor = findViewById(R.id.edtValor);
        mEdtData = findViewById(R.id.edtData);
        mLvwAcoes = findViewById(R.id.lvwBolsa);

        Button btnNovo= findViewById(R.id.btnNovo);
        btnNovo.setOnClickListener(novo);
        }

    private View.OnClickListener novo = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

//            String nome = mEdtNome.getText().toString().trim();
//            String data = mEdtData.getText().toString().trim();
//            String valor = mEdtValor.getText().toString().trim();
//
//            Acao acao = new Acao();
//            acao.setNome(nome);
//            acao.setData(data);
//            acao.setValor(valor);
//
//            mLista.add(acao);
//
//            mLvwAcoes.setAdapter(new AcaoAdapter(getApplicationContext(), mLista));

            Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
            startActivity(intent);

        }
    };


}

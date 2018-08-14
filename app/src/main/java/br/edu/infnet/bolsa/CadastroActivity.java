package br.edu.infnet.bolsa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CadastroActivity extends AppCompatActivity {

    EditText editNome, editData, editValor;
    Button btnSalvar;
    private AcaoDAO mAcaoDAO;

    private int mIdAcao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mAcaoDAO = new AcaoDAO(this);

        editNome = findViewById(R.id.editCadastroNome);
        editData = findViewById(R.id.editCadastroData);
        editValor = findViewById(R.id.editCadastroValor);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(salvar);
    }



    private View.OnClickListener salvar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Acao acao = new Acao();
            acao.setID(mIdAcao);
            acao.setData(editData.getText().toString());
            acao.setNome(editNome.getText().toString());
            acao.setValor(editValor.getText().toString());

            //todo ID valido é maior que zero
            if (mIdAcao > 0){
                mAcaoDAO.alterar(acao);
            }else{
                mAcaoDAO.incluid(acao);
            }


            mIdAcao = 0;
            editNome.setText("");
            editData.setText("");
            editValor.setText("");
        }
    };


}

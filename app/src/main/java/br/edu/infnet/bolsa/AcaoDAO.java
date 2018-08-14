package br.edu.infnet.bolsa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class AcaoDAO {

    private ConexaoDB conexao;

    private final String TABELA = "acoes";
    private final String CAMPO_ID = "ID";
    private final String CAMPO_NOME = "nome";
    private final String CAMPO_DATA = "data";
    private final String CAMPO_VALOR = "valor";


    public AcaoDAO(Context context) {
        this.conexao = ConexaoDB.getInstance(context);
    }


    //Classe burra   **tratamento e validações de dados caso nulo em outra classe
    public void incluid(Acao acao){
        ContentValues content = new ContentValues();
        content.put(CAMPO_NOME, acao.getNome());
        content.put(CAMPO_DATA, acao.getData());
        content.put(CAMPO_VALOR, acao.getValor());

        this.conexao.getDb().insert(TABELA,null,content);
    }

    public void alterar(Acao acao){
        ContentValues content = new ContentValues();
        content.put(CAMPO_NOME, acao.getNome());
        content.put(CAMPO_DATA, acao.getData());
        content.put(CAMPO_VALOR, acao.getValor());

        String Where = CAMPO_ID + " = " + acao.getID();
        this.conexao.getDb().update(TABELA, content, Where, null );
    }

    public void excluir(int id){
        String Where = CAMPO_ID + " = " + id;
        this.conexao.getDb().delete(TABELA, Where, null);
    }

    public Acao obter(int id){
        Acao acao = null;
        String[] campos = {CAMPO_ID, CAMPO_NOME, CAMPO_DATA, CAMPO_VALOR};
        String Where = CAMPO_ID + " = " + id;

        final Cursor cursor = this.conexao.getDb().query(TABELA, campos, Where, null, null, null, null, null);

        if (cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            acao = new Acao();
            acao.setID(cursor.getInt(cursor.getColumnIndex(CAMPO_ID)));
            acao.setNome(cursor.getString(cursor.getColumnIndex(CAMPO_NOME)));
            acao.setData(cursor.getString(cursor.getColumnIndex(CAMPO_DATA)));
            acao.setValor(cursor.getString(cursor.getColumnIndex(CAMPO_VALOR)));
        }

        cursor.close();
        return acao;
    }

    public List<Acao> listar(){
        List<Acao> acoes = new ArrayList<>();
        String[] campos = {CAMPO_ID, CAMPO_NOME, CAMPO_DATA, CAMPO_VALOR};
        final Cursor cursor = this.conexao.getDb().query(TABELA, campos, null, null, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {
                Acao acao = new Acao();
                acao.setID(cursor.getInt(cursor.getColumnIndex(CAMPO_ID)));
                acao.setNome(cursor.getString(cursor.getColumnIndex(CAMPO_NOME)));
                acao.setData(cursor.getString(cursor.getColumnIndex(CAMPO_DATA)));
                acao.setValor(cursor.getString(cursor.getColumnIndex(CAMPO_VALOR)));
                acoes.add(acao);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return acoes;
    }

}

package br.edu.infnet.bolsa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ConexaoDB {

    private static ConexaoDB conexaoDB;
    private SQLiteDatabase db;


//    Só utiliza uma instancia.
//        Diferente das WebApp que tem varias conexao os App só sao
//        utilizados pelo usuario então uma conexao é suficiente
    private ConexaoDB(Context context) {
        DbHelper helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    public static ConexaoDB getInstance(Context context){
        if (conexaoDB == null){
            conexaoDB = new ConexaoDB(context);
        }

        return conexaoDB;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}

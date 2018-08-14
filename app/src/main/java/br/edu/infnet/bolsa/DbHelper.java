package br.edu.infnet.bolsa;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {


//    DB
    private static final String DATABASE_NAME = "bolsa.db";
    private static final int DATABASE_VERSION = 1;              //DB Version Control

//    DB COMMANDS
    private static final String CREATE_TABLE = "CREATE TABLE acoes (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nome TEXT NOT NULL, data TEXT NOT NULL, valor TEXT NOT NULL);";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS acoes";


//    Builder
        //parametro NULL - modo de trabalhar com o cursor e fazer leitura de dados
    public DbHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }


//    Criação do Banco  **NÃO é a classe para fazer inserção;
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(DROP_TABLE);
    onCreate(db);
    }
}

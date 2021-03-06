package br.com.trainning.pdv2;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import se.emilsjolander.sprinkles.Migration;
import se.emilsjolander.sprinkles.Sprinkles;

/**
 * Created by android on 05/03/2016.
 */
public class PdvApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Sprinkles sprinkles = Sprinkles.init(getApplicationContext());

        sprinkles.addMigration(new Migration() {
            @Override
            protected void onPreMigrate() {
                // do nothing
            }

            @Override
            protected void doMigration(SQLiteDatabase db) {
                db.execSQL(
                        "CREATE TABLE Produto (" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                "Descricao TEXT, "+
                                "Unidade TEXT, "+
                                "Preco REAL, "+
                                "CodigoBarra TEXT, "+
                                "Foto TEXT, "+
                                "Latitude REAL, "+
                                "Longitude REAL,"+
                                "Status INTEGER"+
                                ")"
                );

                db.execSQL(
                        "CREATE TABLE Item (" +
                                "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                "id_compra TEXT, "+
                                "id_produto TEXT, "+
                                "quantidade INTEGER "+
                                ")"
                );
            }

            @Override
            protected void onPostMigrate() {
                // do nothing
            }
        });
    }

}

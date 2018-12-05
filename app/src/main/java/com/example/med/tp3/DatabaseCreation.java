package com.example.med.tp3;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

abstract class DatabaseCreation extends SQLiteOpenHelper {
    public static final String user_KEY = "id";
    public static final String login = "login";
    public static final String pass = "password";

    public static final String TABLE_NAME = "Login";
    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    user_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    login + " String, " +
                    pass + " String);";

    public DatabaseCreation(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }
    public static final String METIER_TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(METIER_TABLE_DROP);
        onCreate(db);
    }

}

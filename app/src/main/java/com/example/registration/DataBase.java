package com.example.registration;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {


    public static final String USERS_TABLE = "USERS_TABLE";
    public static final String COLUMN_MAIL_TEXT = "MAIL_TEXT";
    public static final String COLUMN_USERNAME_TEXT = "USERNAME_TEXT";
    public static final String COLUMN_PASS_TEXT = "PASS_TEXT";
    public static final String COLUMN_ID = "ID";

    public DataBase(@Nullable Context context) {
        super(context, "Users.db", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     String createTableStatement = "CREATE TABLE " + USERS_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_MAIL_TEXT + " TEXT, " + COLUMN_USERNAME_TEXT + " TEXT, " + COLUMN_PASS_TEXT + " TEXT)  ";

     db.execSQL(createTableStatement);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public boolean addOne  (Users user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_MAIL_TEXT , user.getMail() );
        cv.put(COLUMN_USERNAME_TEXT , user.getUserName() );
        cv.put(COLUMN_PASS_TEXT , user.getPass() );

        long insert = db.insert(USERS_TABLE, null, cv);
        if (insert == -1) {
            return true;
        }
        return false;
    }
}

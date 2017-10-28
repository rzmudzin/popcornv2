package com.phoenixroberts.popcorn.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rzmudzinski on 10/21/17.
 */

public class MoviesDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "movies.db";
    private static final int DATABASE_VERSION = 3;

    public MoviesDBHelper(Context c) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String CREATE_FAVORITES_TABLE_SQL = "CREATE TABLE " + MoviesDBContracts.FavoritesTable.TABLE_NAME + " ("
                + MoviesDBContracts.FavoritesTable._ID + " INTEGER PRIMARY KEY, "
                + MoviesDBContracts.FavoritesTable.TITLE + " TEXT NOT NULL, "
                + MoviesDBContracts.FavoritesTable.POSTER_PATH + " TEXT NOT NULL"
                + ");";
        sqLiteDatabase.execSQL(CREATE_FAVORITES_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        final String CREATE_FAVORITES_TABLE_SQL = "DROP TABLE IF EXISTS " + MoviesDBContracts.FavoritesTable.TABLE_NAME + ";";
        sqLiteDatabase.execSQL(CREATE_FAVORITES_TABLE_SQL);
        onCreate(sqLiteDatabase);
    }
}

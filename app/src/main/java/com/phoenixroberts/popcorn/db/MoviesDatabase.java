package com.phoenixroberts.popcorn.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.phoenixroberts.popcorn.data.DTO;
import com.phoenixroberts.popcorn.dialogs.DialogService;
import com.phoenixroberts.popcorn.dialogs.Dialogs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rzmudzinski on 10/22/17.
 */

public class MoviesDatabase {
    private Context m_Context;
    private MoviesDBHelper m_MoviesDBHelper;

    public MoviesDatabase(Context c) {
        m_Context=c;
        m_MoviesDBHelper = new MoviesDBHelper(c);
    }
    public List<FavoriteMovie> getFavorites() {
        ArrayList<FavoriteMovie> favoritesList = new ArrayList<FavoriteMovie>();
        SQLiteDatabase db = m_MoviesDBHelper.getReadableDatabase();
        Cursor c = db.query(MoviesDBContracts.FavoritesTable.TABLE_NAME, null, null, null, null, null, null);
        while(c.moveToNext()) {
            int index = c.getColumnIndex(MoviesDBContracts.FavoritesTable._ID);
            int id = c.getInt(index);
            index = c.getColumnIndex(MoviesDBContracts.FavoritesTable.TITLE);
            String title = c.getString(index);
            favoritesList.add(new FavoriteMovie(id,title));
        }
        c.close();
        return favoritesList;
    }
    public FavoriteMovie getFavorite(int movieId) {
        try {
            SQLiteDatabase db = m_MoviesDBHelper.getReadableDatabase();
            Cursor c = db.rawQuery(
                    "SELECT " + MoviesDBContracts.FavoritesTable._ID + ", " + MoviesDBContracts.FavoritesTable.TITLE
                            + " FROM " + MoviesDBContracts.FavoritesTable.TABLE_NAME
                            + " WHERE " + MoviesDBContracts.FavoritesTable._ID + "=" + Integer.toString(movieId),
                    null);
            if (c.getCount() > 0) {
                c.moveToFirst();
                int index = c.getColumnIndex(MoviesDBContracts.FavoritesTable._ID);
                long idl = c.getLong(index);
                int id = c.getInt(index);
                index = c.getColumnIndex(MoviesDBContracts.FavoritesTable.TITLE);
                String title = c.getString(index);
                c.close();
                return new FavoriteMovie(id, title);
            }
            c.close();
        }
        catch (Exception x) {
            Log.e(getClass().toString(), x.getMessage());
        }
        return null;
    }
    public void deleteFavorite(int movieId) {
        SQLiteDatabase db = m_MoviesDBHelper.getWritableDatabase();
        db.delete(MoviesDBContracts.FavoritesTable.TABLE_NAME,
                MoviesDBContracts.FavoritesTable._ID + "=" + movieId, null);
    }
    public void addFavorite(DTO.MoviesListItem movie) {
        try {
            SQLiteDatabase db = m_MoviesDBHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(MoviesDBContracts.FavoritesTable._ID, movie.getId());
            contentValues.put(MoviesDBContracts.FavoritesTable.TITLE, movie.getTitle());
            db.insert(MoviesDBContracts.FavoritesTable.TABLE_NAME, null, contentValues);
        }
        catch(Exception x) {
            Log.e(this.getClass().toString(), "addFavorite Exception: " + x.getMessage());
        }
    }
}

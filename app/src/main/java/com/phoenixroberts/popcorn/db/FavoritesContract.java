package com.phoenixroberts.popcorn.db;

import android.provider.BaseColumns;

/**
 * Created by rzmudzinski on 10/21/17.
 */

public class FavoritesContract {
    public static class FavoritesTable implements BaseColumns {
        public static final String TABLE_NAME = "favorites";
        public static final String TITLE = "title";
    }
}

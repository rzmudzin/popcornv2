package com.phoenixroberts.popcorn.db;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by rzmudzinski on 10/21/17.
 */

public class MoviesDBContracts {
    public static final String AUTHORITY = "com.phoenixroberts.popcorn";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    public static final String FAVORITES_PATH = "favorites";

    public static class FavoritesTable implements BaseColumns {
        public static final String TABLE_NAME = "favorites";
        public static final String TITLE = "title";
    }
}

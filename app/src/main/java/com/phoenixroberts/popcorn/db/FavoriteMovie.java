package com.phoenixroberts.popcorn.db;

/**
 * Created by rzmudzinski on 10/22/17.
 */

public class FavoriteMovie {
    private String m_Title;
    private int m_Id;

    public FavoriteMovie(int id, String title) {
        m_Title=title;
        m_Id=id;
    }
    public String getTitle() {
        return m_Title;
    }
    public int getId() {
        return m_Id;
    }
}

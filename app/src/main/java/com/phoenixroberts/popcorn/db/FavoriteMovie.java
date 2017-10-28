package com.phoenixroberts.popcorn.db;

/**
 * Created by rzmudzinski on 10/22/17.
 */

public class FavoriteMovie {
    private String m_Title;
    private int m_Id;
    private String m_PosterPath;

    public FavoriteMovie(int id, String title, String posterPath) {
        m_Title=title;
        m_Id=id;
        m_PosterPath=posterPath;
    }
    public String getTitle() {
        return m_Title;
    }
    public int getId() {
        return m_Id;
    }
    public String getPosterPath() { return m_PosterPath; }
}

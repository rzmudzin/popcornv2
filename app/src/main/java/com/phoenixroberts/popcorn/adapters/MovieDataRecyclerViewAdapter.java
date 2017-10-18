package com.phoenixroberts.popcorn.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.phoenixroberts.popcorn.R;
import com.phoenixroberts.popcorn.data.DTO;
import com.phoenixroberts.popcorn.data.DataService;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by rzmudzinski on 10/18/17.
 */

public class MovieDataRecyclerViewAdapter extends RecyclerView.Adapter<MovieDataRecyclerViewAdapter.MovieDataRecyclerViewHolder>  implements View.OnClickListener {
    private List<DTO.MoviesListItem> m_MoviesData;
    private static final int m_ItemLayoutId = R.layout.movie_grid_item;

    public MovieDataRecyclerViewAdapter(List<DTO.MoviesListItem> moviesData) {
        m_MoviesData=moviesData;
    }

    public List<DTO.MoviesListItem> getMoviesData() {
        return m_MoviesData;
    }

    @Override
    public void onClick(View view) {
        Object viewTag = view.getTag();
        if(viewTag!=null) {
            DataService.getInstance().fetchMovieData(Integer.parseInt(viewTag.toString()));
        }
    }

    @Override
    public MovieDataRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(m_ItemLayoutId,parent, false);
        ImageView movieImage = (ImageView)v.findViewById(R.id.movie_image);
        movieImage.setOnClickListener(this);
        return new MovieDataRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MovieDataRecyclerViewHolder holder, int position) {
        holder.bind(m_MoviesData.get(position));
    }

    @Override
    public int getItemCount() {
        return m_MoviesData.size();
    }

    class MovieDataRecyclerViewHolder extends RecyclerView.ViewHolder{
        ImageView m_MovieImage;
        TextView m_MovieTitle;
        public MovieDataRecyclerViewHolder(View v) {
            super(v);
            m_MovieImage = (ImageView)v.findViewById(R.id.movie_image);
            m_MovieTitle = (TextView)v.findViewById(R.id.movie_title);
        }
        public void bind(DTO.MoviesListItem item) {
            m_MovieTitle.setText(item.getTitle());
            m_MovieImage.setTag(item.getId().toString());
            String sUrlPath = DataService.getInstance().getMovieGridPosterPath(item.getId());
            loadImage(m_MovieImage, sUrlPath);
        }
        private void loadImage(ImageView imageView, String sUrlPath) {
            Uri uri = Uri.parse(sUrlPath);
            Picasso.with(imageView.getContext())
                    .load(uri).placeholder(R.drawable.popcorn).into(imageView);
        }
    }
}



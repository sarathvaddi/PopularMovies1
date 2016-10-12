package com.example.sarathreddyvaddhi.popularmovies.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sarathreddyvaddhi.popularmovies.model.MovieDetailsObject;
import com.example.sarathreddyvaddhi.popularmovies.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sarathreddyvaddhi on 10/5/16.
 */
public class DetailsFragment extends android.support.v4.app.Fragment {

    private static final String STRING = "/10";
    private ImageView moviePoster;
    private TextView releaseDate;
    private TextView voteAverage;
    private TextView overview;
    private TextView title;

    private static int position;
    private static final String IMAGE_URL = "http://image.tmdb.org/t/p/w185/";
    private static ArrayList<MovieDetailsObject> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.details_fragment, container, false);
        setScreen(view);
        return view;
    }

    private void setScreen(View view) {
        moviePoster = (ImageView) view.findViewById(R.id.movie_poster);
        releaseDate = (TextView) view.findViewById(R.id.release_date);
        voteAverage = (TextView) view.findViewById(R.id.vote_average);
        overview = (TextView) view.findViewById(R.id.overView);
        title = (TextView) view.findViewById(R.id.title);
    }

    public static DetailsFragment newInstance(int i, ArrayList<MovieDetailsObject> results) {

        Bundle args = new Bundle();

        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(args);
        list = results;
        position = i;
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        setValues();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    private void setValues() {
        if (list != null) {
            Picasso.with(getActivity()).load(IMAGE_URL + list.get(position).getBackdrop_path()).into(moviePoster);
            releaseDate.setText(list.get(position).getRelease_date());
            voteAverage.setText(list.get(position).getVote_average() + STRING);
            overview.setText(list.get(position).getOverview());
            title.setText(list.get(position).getTitle());
        }
    }
}

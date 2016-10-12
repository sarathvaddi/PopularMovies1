package com.example.sarathreddyvaddhi.popularmovies.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.sarathreddyvaddhi.popularmovies.R;
import com.example.sarathreddyvaddhi.popularmovies.model.MovieDetailsObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sarathreddyvaddhi on 10/2/16.
 */
public class GridAdapter extends BaseAdapter {

    private static final String POPULAR = "popular";
    private static final String TOP_RATED = "top_rated";
    private static final String API_KEY = "521682b7a2783caba6a8614d2eac634f";
    private static final String IMAGE_URL = "http://image.tmdb.org/t/p/w185/";

    private ArrayList<MovieDetailsObject> result;
    private Context context;

    public GridAdapter(ArrayList result, Context context) {
        this.result = result;
        this.context = context;
    }

    @Override
    public int getCount() {
        Log.d("TAG-Adapter",result.size()+"Results");
        return result.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.grid_view_layout, parent,false);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.image);

        Picasso.with(context).load(IMAGE_URL+result.get(position).getPoster_path()).into(imageView);
        return convertView;
    }
}

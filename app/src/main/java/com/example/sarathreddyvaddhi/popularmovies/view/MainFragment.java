package com.example.sarathreddyvaddhi.popularmovies.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.sarathreddyvaddhi.popularmovies.connectivity.ConnectionManager;
import com.example.sarathreddyvaddhi.popularmovies.model.MovieDetailsObject;
import com.example.sarathreddyvaddhi.popularmovies.R;
import com.example.sarathreddyvaddhi.popularmovies.model.Result;

import java.util.ArrayList;

/**
 * Created by sarathreddyvaddhi on 10/2/16.
 */
public class MainFragment extends android.support.v4.app.Fragment implements Result {

    private static final int POPULAR_ITEM = 1;
    private static final int TOP_RATED_ITEM = 2;

    private int mSelectedSortOrder = POPULAR_ITEM;

    private static final String POPULAR = "popular";
    private static final String TOP_RATED = "top_rated";
    private static final String API_KEY = "521682b7a2783caba6a8614d2eac634f";
    private static final String BASE_URL = "http://api.themoviedb.org/3/movie/";
    private GridView gridLayout;
    ConnectionManager cm;
    ArrayList<MovieDetailsObject> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        setHasOptionsMenu(true);
        setScreen(view);
        return view;
    }

    private void setScreen(View view) {
        gridLayout = (GridView) view.findViewById(R.id.grid_view);
        makeNetworkCall(POPULAR);


        gridLayout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                android.support.v4.app.FragmentManager fm = getFragmentManager();
                fm.beginTransaction().addToBackStack(DetailsFragment.class.getSimpleName())
                        .replace(R.id.container, DetailsFragment.newInstance(position, list))
                        .commit();

            }
        });
    }

    private void makeNetworkCall(String category) {
        ConnectionManager cm = new ConnectionManager();
        cm.setResultInterface(this);
        cm.execute(BASE_URL + category + "?api_key=" + API_KEY);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.popular:
                handleOptionMenuClicked(POPULAR_ITEM);
                break;
            case R.id.top_rated:
                handleOptionMenuClicked(TOP_RATED_ITEM);
                break;
            default:
                return false;
        }

        return false;
    }

    private void handleOptionMenuClicked(int menuItem) {
        mSelectedSortOrder = menuItem;
        switch (menuItem) {
            case POPULAR_ITEM:
                makeNetworkCall(POPULAR);
                break;
            case TOP_RATED_ITEM:
                makeNetworkCall(TOP_RATED);
                break;
            default:
        }
    }

    @Override
    public void getResult(ArrayList<MovieDetailsObject> results) {
        GridAdapter adapter = new GridAdapter(results, getActivity());
        gridLayout.setAdapter(adapter);
        list = results;
    }
}

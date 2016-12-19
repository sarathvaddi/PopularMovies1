package com.example.sarathreddyvaddhi.popularmovies.connectivity;

import android.util.Log;

import com.example.sarathreddyvaddhi.popularmovies.model.GetResultsSet;
import com.example.sarathreddyvaddhi.popularmovies.model.MovieDetailsObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarathreddyvaddhi on 10/2/16.
 */
public class JsonParser {
    private static final String TAG_results = "results";
    private static final String TAG_posterPath = "poster_path";
    private static final String TAG_overview = "overview";
    private static final String TAG_title = "title";
    private static final String TAG_releaseDate = "release_date";
    private static final String TAG_originalTitle = "original_title";
    private static final String TAG_backDropPath = "backdrop_path";
    private static final String TAG_voteAverage ="vote_average";
    private static final String TAG_id = "id";
    private static final String TAG = JsonParser.class.getSimpleName();


    public String posterPath;
    public String overview;
    public String title;
    public String releaseDate;
    public String original_title;
    public String backDropPath;
    public String voteAverage;
    public String id;


    ArrayList<GetResultsSet> feeds = new ArrayList<GetResultsSet>();
    GetResultsSet resultObject;


    public List<MovieDetailsObject> JsonParser(String response) throws JSONException {

        Log.i("TAG", "Entered into parser");


        JSONArray results;
        JSONObject res = new JSONObject(response);

        results = res.getJSONArray(TAG_results);

        try {
                resultObject = new GetResultsSet();
                resultObject.setResults(setResults(results));

            Log.i("TAG", "" + resultObject.getResults().size());
        } catch (Exception e) {

        }
        return setResults(results);
    }

    private List<MovieDetailsObject> setResults(JSONArray results) {

        List<MovieDetailsObject> list = new ArrayList<>();
        for (int j = 0; j < results.length(); j++) {
            list.add(convert(results, j));
        }
        return list;
    }

    private MovieDetailsObject convert(JSONArray results, int i) {

        try {
            JSONObject r = results.getJSONObject(i);

            posterPath = r.getString(TAG_posterPath);
            overview = r.getString(TAG_overview);
            title = r.getString(TAG_title);
            releaseDate = r.getString(TAG_releaseDate);
            original_title = r.getString(TAG_originalTitle);
            backDropPath = r.getString(TAG_backDropPath);
            voteAverage = r.getString(TAG_voteAverage);
            id = r.getString(TAG_id);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        MovieDetailsObject movieDetailsObject = new MovieDetailsObject(posterPath, null, overview,
                releaseDate, original_title, title, backDropPath,voteAverage,id);
        Log.d(TAG," posterPath "+posterPath);
        return movieDetailsObject;
    }


}

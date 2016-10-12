package com.example.sarathreddyvaddhi.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by sarathreddyvaddhi on 10/2/16.
 */
public class GetResultsSet  implements Parcelable{

    private List<MovieDetailsObject> results;

    protected GetResultsSet(Parcel in) {
        results = in.createTypedArrayList(MovieDetailsObject.CREATOR);
    }

    public static final Creator<GetResultsSet> CREATOR = new Creator<GetResultsSet>() {
        @Override
        public GetResultsSet createFromParcel(Parcel in) {
            return new GetResultsSet(in);
        }

        @Override
        public GetResultsSet[] newArray(int size) {
            return new GetResultsSet[size];
        }
    };

    public GetResultsSet() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(results);
    }

    public List<MovieDetailsObject> getResults() {
        return results;
    }

    public void setResults(List<MovieDetailsObject> results) {
        this.results = results;
    }
}

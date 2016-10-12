package com.example.sarathreddyvaddhi.popularmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sarathreddyvaddhi on 10/2/16.
 */
public class MovieDetailsObject implements Parcelable {

    private String poster_path;
    private String adult;
    private String overview;
    private String release_date;
    private String original_title;
    private String title;
    private String backdrop_path;
    private String vote_average;


    protected MovieDetailsObject(Parcel in) {
        poster_path = in.readString();
        adult = in.readString();
        overview = in.readString();
        release_date = in.readString();
        original_title = in.readString();
        title = in.readString();
        backdrop_path = in.readString();
        vote_average = in.readString();
    }

    public static final Creator<MovieDetailsObject> CREATOR = new Creator<MovieDetailsObject>() {
        @Override
        public MovieDetailsObject createFromParcel(Parcel in) {
            return new MovieDetailsObject(in);
        }

        @Override
        public MovieDetailsObject[] newArray(int size) {
            return new MovieDetailsObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public MovieDetailsObject(String poster_path, String adult, String overview,
                              String release_date, String original_title,
                              String title, String backdrop_path, String vote_average) {
        this.poster_path = poster_path;
        this.adult = adult;
        this.overview = overview;
        this.release_date = release_date;
        this.original_title = original_title;
        this.title = title;
        this.backdrop_path = backdrop_path;
        this.vote_average = vote_average;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(poster_path);
        dest.writeString(adult);
        dest.writeString(overview);
        dest.writeString(release_date);
        dest.writeString(original_title);
        dest.writeString(title);
        dest.writeString(backdrop_path);
        dest.writeString(vote_average);
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }
}

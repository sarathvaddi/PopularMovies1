package com.example.sarathreddyvaddhi.popularmovies.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sarathreddyvaddhi.popularmovies.model.db.MoviesContract.MovieEntry;
import com.example.sarathreddyvaddhi.popularmovies.model.db.MoviesContract.MovieTrailerEntry;

/**
 * Created by sarathreddyvaddhi on 12/17/16.
 */
public class MoviesDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    static final String DATABASE_NAME = "movie.db";

    public MoviesDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + MovieEntry.TABLE_NAME + " (" +
                MovieEntry._ID + " INTEGER PRIMARY KEY," +
                MovieEntry.COLUMN_FAVORITE + " REAL NOT NULL, " +
                MovieEntry.COLUMN_MOVIE_ID_KEY + " TEXT NOT NULL, " +
                MovieEntry.COLUMN_OVERVIEW + " TEXT NOT NULL, " +
                MovieEntry.COLUMN_RELEASE_DATE + " TEXT NOT NULL, " +
                MovieEntry.COLUMN_POSTER_PATH + " TEXT NOT NULL, " +
                MovieEntry.COLUMN_ORIGINAL_TITLE + " TEXT NOT NULL, " +
                MovieEntry.COLUMN_VOTE_COUNT + " INTEGER NOT NULL, " +
                MovieEntry.COLUMN_VOTE_AVERAGE + " REAL NOT NULL" +
                " );";

        final String SQL_CREATE_TRAILER_TABLE = "CREATE TABLE " + MovieTrailerEntry.TABLE_NAME + " (" +
                MovieTrailerEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                MovieTrailerEntry.COLUMN_MOVIE_NAME + " TEXT NOT NULL, " +
                MovieTrailerEntry.COLUMN_MOVIE_TRAILER_KEY + " TEXT NOT NULL, " +
                MovieTrailerEntry.COLUMN_MOVIE_ID_KEY + " TEXT NOT NULL " +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_MOVIE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_TRAILER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MovieEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MovieTrailerEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}

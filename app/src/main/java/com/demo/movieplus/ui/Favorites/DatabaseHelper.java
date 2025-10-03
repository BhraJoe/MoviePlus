// DatabaseHelper.java
package com.demo.movieplus.ui.Favorites;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "favoritor.db";
    private static final String TABLE_FAVORITES = "favorites";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_IMAGE = "image";
    private static final String COLUMN_URL = "url";
    private static final String COLUMN_VIDEO_URL = "videoUrl";
    private static final String COLUMN_DESCRIPTION = "description";
    Context context;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_FAVORITES_TABLE
                = "CREATE TABLE " + TABLE_FAVORITES + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_IMAGE + " TEXT,"
                + COLUMN_URL + " TEXT,"
                + COLUMN_VIDEO_URL + " TEXT,"
                + COLUMN_DESCRIPTION + " TEXT"
                + ")";

        db.execSQL(CREATE_FAVORITES_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITES);
        onCreate(db);
    }

    public void addFavorite(String movieName, String movieImageUrl, String movieUrl, String movieVideoUrl, String movieDescription) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, movieName);
        values.put(COLUMN_IMAGE, movieImageUrl);
        values.put(COLUMN_URL, movieUrl);
        values.put(COLUMN_VIDEO_URL, movieVideoUrl);
        values.put(COLUMN_DESCRIPTION, movieDescription);
        long newRowId =  db.insert(TABLE_FAVORITES, null, values);
//        Toast.makeText(this.context, "Added to favorites" + newRowId, Toast.LENGTH_SHORT).show();
        db.close();
    }


    public void removeFavorite(String itemID) {

        SQLiteDatabase db = this.getReadableDatabase();
        // Define 'where' part of query.
            String selection = COLUMN_NAME + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { itemID };
        // Issue SQL statement.
        int deletedRows = db.delete(TABLE_FAVORITES, selection, selectionArgs);


//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_FAVORITES, COLUMN_URL + " = ?", new String[]{url});
//        db.close();
    }

    public boolean isFavorite(String url) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_FAVORITES, null, COLUMN_URL + " = ?",
                new String[]{url}, null, null, null);
        boolean isFavorite = cursor.getCount() > 0;
        cursor.close();
        return isFavorite;
    }

    public List<Movie> getAllFavorites() {
        List<Movie> favorites = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_FAVORITES, null);

        if (cursor.moveToFirst()) {
            do {
                Movie movie = new Movie(
                        cursor.getString(1), // name
                        cursor.getString(2), // imageUrl
                        cursor.getString(3) , // videoUrl
                        cursor.getString(5) // description
                );

                Log.d( "check",cursor.getString(4));
                favorites.add(movie);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return favorites;
    }


}
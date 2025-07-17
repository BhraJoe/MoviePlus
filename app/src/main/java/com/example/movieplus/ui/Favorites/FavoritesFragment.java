package com.example.movieplus.ui.Favorites;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.movieplus.R;

import java.util.HashSet;
import java.util.Set;

public class FavoritesFragment extends Fragment {
    private static final String PREFS_NAME = "FavoritesPrefs";
    private static final String KEY_FAVORITES = "favorites";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false);
    }


    public static void addToFavorites(Context context, String videoId) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Set<String> favorites = prefs.getStringSet(KEY_FAVORITES, new HashSet<>());
        favorites.add(videoId);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putStringSet(KEY_FAVORITES, favorites);
        editor.apply();


    }

    public static void removeFromFavorites(Context context, String videoId) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Set<String> favorites = prefs.getStringSet(KEY_FAVORITES, new HashSet<>());
        favorites.remove(videoId);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putStringSet(KEY_FAVORITES, favorites);
        editor.apply();

    }
    public static boolean isFavorite(Context context, String videoId) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Set<String> favorites = prefs.getStringSet(KEY_FAVORITES, new HashSet<>());
        return favorites.contains(videoId);



    }







}
package com.example.movieplus.ui.Favorites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieplus.R;
import com.example.movieplus.webpages.YouTubeVideoActivity;


import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment {
    private RecyclerView recyclerView;
    private FavoritesAdapter adapter;
    private DatabaseHelper dbHelper;
    private List<Movie> favorites = new ArrayList<>();
    private TextView emptyStateText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);


        recyclerView = view.findViewById(R.id.favoritesRecyclerView);
        emptyStateText = view.findViewById(R.id.emptyStateText);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        adapter = new FavoritesAdapter(favorites, new FavoritesAdapter.OnFavoriteClickListener() {
            @Override
            public void onFavoriteClick(Movie movie) {

                // Handle favorite click
                Log.d("FAVORITE_CLICK", "Favorite clicked for movie: " + movie.getName());
                dbHelper.removeFavorite(movie.getName());
                loadFavorites();
            }
        });
        recyclerView.setAdapter(adapter);
        dbHelper = new DatabaseHelper(getContext());

        return view;
    }

    private void loadFavorites() {
        favorites.clear();
        favorites.addAll(dbHelper.getAllFavorites());
        adapter.notifyDataSetChanged();

        // Check if favorites is empty and update UI accordingly
        if (favorites.isEmpty()) {
            // Show empty state message and hide recyclerView
            if (emptyStateText != null) {
                emptyStateText.setVisibility(View.VISIBLE);
            }
            if (recyclerView != null) {
                recyclerView.setVisibility(View.GONE);
            }
            Toast.makeText(getContext(), "No favorites found", Toast.LENGTH_SHORT).show();
            Log.d("FAVORITES", "No favorites found");
        } else {
            // Show recyclerView and hide empty state message
            if (emptyStateText != null) {
                emptyStateText.setVisibility(View.GONE);
            }
            if (recyclerView != null) {
                recyclerView.setVisibility(View.VISIBLE);
            }



            // Log for debugging
        Log.d("FAVORITES", "Loaded " + favorites.size() + " favorites");
        for (Movie movie : favorites) {
            Log.d( "FAVORITES", "Movie: " + movie.getName() );

            }
        }
    }

//    @Override
//    public void onDestroyView() {
//        dbHelper.close();
//        super.onDestroyView();
//    }

    @Override
    public void onResume() {
        super.onResume();
        loadFavorites();
import com.example.movieplus.ui.movies.placeholder.PlaceholderContent;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        // Implement logic to add video to favorites
        // You can use SharedPreferences or any other storage mechanism
        // For example, you can use a Set to store favorite video IDs
        // Here's an example using SharedPreferences:

        Set<String> favorites = getFavorites(context);
        favorites.add(videoId);
        saveFavorites(context, favorites);
    }

    public static void removeFromFavorites(Context context, String videoId) {
        // Implement logic to remove video from favorites
        // You can use SharedPreferences or any other storage mechanism

        Set<String> favorites = getFavorites(context);
        favorites.remove(videoId);
        saveFavorites(context, favorites);
    }

    public static boolean isFavorite(Context context, String videoId) {
        return getFavorites(context).contains(videoId);
    }

    private static Set<String> getFavorites(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return prefs.getStringSet(KEY_FAVORITES, new HashSet<>());
    }

    private static void saveFavorites(Context context, Set<String> favorites) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        prefs.edit().putStringSet(KEY_FAVORITES, favorites).apply();

    }

    public static void refreshFavorites(Context context) {
        if (instance != null) {
            instance.loadFavorites();
        }

    }

    private void loadFavorites() {
        Set<String> favorites = getFavorites(getContext());
        // Update UI with favorites


    }

    private static FavoritesFragment instance;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
    }
}
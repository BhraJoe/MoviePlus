package com.demo.movieplus.ui.Favorites;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.movieplus.R;


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
    }
}
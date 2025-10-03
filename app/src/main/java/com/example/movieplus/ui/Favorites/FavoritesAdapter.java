package com.example.movieplus.ui.Favorites;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.movieplus.DetailPage;
import com.example.movieplus.R;
import com.example.movieplus.ui.gallery.GalleryFragment;
import com.example.movieplus.ui.home.HomeFragment;
import com.example.movieplus.webpages.YouTubeVideoActivity;

import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {
    private List<Movie> favorites;
    private OnFavoriteClickListener listener;

    public interface OnFavoriteClickListener {
        void onFavoriteClick(Movie movie);
    }

    public FavoritesAdapter(List<Movie> favorites, OnFavoriteClickListener listener) {
        this.favorites = favorites;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate( R.layout.fragment_favorites_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = favorites.get(position);


        holder.imageView.setImageResource( Integer.parseInt( movie.getImageUrl() ) );
        holder.nameTextView.setText(movie.getName());
//        holder.descTextView.setText(movie.getDescription());  // Set description
        holder.deleteButton.setOnClickListener(v -> {

            try {
                DatabaseHelper dbHelper = new DatabaseHelper(v.getContext());
                dbHelper.removeFavorite(movie.getName());
                favorites.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, favorites.size());
                Toast.makeText( v.getContext(), "Removed from favorites", Toast.LENGTH_SHORT ).show();
                Intent intent = new Intent(v.getContext(), HomeFragment.class);
                intent.putExtra("name", movie.getName());
                v.getContext().startActivity(intent);
            } catch (Exception e) {
//                Intent intent = new Intent(v.getContext(), GalleryFragment.class);
//                v.getContext().startActivity(intent);
//                Toast.makeText( v.getContext(), e.toString(), Toast.LENGTH_SHORT ).show();
            }

//            Toast.makeText( v.getContext(), movie.getName(), Toast.LENGTH_SHORT ).show();
                });
        holder.itemView.setOnClickListener(v -> {
//
//            Toast.makeText( v.getContext(), movie.getDesc(), Toast.LENGTH_SHORT ).show();
            Intent intent = new Intent(v.getContext(), DetailPage.class);
            intent.putExtra("Product", new String[]{
                    movie.getName(),
                    movie.getDesc(),
                    "", // Title if needed
                    movie.getImageUrl(),
                    movie.getVideoUrl()
            });
            v.getContext().startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return favorites.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView descriptionTextView;
        Button deleteButton;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.favoriteImage);
            nameTextView = itemView.findViewById(R.id.favoriteName);
            deleteButton = itemView.findViewById(R.id.delete);
//            descriptionTextView = itemView.findViewById(R.id.favoriteDescription);

        }
    }
}
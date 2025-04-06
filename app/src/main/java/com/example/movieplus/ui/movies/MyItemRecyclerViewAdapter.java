package com.example.movieplus.ui.movies;

import static android.content.Intent.*;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieplus.R;
import com.example.movieplus.User.SelectedHomeItem;
import com.example.movieplus.ui.movies.placeholder.PlaceholderContent;

import com.example.movieplus.databinding.FragmentMovieBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderContent}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderContent> mValues;
    SelectedHomeItem selectedHomeItem;


    public MyItemRecyclerViewAdapter(List<PlaceholderContent> mValues, SelectedHomeItem selectedHomeItem) {
        this.mValues = mValues;
        this.selectedHomeItem = selectedHomeItem;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));


    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        PlaceholderContent content = mValues.get(position);
        holder.imageView.setImageResource(content.getImage_url());
        holder.textView.setText(content.getName());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedHomeItem.OnItemSelected(content);

            }
        });

//        WebView webView = holder.itemView.findViewById(R.id.webView);
//        content.setWebView(webView);
//        content.getUrl("WWW.YOUTUBE.COM");

    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;


        public ViewHolder(FragmentMovieBinding binding) {
            super(binding.getRoot());
            imageView = binding.customImage;
            textView = binding.customName;



        }

//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
//        }
//    }
    }
}
package com.example.movieplus.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieplus.DetailPage;
import com.example.movieplus.R;
import com.example.movieplus.User.SelectedHomeItem;
import com.example.movieplus.databinding.FragmentMovieListBinding;

import com.example.movieplus.ui.movies.MovieFragment;
import com.example.movieplus.ui.movies.MyItemRecyclerViewAdapter;
import com.example.movieplus.ui.movies.placeholder.PlaceholderContent;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment implements SelectedHomeItem {

    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 3;
    ArrayList<PlaceholderContent> searchHolder,searchHolder2,arrayList, arrayList2,arrayList3;
    SearchView searchView;
    FragmentMovieListBinding binding;
    RecyclerView recyclerView,recyclerView2,recyclerView3;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SlideshowFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MovieFragment newInstance(int columnCount) {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMovieListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = binding.CustomRecycler;
        recyclerView2 = binding.CustomRecycler2;
        recyclerView3 = binding.CustomRecycler3;
//        searchView = binding.searchView;

        // Set the adapter
        arrayList = new ArrayList<>();
        arrayList.add(new PlaceholderContent("Parish","Description","Title", R.drawable.image5,"https://www.youtube.com/"));
        arrayList.add(new PlaceholderContent("They Turned Us Into Killers","Description","Title",R.drawable.image25,"https://www.youtube.com/"));
        arrayList.add(new PlaceholderContent("Dead Boy Detectives","Description","Title",R.drawable.image6,"https://www.youtube.com/"));
        arrayList.add(new PlaceholderContent("Fallout","Description","Title",R.drawable.image11,"https://www.youtube.com/"));
        arrayList.add(new PlaceholderContent("Chief Of Station","Description","Title",R.drawable.image14,"https://www.youtube.com/"));
        arrayList.add(new PlaceholderContent("Parasyte: The Grey","Description","Title",R.drawable.image16,"https://www.youtube.com/"));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), mColumnCount));
        recyclerView.setAdapter(new MyItemRecyclerViewAdapter(arrayList,this));
//        SearchView();


        arrayList2 = new ArrayList<>();
        arrayList2.add(new PlaceholderContent("Kill Craft","Description","Title", R.drawable.image69,"https://www.youtube.com/"));
        arrayList2.add(new PlaceholderContent("Mad Max: Fury Road","Description","Title",R.drawable.image18,"https://www.youtube.com/"));
        arrayList2.add(new PlaceholderContent("Fiesta En La Madrguera","Description","Title",R.drawable.image19,"https://www.youtube.com/"));
        arrayList2.add(new PlaceholderContent("Rebel Moon Part Two: The Scargiver","Description","Title",R.drawable.image20,"https://www.youtube.com/"));
        arrayList2.add(new PlaceholderContent("Blood For Dust","Description","Title",R.drawable.image21,"https://www.youtube.com/"));
        arrayList2.add(new PlaceholderContent("Damaged","Description","Title",R.drawable.image22,"https://www.youtube.com/"));
        recyclerView2.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
        recyclerView2.setAdapter(new MyItemRecyclerViewAdapter(arrayList2,this));
//        SearchView();



        arrayList3 = new ArrayList<>();
        arrayList2.add(new PlaceholderContent("Land Of Bad","Description","Title",R.drawable.image27,"https://www.youtube.com/"));
        arrayList2.add(new PlaceholderContent("Madam Web","Description","Title", R.drawable.image28,"https://www.youtube.com/"));
        arrayList3.add(new PlaceholderContent("Life After Fighting","Description","Title",R.drawable.image70,"https://www.youtube.com/"));
        arrayList3.add(new PlaceholderContent("Todos los nombres de Dios","Description","Title",R.drawable.image30,"https://www.youtube.com/"));
        arrayList3.add(new PlaceholderContent("Logan","Description","Title",R.drawable.image52,"https://www.youtube.com/"));
        arrayList3.add(new PlaceholderContent("Humane","Description","Title",R.drawable.image53,"https://www.youtube.com/"));
        recyclerView3.setLayoutManager(new GridLayoutManager(getActivity(), 1, GridLayoutManager.HORIZONTAL, false));
        recyclerView3.setAdapter(new MyItemRecyclerViewAdapter(arrayList2,this));
//        SearchView();


        return root;
    }



    private void SearchView(){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                FilterLister(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                FilterLister(newText);
                return false;
            }
        });
    }

    private void FilterLister(String query) {
        searchHolder = new ArrayList<>();
        for (PlaceholderContent object : arrayList){
            if (object.getName().toLowerCase().contains(query.toLowerCase())){
                searchHolder.add(object);
            }
        }

        for (PlaceholderContent object : arrayList2){
            if (object.getName().toLowerCase().contains(query.toLowerCase())){
                searchHolder2.add(object);
            }
        }

        if (searchHolder.isEmpty()){
            Toast.makeText(getActivity(), "No Data Found", Toast.LENGTH_SHORT).show();
        }else {
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(searchHolder,this));
            recyclerView2.setAdapter(new MyItemRecyclerViewAdapter(searchHolder2,this));

        }
    }


    public void OnItemSelected(PlaceholderContent customModel) {

        String[] Product = {customModel.getName(),customModel.getDesc(),customModel.getTitle(),String.valueOf(customModel.getImage_url())};
        Intent intent = new Intent(getActivity(), DetailPage.class);
        intent.putExtra("Product", Product);
        startActivity(intent);



    }
}
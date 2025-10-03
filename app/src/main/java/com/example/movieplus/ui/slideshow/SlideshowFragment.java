package com.example.movieplus.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieplus.R;
import com.example.movieplus.User.SelectedHomeItem;
import com.example.movieplus.databinding.FragmentGalleryBinding;

import com.example.movieplus.ui.movies.MyItemRecyclerViewAdapter;
import com.example.movieplus.ui.movies.placeholder.PlaceholderContent;
import com.example.movieplus.webpages.YouTubeVideoActivity;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment implements SelectedHomeItem {

    FragmentGalleryBinding binding;
    RecyclerView recyclerView;
    MyItemRecyclerViewAdapter adapter1,adapter2;
    SearchView searchView;
    ArrayList<PlaceholderContent> arrayList,arrayList2;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        searchView = binding.searchViewList;
        recyclerView = binding.recyclerViewList;
        arrayList = new ArrayList<>();
        arrayList.add(new PlaceholderContent("LATTE & THE MAGIC WATERSTONE"," Follows the journey of a young hedgehog who wants to save the forest and its inhabitants from a horrible drought by " +
                "reclaim a magical waterstone from the bear king.","Title",R.drawable.image96,"https://www.youtube.com/embed/JhqFfNMA9U4?si=sYs7duaqvSA99fFU"));
        arrayList.add(new PlaceholderContent("THE CROODS","After their cave is destroyed, a caveman family must trek through an unfamiliar fantastical " +
                "world with the help of an inventive boy.","Title",R.drawable.image100,"https://www.youtube.com/embed/4fVCKy69zUY?si=EQikahF4qTIB-tZY"));
        arrayList.add(new PlaceholderContent("The Swan Princess: A Royal Wedding","Princess Odette and Prince Derek are going to a wedding at Princess Mei and her beloved Chen. But evil forces are at stake" +
                " and the wedding plans are tarnished and true love has difficult conditions.","Title",R.drawable.image102,"https://www.youtube.com/embed/45O6Di45nsQ?si=8DTHIQLwf6MOJMKL"));
        arrayList.add(new PlaceholderContent("BRAVE","Determined to make her own path in life, Princess Merida (Kelly Macdonald) defies a custom that brings chaos to her kingdom. Granted one wish, Merida must rely on her bravery" +
                " and her archery skills to undo a beastly curse.","Title",R.drawable.image103,"https://www.youtube.com/embed/TEHWDA_6e3M?si=jNUnkUHF4JNZ6WSQ"));



        arrayList.add(new PlaceholderContent("THE SECRET LIFE OF PETS"," The quiet life of a terrier named Max is upended when his owner takes in Duke, a stray whom " +
                "Max instantly dislikes.","Title",R.drawable.image105,"https://www.youtube.com/embed/i-80SGWfEjM?si=NMAy8tNzsEZ2Lv19"));
        arrayList.add(new PlaceholderContent("THE SECRET LIFE OF PETS 2","Continuing the story of Max and his pet friends, following their secret lives after their owners leave them for work" +
                " or school each day.","Title",R.drawable.image106,"https://www.youtube.com/embed/mYocfuqu2A8?si=oV7rvvAWPEaTWxbB"));
        arrayList.add(new PlaceholderContent("TANGLED BEFORE EVER AFTER"," As Rapunzel prepares for her coronation as Princess of Corona, one unforgettable night" +
                " will change her hair again!","Title",R.drawable.image108,"https://www.youtube.com/embed/G44HxQpAcI4?si=WCeQX3Irkx-gKzif"));
        arrayList.add(new PlaceholderContent("THE ACADEMY OF MAGIC","Aura is gifted with magical abilities; she and her friends have many exciting adventures at the academy, but soon Aura learns that the school hatches" +
                " many dark secrets that she must uncover. Will she be able to unveil the truth?","Title", R.drawable.image109,"https://www.youtube.com/embed/u5ZLdSG_99Q?si=KSIwdVP1f2nvSuxN"));
        arrayList.add(new PlaceholderContent("MOANA","In Ancient Polynesia, when a terrible curse incurred by the Demigod Maui reaches Moana's island, she answers the Ocean's call to " +
                "seek out the Demigod to set things right.","Title",R.drawable.image110,"https://www.youtube.com/embed/LKFuXETZUsI?si=rE5KaWNoPw19SaT2"));
        arrayList.add(new PlaceholderContent("MADAGASCAR 2","The Madagascar animals fly back to New York City, but crash-land on an African nature reserve, where they meet others of their own kind, " +
                "and Alex especially discovers his royal heritage as prince of a lion pride.","Title",R.drawable.image111,"https://www.youtube.com/embed/hLVjIhPYq7s?si=Iz8uNwKLOJO-G3bO"));
        arrayList.add(new PlaceholderContent("PENGUINS OF MADAGASCAR","Skipper, Kowalski, Rico and Private join forces with undercover organization The North Wind to stop the villainous " +
                "Dr. Octavius Brine from destroying the world as we know it.","Title",R.drawable.image113,"https://www.youtube.com/embed/4jsFpmFWOSs?si=08iQntDV8fToBhb6"));
        arrayList.add(new PlaceholderContent("OVER THE MOON"," In this animated musical, a girl builds a rocket ship and " +
                "blasts off, hoping to meet a mythical moon goddess.","Title",R.drawable.image114,"https://www.youtube.com/embed/26DIABx44Tw?si=8qUxZe4Gk06-4NE8"));
        arrayList.add(new PlaceholderContent(" ZOOTOPIA","In a city of anthropomorphic animals, a rookie bunny cop and a cynical con artist fox must work" +
                " together to uncover a conspiracy.","Title",R.drawable.image115,"https://www.youtube.com/embed/jWM0ct-OLsM?si=elYTaeEFETWOt6_1"));
        arrayList.add(new PlaceholderContent(" INSIDE OUT"," After young Riley is uprooted from her Midwest life and moved to " +
                "San Francisco, her emotions - Joy, Fear, Anger, Disgust and Sadness - conflict on how best " +
                "to navigate a new city, house, and school.","Title",R.drawable.image116,"https://www.youtube.com/embed/yRUAzGQ3nSY?si=AjkRgIGgx505EOnc"));
        arrayList.add(new PlaceholderContent("Coco","Aspiring musician Miguel, confronted with his family's ancestral ban on music, enters the Land of the Dead to find his great-great-grandfather," +
                " a legendary singer.","Title", R.drawable.image117,"https://www.youtube.com/embed/Rvr68u6k5sI?si=N45mnjBKhUfXEVGW"));
        arrayList.add(new PlaceholderContent("Fireheart","Sixteen-year-old Georgia Nolan dreams of being the world's first-ever female firefighter." +
                " When a mysterious arsonist starts burning down Broadway, New York's firemen begin vanishing. " +
                "Georgia's father, Shawn, is called out of retireme…","Title",R.drawable.image118,"https://www.youtube.com/embed/g1-7ov3x53o?si=G-OpZSu9kOpNKiIi"));
        arrayList.add(new PlaceholderContent(" HOW TO TRAIN YOUR DRAGON"," A hapless young Viking who aspires to hunt dragons becomes the unlikely friend of a young dragon himself, and learns there may be more to the" +
                " creatures than he assumed.","Title",R.drawable.image120,"https://www.youtube.com/embed/22w7z_lT6YM?si=rxLdLY3-oAASaVzC"));
        arrayList.add(new PlaceholderContent("TOY STORY"," A cowboy doll is profoundly threatened and jealous when a new spaceman figure supplants him " +
                "as top toy in a boy's room..","Title",R.drawable.image122,"https://www.youtube.com/embed/v-PjgYDrg70?si=XN45scjKuckLmyQ_"));





        // Set the adapter
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        adapter1 = new MyItemRecyclerViewAdapter(arrayList,this);
        recyclerView.setAdapter(adapter1);
        SearchView();
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
        arrayList2 = new ArrayList<>();
        for (PlaceholderContent object : arrayList){
            if (object.getName().toLowerCase().contains(query.toLowerCase())){
                arrayList2.add(object);
            }
        }

        if (arrayList2.isEmpty()){
//            Toast.makeText(getActivity(), "No Data Found", Toast.LENGTH_SHORT).show();
        }else {
            adapter2 = new MyItemRecyclerViewAdapter(arrayList2,this);
            recyclerView.setAdapter(adapter2);
        }
    }



    @Override
    public void OnItemSelected(PlaceholderContent customModel) {


//        Toast.makeText(getActivity(), customModel.getName(), Toast.LENGTH_SHORT).show();
        String[] Product = {customModel.getName(),customModel.getDesc(),customModel.getTitle(),String.valueOf(customModel.getImage_url()),customModel.getUrl()};
        Intent intent = new Intent(getActivity(), YouTubeVideoActivity.class);
        intent.putExtra("Product", Product);
        startActivity(intent);

    }

}
package com.example.movieplus.ui.movies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movieplus.DetailPage;
import com.example.movieplus.R;
import com.example.movieplus.User.SelectedHomeItem;
import com.example.movieplus.databinding.FragmentMovieListBinding;
import com.example.movieplus.ui.movies.placeholder.PlaceholderContent;
import com.example.movieplus.webpages.YouTubeVideoActivity;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class MovieFragment extends Fragment implements SelectedHomeItem {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 3;
    ArrayList<PlaceholderContent> searchHolder,searchHolder2,arrayList, arrayList2,arrayList3;
//    SearchView searchView;
    
    
    FragmentMovieListBinding  binding;
    RecyclerView recyclerView,recyclerView2,recyclerView3;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MovieFragment() {
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
        arrayList.add(new PlaceholderContent("See","Jason Momoa stars as Baba Voss, the father of twins" +
                " born centuries  later with the mythic ability to see—who" +
                " must protect his tribe  against a powerful yet desperate" +
                " queen who believes it’s witchcraft  and wants them" +
                " destroyed. Alfre Woodard also stars as Paris,  Baba Voss’" +
                " spiritual leader.","Title", R.drawable.image4,"https://www.youtube.com/embed/7Rg0y7NT1gU?si=r4tjHsOz0PeXETJI"));
        arrayList.add(new PlaceholderContent("Beacon 23","Beacon 23 takes place in the farthest reaches of" +
                " the Milky Way and follows Aster (Lena Headey), a" +
                " government agent, and  Halan (Stephan James), a stoic" +
                " ex-military man, whose fates become entangled after" +
                " they find themselves trapped together inside one of" +
                " many Beacons that serve as a lighthouse for intergalactic" +
                " travelers. Every Beacon is run by one highly trained" +
                " human and a specialized Artificial Intelligence. Aster" +
                " mysteriously finds her way to the lonely Beacon-keeper" +
                " Halan, and a tense battle of wills unfolds. Halan begins" +
                " to question whether Aster is friend or foe, as her ability" +
                " to disguise her agenda and motives could make her a" +
                " formidable opponent.","Title",R.drawable.image7,"https://www.youtube.com/embed/zQuy5yoWJ7o?si=GnF0Wt6uqkb5sMMQ"));
        arrayList.add(new PlaceholderContent("Game Of Thrones","It’s time to return to Westeros.","Title",R.drawable.image9,"https://www.youtube.com/embed/KPLWWIOCOOQ?si=c_CR64iqXZB_DVu6"));
        arrayList.add(new PlaceholderContent("The Blacklist","Raymond Reddington (James Spader), one of" +
                " the FBI’s most wanted men,goes to the FBI H.Q. in Washington to turn himself in" +
                " and asks to speak to Elizabeth Keen (Megan Boone). ","Title",R.drawable.image10,"https://www.youtube.com/embed/JGBIimq1I3A?si=hHKOym5UDToT2FtI"));
        arrayList.add(new PlaceholderContent("Into The Badlands","","Title",R.drawable.image12,"https://www.youtube.com/embed/5KyHy4KRvIc?si=xLvpgxgSSFKi4UKv"));
        arrayList.add(new PlaceholderContent("Breaking Bad","Breaking Bad is easily one of my all" +
                " time favorite shows and you're gonna see a lot of BB " +
                "videos from me.","Title",R.drawable.image13,"https://www.youtube.com/embed/Pev38s3xPgM?si=02oaQazZTFbejjz"));
        arrayList.add(new PlaceholderContent("House Of The Dragon","","Title", R.drawable.image15,"https://www.youtube.com/embed/gnxB9xZByyQ?si=s-QgLkQd91tF2d9h"));
        arrayList.add(new PlaceholderContent("Vikings Valhalla","","Title",R.drawable.image85,"https://www.youtube.com/embed/Yi4YnwFT7Gk?si=jUeaQQnB3iF-HO90"));

        arrayList.add(new PlaceholderContent("Sistas","","Title",R.drawable.image86,"https://www.youtube.com/embed/cgnf6fXAuPw?si=z3o4Pg9pbDFdTk45"));
        arrayList.add(new PlaceholderContent("Supacell","","Title",R.drawable.image91,"https://www.youtube.com/embed/Frmk94Etedo?si=ow-hA_qSixZON4Gs"));

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), mColumnCount));
        recyclerView.setAdapter(new MyItemRecyclerViewAdapter(arrayList,this));

//        SearchView();


        arrayList2 = new ArrayList<>();
        arrayList2.add(new PlaceholderContent("Parish"," In Parish, Esposito stars as Gracian" +
                " “Gray” Parish, a family man and proud owner of a luxury car service in New Orleans. After" +
                " his son is violently murdered and his business collapses, an encounter with an old friend" +
                " from his days as a wheelman resurfaces old habits,sending Gray on a high-stakes collision" +
                " course with a violent criminal syndicate.","Title", R.drawable.image5,"https://www.youtube.com/embed/t3Cr1LTUwHU?si=PWu2yhwNOwVwh"));
        arrayList2.add(new PlaceholderContent("They Turned Us Into Killers"," A girl named Karma" +
                " is drugged and assaulted by her boyfriend,BJ, which leads to her tragically committing" +
                " suicide. Prior to this devastating event, she writes a letter to her best friend, Star," +
                "detailing the horrific events that unfolded that fateful night.Determined to seek revenge" +
                " against those responsible, Star then hunts down BJ and his brothers, and begins to torture" +
                " them one by one, while reading to them Karma's suicide letter, before <br> taking each of " +
                " their lives.","Title",R.drawable.image25,"https://www.youtube.com/embed/-1aklBXOooY?si=4QrqjtRBVWS8J2c4"));
        arrayList2.add(new PlaceholderContent("Dead Boy Detectives"," Edwin and Charles are best" +
                " friends, ghosts… and the best detectives on the Mortal plane. They will do anything to stick" +
                " together – including escaping evil witches, Hell and Death herself.With the help of a" +
                " clairvoyant named Crystal and her friend Niko,they are able to crack some of the mortal" +
                " realm’s most mystifying paranormal cases.","Title",R.drawable.image6,"https://www.youtube.com/embed/hwJmZ2Ekfbc?si=jXhYmYaCZo7vmxZO"));
        arrayList2.add(new PlaceholderContent("Fallout"," Based on one of the greatest video" +
                " game series of all time, Fallout is the story of haves and have-nots in a world in which" +
                " there’s almost nothing left to have.200 years after the apocalypse, the gentle denizens" +
                " of luxury fallout shelters are forced to return to the irradiated hellscape their ancestors" +
                " left behind — and are shocked to discover an incredibly complex,gleefully weird and highly" +
                " violent universe waiting for them. From executive producers Jonathan Nolan and Lisa Joy," +
                " the creators of Westworld, starring Ella Purnell, Aaron Moten, Walton  Goggins and more." +
                " All episodes arrive April 11 on Prime Video.","Title",R.drawable.image11,"https://www.youtube.com/embed/V-mugKDQDlg?si=_DW1OJVqkxUJkwuX"));
        arrayList2.add(new PlaceholderContent("Chief Of Station","After learning the untimely death" +
                " of his wife was not accidental,a former CIA Station Chief (Aaron Eckhart) is forced back" +
                " into the espionage underworld, teaming up with an adversary to unravel conspiracy that" +
                " challenges everything he thought he knew.","Title",R.drawable.image14,"https://www.youtube.com/embed/Krsu0mazuZ4?si=bd2N_PSojO5sjnwC"));
        arrayList2.add(new PlaceholderContent("Parasyte: The Grey","When unidentified parasites" +
                " violently take over human hosts and gain power,humanity must rise to combat the growing" +
                " threat","Title",R.drawable.image16,"https://www.youtube.com/embed/maIGHqJB6aQ?si=TqNoWkSIOZLJzTkZ"));
        arrayList2.add(new PlaceholderContent("Kill Craft","Marina is a straight 'A' student " +
                " living with her father, who is a professional hitman, and her mother who is suffering with" +
                " a disability. Marina’s life quickly turns into chaos when her father is killed on a mission" +
                " leaving her to take over the family business and be the sole caregiver for he" +
                "r mother.","Title", R.drawable.image69,"https://www.youtube.com/embed/rYhIgYPoqBU?si=VZG84YmukNtSwlAV"));
        arrayList2.add(new PlaceholderContent("Mad Max: Fury Road","The world goes mad May" +
                " 2015.","Title",R.drawable.image18,"https://www.youtube.com/embed/hEJnMQG9ev8?si=69iaRYiWL5L4EEs"));
        arrayList2.add(new PlaceholderContent("Fiesta En La Madrguera","","Title",R.drawable.image19,""));
        arrayList2.add(new PlaceholderContent("Rebel Moon Part Two: The Scargiver","","Title",R.drawable.image20,"https://www.youtube.com/embed/UEJuNHOd8Dw?si=GxgsWVVw41EChAeH"));


        recyclerView2.setLayoutManager(new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false));
        recyclerView2.setAdapter(new MyItemRecyclerViewAdapter(arrayList2,this));
//        SearchView();



        arrayList3 = new ArrayList<>();
        arrayList3.add(new PlaceholderContent("Blood For Dust"," Cliff (Scoot McNairy), a" +
                " former salesman with a checkered past,is pulled back into a life of crime after losing" +
                " his job. Desperate to keep his family afloat, he's lured by his old colleague, Ricky" +
                " (Kit Harington), into trafficking drugs and guns for a cartel. As Cliff delves deeper," +
                " his once straight-laced life turns into a high-stakes game of survival in this gripping" +
                " thriller hailed as Breaking Bad meets Fargo(Variety).Also starring Josh Lucas and Stephen" +
                " Dorff.","Title",R.drawable.image21,"https://www.youtube.com/embed/VRrrTBcuPF8?si=ph2jzt3-sMePfXl7"));
        arrayList3.add(new PlaceholderContent("Damaged","","Title",R.drawable.image22,"https://www.youtube.com/embed/Sg8NuJL5P_8?si=jxdykazp_pCLP4F6"));
        arrayList3.add(new PlaceholderContent("Breathe","Breathe is a heart pounding thriller" +
                " set in the future.After Earth is left uninhabitable due to lack of oxygen," +
                " a mother Maya(Jennifer Hudson) and her daughter Zora (Quvenzhané Wallis)are" +
                " forced to live underground, with short trips to the surface only made possible" +
                " by a coveted state of the art oxygen suit made by Maya’s husband, Darius," +
                " whom she presumes to be dead. When a mysterious couple arrives claiming to" +
                " know Darius and his fate Maya tentatively agrees to let them into their" +
                " bunker but these visitors are not who they claim to be ensuing in mother" +
                " and daughter fighting for survival.","Title",R.drawable.image23,"https://www.youtube.com/embed/chaHsowROfQ?si=sIVvd6ay8GqMa3zN"));
        arrayList3.add(new PlaceholderContent("Land Of Bad"," When a Delta Force team is ambushed" +
                " in enemy territory,a rookie officer (Liam Hemsworth) refuses to abandon them.Their only" +
                " hope lies with an Air Force drone pilot (Russell Crowe) as the eyes in the sky during a" +
                " brutal 48-hour battle for survival. ","Title",R.drawable.image27,"https://www.youtube.com/embed/yTFazxfrXVw?si=nL53qwNsIM-CDAxO"));
        arrayList3.add(new PlaceholderContent("Madam Web"," In a switch from the typical genre," +
                " Madame Web tells the standalone origin story of one of Marvel publishing's most enigmatic" +
                " heroines.The suspense-driven thriller stars Dakota Johnson as Cassandra Webb,a paramedic" +
                " in Manhattan who develops the power to see the future… and realizes she can use that insight" +
                " to change it. Forced to confront revelations about her past, she forges a relationship with" +
                " three young women bound for powerful destinies...if they can all survive a" +
                " deadly present.","Title", R.drawable.image28,"https://www.youtube.com/embed/s_76M4c4LTo?si=x8DINBx3Bk0jZqN4"));
        arrayList3.add(new PlaceholderContent("Life After Fighting","First movie trailer for" +
                " Life After Fighting starring Bren Foster.","Title",R.drawable.image70,"https://www.youtube.com/embed/iykZmLa5e34?si=8c885gBH8e0wiSyx"));
        arrayList3.add(new PlaceholderContent("Todos los nombres de Dios","Tras un atentado," +
                " Santi es tomado como rehén por Hamza,el  único terrorista superviviente." +
                " Un giro inesperado intercambia los papeles y Santi se convierte en una" +
                " bomba humana  caminando por la Gran Vía de Madrid llevando un chaleco" +
                " cargado con explosivos.Los servicios de inteligencia,emergencia e incluso" +
                " los medios de comunicación, unirán fuerzas para salvarle la vida" +
                " en un impresionante despliegue con consecuencias inesperadas.","Title",R.drawable.image30,"https://www.youtube.com/embed/NoEd8WDFcZE?si=C15uPKoQ_oyjplr8"));
        arrayList3.add(new PlaceholderContent("Logan"," In the near future," +
                " a weary Logan cares for an ailing Professor X in a hideout on the Mexican border." +
                " But Logan's attempts to hide from the world and his legacy are up-ended when a" +
                " young mutant arrives, being pursued by dark forces.","Title",R.drawable.image52,"https://www.youtube.com/embed/RH3OxVFvTeg?si=2T-3oqyFZX__7FrE"));
        arrayList3.add(new PlaceholderContent("Humane","","Title",R.drawable.image53,"https://www.youtube.com"));
        arrayList3.add(new PlaceholderContent("6 Hours Away"," An Ex-Marine must assassinate the" +
                " six rivals of the Cartel leader who kidnapped his wife, or never" +
                " see her again.","Title",R.drawable.image54,"https://www.youtube.com/embed/Z9rcVX8GZww?si=dgMqz_8YeFG9tWpK"));
        recyclerView3.setLayoutManager(new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false));
        recyclerView3.setAdapter(new MyItemRecyclerViewAdapter(arrayList3,this));

//        SearchView();


        return root;
    }



//    private void SearchView(){
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                FilterLister(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                FilterLister(newText);
//                return false;
//            }
//        });
//    }
//
//    private void FilterLister(String query) {
//        searchHolder = new ArrayList<>();
//        for (PlaceholderContent object : arrayList){
//            if (object.getName().toLowerCase().contains(query.toLowerCase())){
//                searchHolder.add(object);
//            }
//        }
//
//        for (PlaceholderContent object : arrayList2){
//            if (object.getName().toLowerCase().contains(query.toLowerCase())){
//                searchHolder2.add(object);
//            }
//        }
//
//        if (searchHolder.isEmpty()){
//            Toast.makeText(getActivity(), "No Data Found", Toast.LENGTH_SHORT).show();
//        }else {
//            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(searchHolder,this));
//            recyclerView2.setAdapter(new MyItemRecyclerViewAdapter(searchHolder2,this));
//
//        }
//    }


    public void OnItemSelected(PlaceholderContent customModel) {

//        Toast.makeText(getActivity(), customModel.getName(), Toast.LENGTH_SHORT).show();
        String[] Product = {customModel.getName(),customModel.getDesc(),customModel.getTitle(),String.valueOf(customModel.getImage_url()),customModel.getUrl()};
        Intent intent = new Intent(getActivity(), YouTubeVideoActivity.class);
        intent.putExtra("Product", Product);
        startActivity(intent);

    }
}
package com.demo.movieplus.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.movieplus.R;
import com.demo.movieplus.User.SelectedHomeItem;
import com.demo.movieplus.databinding.FragmentHomeBinding;
import com.demo.movieplus.ui.movies.MyItemRecyclerViewAdapter;
import com.demo.movieplus.ui.movies.placeholder.PlaceholderContent;
import com.demo.movieplus.webpages.YouTubeVideoActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements SelectedHomeItem {


    FragmentHomeBinding  binding;

    WebView webView;
    RecyclerView recyclerView;
    MyItemRecyclerViewAdapter  adapter1,adapter2;
    SearchView searchView;
    ArrayList<PlaceholderContent> arrayList,arrayList2;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        searchView = binding.searchViewList;
        recyclerView = binding.recyclerViewList;
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
                " formidable opponent.","Title",R.drawable.image7,"https://www.youtube.com/embed/x89qafBgq4Y?si=lS6rROInkAgcqoAB"));
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

        arrayList.add(new PlaceholderContent("Sistas","","Title",R.drawable.image86,"https://www.youtube.com/embed/Isvy2gILyo0?si=DazJycY_tGmWOV6i"));
        arrayList.add(new PlaceholderContent("Supacell","","Title",R.drawable.image91,"https://www.youtube.com/embed/Frmk94Etedo?si=ow-hA_qSixZON4Gs"));




        arrayList.add(new PlaceholderContent("Breathe","Breathe is a heart pounding thriller" +
                " set in the future.After Earth is left uninhabitable due to lack of oxygen," +
                " a mother Maya(Jennifer Hudson) and her daughter Zora (Quvenzhané Wallis)are" +
                " forced to live underground, with short trips to the surface only made possible" +
                " by a coveted state of the art oxygen suit made by Maya’s husband, Darius," +
                " whom she presumes to be dead. When a mysterious couple arrives claiming to" +
                " know Darius and his fate Maya tentatively agrees to let them into their" +
                " bunker but these visitors are not who they claim to be ensuing in mother" +
                " and daughter fighting for survival.","Title",R.drawable.image23,"https://www.youtube.com/embed/chaHsowROfQ?si=sIVvd6ay8GqMa3zN"));
        arrayList.add(new PlaceholderContent("Land Of Bad"," When a Delta Force team is ambushed" +
                " in enemy territory,a rookie officer (Liam Hemsworth) refuses to abandon them.Their only" +
                " hope lies with an Air Force drone pilot (Russell Crowe) as the eyes in the sky during a" +
                " brutal 48-hour battle for survival. ","Title",R.drawable.image27,"https://www.youtube.com/embed/yTFazxfrXVw?si=nL53qwNsIM-CDAxO"));
        arrayList.add(new PlaceholderContent("Madam Web"," In a switch from the typical genre," +
                " Madame Web tells the standalone origin story of one of Marvel publishing's most enigmatic" +
                " heroines.The suspense-driven thriller stars Dakota Johnson as Cassandra Webb,a paramedic" +
                " in Manhattan who develops the power to see the future… and realizes she can use that insight" +
                " to change it. Forced to confront revelations about her past, she forges a relationship with" +
                " three young women bound for powerful destinies...if they can all survive a" +
                " deadly present.","Title", R.drawable.image28,"https://www.youtube.com/embed/s_76M4c4LTo?si=x8DINBx3Bk0jZqN4"));
        arrayList.add(new PlaceholderContent("Life After Fighting","First movie trailer for" +
                " Life After Fighting starring Bren Foster.","Title",R.drawable.image70,"https://www.youtube.com/embed/iykZmLa5e34?si=8c885gBH8e0wiSyx"));
        arrayList.add(new PlaceholderContent("Todos los nombres de Dios","Tras un atentado," +
                " Santi es tomado como rehén por Hamza,el  único terrorista superviviente." +
                " Un giro inesperado intercambia los papeles y Santi se convierte en una" +
                " bomba humana  caminando por la Gran Vía de Madrid llevando un chaleco" +
                " cargado con explosivos.Los servicios de inteligencia,emergencia e incluso" +
                " los medios de comunicación, unirán fuerzas para salvarle la vida" +
                " en un impresionante despliegue con consecuencias inesperadas.","Title",R.drawable.image30,"https://www.youtube.com/embed/NoEd8WDFcZE?si=C15uPKoQ_oyjplr8"));
        arrayList.add(new PlaceholderContent("Logan"," In the near future," +
                " a weary Logan cares for an ailing Professor X in a hideout on the Mexican border." +
                " But Logan's attempts to hide from the world and his legacy are up-ended when a" +
                " young mutant arrives, being pursued by dark forces.","Title",R.drawable.image52,"https://www.youtube.com/embed/RH3OxVFvTeg?si=2T-3oqyFZX__7FrE"));
        arrayList.add(new PlaceholderContent("Humane","","Title",R.drawable.image53,"https://www.youtube.com/embed/V4b-OMLNWE0?si=3HPBHM__fovQkYg3"));
        arrayList.add(new PlaceholderContent("6 Hours Away"," An Ex-Marine must assassinate the" +
                " six rivals of the Cartel leader who kidnapped his wife, or never" +
                " see her again.","Title",R.drawable.image54,"https://www.youtube.com/embed/Z9rcVX8GZww?si=dgMqz_8YeFG9tWpK"));
        arrayList.add(new PlaceholderContent("The Acolyte","In an age of light, a darkness rises.","Title",R.drawable.image55,"https://www.youtube.com/embed/BtytYWhg2mc?si=WLtC14V6VEVpjZn0"));
        arrayList.add(new PlaceholderContent("Dark Matter"," Hailed as one of the best sci-fi" +
                " novels of the decade, Dark Matter is a story about the road not taken. The series will" +
                " follow Jason Dessen (played by Joel Edgerton), a physicist, professor and family man " +
                "who — one night while walking home on the streets of Chicago — is abducted into an " +
                "alternate version of his life. Wonder quickly turns o nightmare when he tries to " +
                "return to his <br>reality amid the mind-bending landscape of lives he could have " +
                "lived. In this labyrinth of realities, he embarks on a harrowing journey to get " +
                "back to his true family and save them from the most terrifying,unbeatable foe " +
                "imaginable: himself.","Title",R.drawable.image56,"https://www.youtube.com/embed/j6ucGt_Xp14?si=zsijb34ndT0qP0Is"));
        arrayList.add(new PlaceholderContent("Presumed Innocent","Based on The New York" +
                " Times bestselling novel of the same name by  Scott Turow, the gripping series" +
                " takes viewers on a journey through the horrific murder that upends the Chicago" +
                " Prosecuting Attorneys' office when chief deputy prosecutor Rusty Sabich" +
                " (played by Gyllenhaal)is suspected of the crime. The series explores obsession," +
                " sex,politics, and the power and limits of love, as the accused fights  to hold" +
                " his family and marriage together.","Title", R.drawable.image57,"https://www.youtube.com/embed/ZNSY3lMioHs?si=yB6bTJAbGGd4KDOV"));
        arrayList.add(new PlaceholderContent("Before The World Set On Fire","","Title",R.drawable.image59,"https://www.youtube.com/embed/Q_hMUUIuCUE?si=QRBlqjyhit3JULrh"));
        arrayList.add(new PlaceholderContent("Blue Bloods","","Title",R.drawable.image60,"https://www.youtube.com/embed/Gk9Q3QLTlXo?si=l4EgnUc1qmkYZWGj"));
        arrayList.add(new PlaceholderContent("Wild Eye And Wicked"," Lily’s therapist (Colleen Camp)" +
                " and girlfriend (Saunders) attempt to help Lily navigate the childhood loss of her mother," +
                " Silvia (Stefanie Estes).They encourage Lily, on the anniversary of her mother’s death," +
                " to accept her father’s invitation to visit him on the farm where Lily grew up.","Title",R.drawable.image61,"https://www.youtube.com/embed/BJQenyEQzxM?si=J-OFz1C3vIB9an2"));
        arrayList.add(new PlaceholderContent("Sweet Tooth"," Based on the beloved DC Comic," +
                " and Executive Produced by Susan Downey & Robert Downey Jr., Sweet Tooth is a" +
                " post-apocalyptic fairytale about a hybrid deer-boyand a wandering loner who" +
                " embark on an extraordinary adventure.","Title",R.drawable.image62,"https://www.youtube.com/embed/9zG9RuJb3QU?si=fT2Zg8CsPgHUzJfu"));
        arrayList.add(new PlaceholderContent("Di Ray"," D.I. Rachita Ray, a British Asian" +
                " policewoman new to homicide, is assigned to  investigate the suspected honour killing" +
                " of a young Muslim man.","Title",R.drawable.image63,"https://www.youtube.com/embed/__uhz_oRa1M?si=n-C1Nap0E9Mt5heQ"));
        arrayList.add(new PlaceholderContent("Severance"," From Ben Stiller and creator" +
                " Dan Erickson, Severance centers around Mark Scout (Adam Scott), a leader of a team" +
                " of office workers whose memories have been surgically divided between their work and" +
                " personal lives","Title",R.drawable.image65,"https://www.youtube.com/embed/xEQP4VVuyrY?si=HEVOXlxjUFtYGMx5"));
        arrayList.add(new PlaceholderContent("Interview With The Vampire"," A sensuous, contemporary" +
                " reinvention of Anne Rice’s revolutionary gothic novel,Anne Rice’s Interview with the" +
                " Vampire follows Louis de Pointe du Lac (Jacob Anderson),Lestat de Lioncourt (Sam Reid)" +
                " and Claudia’s (Bailey Bass) epic story of love, blood, and the perils of immortality," +
                " as told to journalist Daniel Molloy(Eric Bogosian). ","Title",R.drawable.image67,"https://www.youtube.com/embed/q8Oysn9I9K8?si=IrgsCy3tISme-9xx"));



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
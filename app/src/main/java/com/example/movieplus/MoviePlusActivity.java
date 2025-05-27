package com.example.movieplus;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;


import com.example.movieplus.ui.Favorites.FavoritesFragment;
import com.example.movieplus.ui.gallery.GalleryFragment;
import com.example.movieplus.ui.home.HomeFragment;
import com.example.movieplus.ui.movies.MovieFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.movieplus.databinding.ActivityMoviePlusBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MoviePlusActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawer;

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMoviePlusBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMoviePlusBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar = binding.appBarMoviePlus.toolbar;
        setSupportActionBar(binding.appBarMoviePlus.toolbar);

        binding.appBarMoviePlus.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });
        drawer = binding.drawerLayout;
        navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }



        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home,
//                R.id.nav_gallery,
//                R.id.nav_movie,
//                R.id.nav_favorites
//
//        )
//                .setOpenableLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_movie_plus);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       getMenuInflater().inflate(R.menu.movie_plus, menu);

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);


        }else if (item.getItemId() == R.id.nav_gallery){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new GalleryFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_gallery);


        }else if (item.getItemId() == R.id.nav_movie) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new MovieFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_movie);


        }else if (item.getItemId() == R.id.nav_favorites) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new FavoritesFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_favorites);


        }else if (item.getItemId() == R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
            finish();


        }




        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.action_logout) {

            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
            finish();

        }
        return super.onOptionsItemSelected(item);
    }


}
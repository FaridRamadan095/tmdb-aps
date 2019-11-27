package com.example.proyekjetpack.ui.favorite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.proyekjetpack.R;
import com.example.proyekjetpack.ui.favorite.movie.FavoriteMovieFragment;
import com.example.proyekjetpack.ui.favorite.tv.FavoriteTvFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FavoriteActivity extends AppCompatActivity {
    private final String SELECTED_MENU = "selected_menu";
    private BottomNavigationView navView;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = item -> {
        Fragment fragment = null;
        if (item.getItemId() == R.id.action_movie){
            fragment = FavoriteMovieFragment.newInstance();
        }else if (item.getItemId() == R.id.action_tv){
            fragment = FavoriteTvFragment.newInstance();
        }

        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.container, fragment)
                    .commit();
        }
        return true;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        if (savedInstanceState != null){
            savedInstanceState.getInt(SELECTED_MENU);
        }else {
            navView.setSelectedItemId(R.id.action_movie);
        }

        initAppBar();
    }


    private void initAppBar(){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(getResources().getString(R.string.Favorite));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_MENU, navView.getSelectedItemId());
    }
}

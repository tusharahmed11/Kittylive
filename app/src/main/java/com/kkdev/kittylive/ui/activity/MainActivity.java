package com.kkdev.kittylive.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kkdev.kittylive.R;
import com.kkdev.kittylive.ui.fragment.ExploreFragment;
import com.kkdev.kittylive.ui.fragment.HomeFragment;
import com.kkdev.kittylive.ui.fragment.LiveFragment;
import com.kkdev.kittylive.ui.fragment.StarFragment;
import com.kkdev.kittylive.ui.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }


    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.homeFragment:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.exploreFragment:
                            selectedFragment = new ExploreFragment();
                            break;
                        case R.id.liveFragment:
                            selectedFragment = new LiveFragment();
                            break;
                        case R.id.hotFragment:
                            selectedFragment = new StarFragment();
                            break;
                        case R.id.userFragment:
                            selectedFragment = new UserFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}
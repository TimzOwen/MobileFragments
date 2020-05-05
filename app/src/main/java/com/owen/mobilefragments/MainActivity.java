package com.owen.mobilefragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the reference id
        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

    }
    //created this out of the onCreate to avoid crowding onCreate method;
    //Using switch to find the fragment that has been selected.
  private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFrag = null;

                    switch (item.getItemId()){

                        case R.id.home_icon:
                            selectedFrag = new HomeFragment();
                            break;
                        case R.id.notfication_icon:
                            selectedFrag = new NotificationFragment();
                            break;
                        case R.id.call_icon:
                            selectedFrag = new CallFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFrag)
                            .commit();
                    return true;
                }
            };
}
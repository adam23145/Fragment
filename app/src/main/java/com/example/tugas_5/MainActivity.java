package com.example.tugas_5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView buttomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttomNavigation = findViewById(R.id.buttom_navigation);


        getSupportFragmentManager().beginTransaction().replace(R.id.frament_container, new ChatsFragment()).commit();

        buttomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment= null;

                switch (item.getItemId()){
                    case R.id.nav_chats:
                        selectedFragment = new ChatsFragment();
                        break;
                    case R.id.nav_call:
                        selectedFragment = new CallsFragment();
                        break;
                    case R.id.account:
                        selectedFragment = new StatusFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frament_container, selectedFragment).commit();
                return true;

            }
        });

    }
}
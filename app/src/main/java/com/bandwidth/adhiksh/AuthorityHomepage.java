package com.bandwidth.adhiksh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AuthorityHomepage extends AppCompatActivity {
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authority_homepage);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new FragmentFir()).commit();

        navigation = (BottomNavigationView) findViewById(R.id.bottomNavBar);
        navigation.setOnNavigationItemSelectedListener(navlistner);

    }



    private BottomNavigationView.OnNavigationItemSelectedListener navlistner
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.fir_icon:
                    selectedFragment = new FragmentFir();
                    loadFragment(selectedFragment);
                    return true;

                case R.id.complaint_icon:
                    selectedFragment = new ComplaintFragment();
                    loadFragment(selectedFragment);
                    return true;

                case R.id.appointment_icon:
                    selectedFragment = new AppointmentFragment();
                    loadFragment(selectedFragment);
                    return true;

                case R.id.noc_icon:
                    selectedFragment = new FragmentNoc();
                    loadFragment(selectedFragment);
                    return true;
            }

//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                    selectedFragment).commit();

            return false;


        }

    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

}

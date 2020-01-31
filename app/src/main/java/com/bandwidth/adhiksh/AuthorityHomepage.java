package com.bandwidth.adhiksh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bandwidth.adhiksh.Fragments.AppointmentFragment;
import com.bandwidth.adhiksh.Fragments.ComplaintFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.valdesekamdem.library.mdtoast.MDToast;
import android.net.Uri;



public class AuthorityHomepage extends AppCompatActivity {
    BottomNavigationView navigation;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    ImageView icon;
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authority_homepage);
        setUIViews();

//        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
        toggle = new ActionBarDrawerToggle(AuthorityHomepage.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        drawer.closeDrawers();

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });



//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                new FragmentFir()).commit();

        navigation = (BottomNavigationView) findViewById(R.id.bottomNavBar);
        navigation.setOnNavigationItemSelectedListener(navlistner);
        navigation.setSelectedItemId(R.id.fir_icon);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(navListner);

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
    private void setUIViews(){
        icon = findViewById(R.id.btn_drawer);
        navigationView = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(Gravity.LEFT))
            drawer.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    private NavigationView.OnNavigationItemSelectedListener navListner =
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = null;
                    // Handle navigation view item clicks here.
                    switch (item.getItemId()) {

                        case R.id.logout: {
                            //do somthing
                            MDToast mdToast = MDToast.makeText(AuthorityHomepage.this, "Log out successful", 1000, 1);
                            mdToast.show();
                            finish();
                            break;
                        }
                        case R.id.faq:{

                            openUrl("http://www.ncrb.org/ncrb/WorkersCompensation/FAQs/tabid/494/Default.aspx");
                            break;
                        }

                        case R.id.help:{

                            myweb();

                            break;
                        }
//
//                        case R.id.appointment_icon:{
//
//                            selectedFragment = new AppointmentFragment();
//                            loadFragment(selectedFragment);
//                            break;
//                        }
//
//                        case R.id.complaint_icon:{
//
//                            selectedFragment = new ComplaintFragment();
//                            loadFragment(selectedFragment);
//                            break;
//                        }

                        case R.id.home_icon:{

                            selectedFragment = new FragmentFir();
                            loadFragment(selectedFragment);
                            break;
                        }


                    }

                    //close navigation drawer
                    drawer.closeDrawer(GravityCompat.START);
                    return true;
                }
            };

    public void myweb(){
        openUrl("http://ncrb.gov.in/index.htm");
    }

    private void openUrl(String s) {

        Uri uri=Uri.parse(s);
        Intent launch=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(launch);
    }




}

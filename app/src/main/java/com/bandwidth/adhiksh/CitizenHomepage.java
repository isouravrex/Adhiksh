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
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bandwidth.adhiksh.Fragments.AppointmentFragment;
import com.bandwidth.adhiksh.Fragments.ComplaintFragment;
import com.google.android.material.navigation.NavigationView;
import com.valdesekamdem.library.mdtoast.MDToast;

public class CitizenHomepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout registerFIR, requestNOC, registerComplaint, requestAppointment;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    ImageView icon;
    Toolbar toolbar;
    NavigationView navigationView;
    //    View logout;
    MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizen_homepage);
        setUIViews();
        loadFragment(new CitizenHomeFragment());

//        loadFragment(CitizenHomeFragment);

        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(CitizenHomepage.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        drawer.closeDrawers();


        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(navListner);
//        navigationView.setSele(R.id.home_icon)


//        registerFIR.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(CitizenHomepage.this, FirForm.class));
//            }
//        });
//
//        registerComplaint.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(CitizenHomepage.this, ComplaintForm.class));
//            }
//        });
//
//        requestAppointment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(CitizenHomepage.this, AppointmentForm.class));
//            }
//        });
//
//        requestNOC.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(CitizenHomepage.this, NOCForm.class));
//            }
//        });

//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               finish();
//            }
//        });
//        switch (item.getItemId()) {
//            case logout:
//                finish();
//                break;

    }

    private void setUIViews() {
        registerFIR = findViewById(R.id.registerFIR);
        registerComplaint = findViewById(R.id.registerComplaint);
        requestNOC = findViewById(R.id.requestNOC);
        requestAppointment = findViewById(R.id.requestAppointment);
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
                            MDToast mdToast = MDToast.makeText(CitizenHomepage.this, "Log out successful", 1000, 1);
                            mdToast.show();
                            finish();
                            break;
                        }
                        case R.id.fir_icon:{

                            selectedFragment = new FragmentFir();
                            loadFragment(selectedFragment);
                            break;
                        }

                        case R.id.noc_icon:{

                            selectedFragment = new FragmentNoc();
                            loadFragment(selectedFragment);
                            break;
                        }

                        case R.id.appointment_icon:{

                            selectedFragment = new AppointmentFragment();
                            loadFragment(selectedFragment);
                            break;
                        }

                        case R.id.complaint_icon:{

                            selectedFragment = new ComplaintFragment();
                            loadFragment(selectedFragment);
                            break;
                        }

                        case R.id.home_icon:{

                            selectedFragment = new CitizenHomeFragment();
                            loadFragment(selectedFragment);
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

                        case R.id.sosd:{

                            selectedFragment = new SosFragment();
                            loadFragment(selectedFragment);
                            break;
                        }



                    }

                    //close navigation drawer
                    drawer.closeDrawer(GravityCompat.START);
                    return true;
                }
            };

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//
//    }

    private void loadFragment(Fragment selectedFragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_containerr,selectedFragment);
//        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    public void myweb(){
        openUrl("http://ncrb.gov.in/index.htm");
    }

    private void openUrl(String s) {

        Uri uri=Uri.parse(s);
        Intent launch=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(launch);
    }

}

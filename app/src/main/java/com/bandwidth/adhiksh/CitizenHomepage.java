package com.bandwidth.adhiksh;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CitizenHomepage extends AppCompatActivity {

    LinearLayout registerFIR,requestNOC,registerComplaint,requestAppointment;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    ImageView icon;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizen_homepage);
        setUIViews();

        drawer=findViewById(R.id.drawer_layout);
        toolbar=findViewById(R.id.toolbar);

        toggle = new ActionBarDrawerToggle(CitizenHomepage.this,drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        drawer.closeDrawers();

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });




        registerFIR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CitizenHomepage.this, FirForm.class));
            }
        });

        registerComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CitizenHomepage.this, ComplaintForm.class));
            }
        });

        requestAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CitizenHomepage.this, AppointmentForm.class));
            }
        });

        requestNOC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CitizenHomepage.this, NOCForm.class));
            }
        });
    }

    private void setUIViews(){
        registerFIR = findViewById(R.id.registerFIR);
        registerComplaint = findViewById(R.id.registerComplaint);
        requestNOC = findViewById(R.id.requestNOC);
        requestAppointment = findViewById(R.id.requestAppointment);
        icon = findViewById(R.id.btn_drawer);
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(Gravity.LEFT))
            drawer.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }




}

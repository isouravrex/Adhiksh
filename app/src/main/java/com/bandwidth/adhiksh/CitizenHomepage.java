package com.bandwidth.adhiksh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class CitizenHomepage extends AppCompatActivity {

    LinearLayout registerFIR,requestNOC,registerComplaint,requestAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizen_homepage);
        setUIViews();

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
    }
}

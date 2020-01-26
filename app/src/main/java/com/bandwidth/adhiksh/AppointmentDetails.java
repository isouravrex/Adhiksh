package com.bandwidth.adhiksh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import javax.security.auth.Subject;

public class AppointmentDetails extends AppCompatActivity {

    TextView subjectTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_details);

        String subject = getIntent().getStringExtra("subject");

        subjectTv = findViewById(R.id.subject_tv);
        subjectTv.setText(subject);


    }
}

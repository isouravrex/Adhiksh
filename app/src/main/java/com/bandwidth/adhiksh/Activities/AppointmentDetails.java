package com.bandwidth.adhiksh.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bandwidth.adhiksh.AuthorityHomepage;
import com.bandwidth.adhiksh.NocDetails;
import com.bandwidth.adhiksh.R;
import com.google.android.material.button.MaterialButton;

import javax.security.auth.Subject;

public class AppointmentDetails extends AppCompatActivity {

    MaterialButton back;

    TextView subjectTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_details);

        String subject = getIntent().getStringExtra("subject");

        subjectTv = findViewById(R.id.subject_tv);
        subjectTv.setText(subject);
        setUIViews();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AppointmentDetails.this,"Response submitted",Toast.LENGTH_LONG).show();
                startActivity(new Intent(AppointmentDetails.this, AuthorityHomepage.class));
            }

        });

    }

    private void setUIViews(){

        back = findViewById(R.id.btn_appoint_sub);
    }
}


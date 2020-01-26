package com.bandwidth.adhiksh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AppointmentForm extends AppCompatActivity {

    MaterialButton submit;
    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("appointment");


    EditText nameOfPesonal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_form);
        setUIViews();

        nameOfPesonal = findViewById(R.id.editTextAuthority);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String personalName = nameOfPesonal.getText().toString();
                myRef.setValue("name");
            }
        });

    }

    private void setUIViews(){

        submit = findViewById(R.id.btn_submitAppointment);
    }
}

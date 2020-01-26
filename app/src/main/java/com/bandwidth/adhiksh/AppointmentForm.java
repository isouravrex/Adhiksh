package com.bandwidth.adhiksh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AppointmentForm extends AppCompatActivity {

    MaterialButton submit;
    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("/");

    private static final String TAG = "AppointmentForm";


    TextInputEditText nameOfPesonal, dateEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_form);
        setUIViews();

        nameOfPesonal = findViewById(R.id.editTextAuthority);
        submit = findViewById(R.id.btn_submitAppointment);
        dateEt = findViewById(R.id.editDate);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String personalName = nameOfPesonal.getText().toString();
                String date = dateEt.getText().toString();
                myRef.child("appointment").child(1+"").child("Personnel Name").setValue(personalName);
                myRef.child("appointment").child(1+"").child("date").setValue(date);
                //myRef.setValue("demo", personalName);
            }
        });

        getDataFromDB();

    }

    private void setUIViews(){

        submit = findViewById(R.id.btn_submitAppointment);
    }


    private void getDataFromDB(){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                DataSnapshot temp = dataSnapshot.child("appointment");

                for (DataSnapshot demo: temp.getChildren()) {

                    String name = demo
                            .child("Personnel Name").getValue().toString();
                    Log.d(TAG, "onDataChange: " + name);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}

package com.bandwidth.adhiksh.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;

import com.bandwidth.adhiksh.Activities.FormSubmission;
import com.bandwidth.adhiksh.R;
import com.bandwidth.adhiksh.model.AppModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.valdesekamdem.library.mdtoast.MDToast;

import java.util.Random;

public class AppointmentForm extends AppCompatActivity {

    private static long fraction;
    MaterialButton submit;
    // Write a message to the database
    TextInputEditText authnamec,namec,datec,timec,agec,emailc,mobilec,subjectc,
            descriptionc;
    final int SHORT_ID_LENGTH = 8;
    DatabaseReference databaseAppoint;
    Spinner authorityc;

    private static final String TAG = "AppointmentForm";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_form);
        setUIViews();

        databaseAppoint = FirebaseDatabase.getInstance().getReference("Appointments");

        submit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                addAppointment();


                //myRef.setValue("demo", personalName);
            }

        });

//        getDataFromDB();


    }

    private void setUIViews(){

        submit = findViewById(R.id.btn_submitAppointment);
        namec = findViewById(R.id.edit_name);
        agec = findViewById(R.id.editAge);
        authnamec = findViewById(R.id.etAuthority);
        authorityc = findViewById(R.id.spinner);
        emailc = findViewById(R.id.emailEt);
        mobilec = findViewById(R.id.editMobileNo);
        subjectc = findViewById(R.id.editTextSubject);
        datec= findViewById(R.id.editDate);
        timec = findViewById(R.id.editTime);
        descriptionc = findViewById(R.id.editDescription);
    }

    private void addAppointment(){

        String name = namec.getText().toString();
        String age = agec.getText().toString();
        String email = emailc.getText().toString();
        String mobile = mobilec.getText().toString();
        String subject = subjectc.getText().toString();
        String date = datec.getText().toString();
        String time = timec.getText().toString();
        String authorityname = authnamec.getText().toString();
        String description = descriptionc.getText().toString();
        String authority = authorityc.getSelectedItem().toString();
       String lar = String.valueOf(fraction);
        Log.d(TAG, "addAppointment: name = "+name);
        Log.d(TAG, "addAppointment: age = "+age);


        if(!(TextUtils.isEmpty(name)||TextUtils.isEmpty(age)
                ||TextUtils.isEmpty(mobile)||TextUtils.isEmpty(subject)||TextUtils.isEmpty(email))){

            String id = databaseAppoint.push().getKey();

            AppModel appointments=new AppModel(id,name,age,email,mobile,subject,date,time,authorityname,description,authority);
//            AppModel appoint = new AppModel(lar);
            databaseAppoint.child(id).setValue(appointments);
//            databaseAppoint.child(id).setValue(appoint);
            startActivity(new Intent(AppointmentForm.this, FormSubmission.class));


//            root.child("sos").child(citizenId).setValue(1);
//            root.child("sos").child(citizenId).setValue(1);
//            root.child("sos").child(citizenId).setValue(1);



        }

        else
        {
//            Toast.makeText(this,"Enter All Fields",Toast.LENGTH_LONG).show();
            MDToast.makeText(this, "Enter all Feilds", 1000, 3).show();

        }



        createRandomInteger(10000000,99999999,new Random());
    }


//    private void getDataFromDB(){
//        databaseAppoint.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                //String value = dataSnapshot.getValue(String.class);
//                DataSnapshot temp = dataSnapshot.child("appointment");
//
//                for (DataSnapshot demo: temp.getChildren()) {
//
//                    String name = demo.child("Personnel Name").getValue().toString();
//                    Log.d(TAG, "onDataChange: " + name);
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
//    }

    private static void createRandomInteger(int aStart, long aEnd, Random aRandom){
        if ( aStart > aEnd ) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        //get the range, casting to long to avoid overflow problems
        long range = aEnd - (long)aStart + 1;
        Log.i(TAG, "createRandomInteger: "+range);//.info("range>>>>>>>>>>>"+range);
        // compute a fraction of the range, 0 <= frac < range
        fraction = (long)(range * aRandom.nextDouble());
//        logger.info("fraction>>>>>>>>>>>>>>>>>>>>"+fraction);
        Log.i(TAG, "createRandomInteger: x = "+fraction);
        long randomNumber =  fraction + (long)aStart;
//        logger.info("Generated : " + randomNumber);
        Log.i(TAG, "createRandomInteger: y = "+randomNumber);

    }
}

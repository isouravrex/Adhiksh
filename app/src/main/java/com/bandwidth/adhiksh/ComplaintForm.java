package com.bandwidth.adhiksh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.valdesekamdem.library.mdtoast.MDToast;

public class ComplaintForm extends AppCompatActivity {

    MaterialButton submit;
    TextInputEditText namec,agec,aadharc,addressc,localityc,pinc,emailc,mobilec,subjectc,datec,timec,locationc,
    descriptionc,solutionc;
    DatabaseReference databaseComplaints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_form);
        setUIViews();

        databaseComplaints = FirebaseDatabase.getInstance().getReference("Complaints");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addComplaint();
                startActivity(new Intent(ComplaintForm.this, FormSubmission.class));
            }
        });

    }

    private void setUIViews(){

        submit = findViewById(R.id.btn_submitComplaint);
        namec = findViewById(R.id.edit_name);
        agec = findViewById(R.id.editAge);
        aadharc = findViewById(R.id.editAadhar);
        addressc = findViewById(R.id.editAddress);
        localityc = findViewById(R.id.editLocality);
        pinc = findViewById(R.id.editPin);
        emailc = findViewById(R.id.editEmail);
        mobilec = findViewById(R.id.editMobileNo);
        subjectc = findViewById(R.id.editTextSubject);
        datec= findViewById(R.id.editDate);
        timec = findViewById(R.id.editTime);
        locationc= findViewById(R.id.editLocation);
        descriptionc = findViewById(R.id.editDescription);
        solutionc = findViewById(R.id.editSuggestion);
    }

    private void addComplaint(){

        String name = namec.getText().toString();
        String age = agec.getText().toString();
        String aadhar = aadharc.getText().toString();
        String address = addressc.getText().toString();
        String locality = localityc.getText().toString();
        String pin = pinc.getText().toString();
        String email = emailc.getText().toString();
        String mobile = mobilec.getText().toString();
        String subject = subjectc.getText().toString();
        String date = datec.getText().toString();
        String time = timec.getText().toString();
        String location = locationc.getText().toString();
        String description = descriptionc.getText().toString();
        String solution = solutionc.getText().toString();

        if(!TextUtils.isEmpty(name)||!TextUtils.isEmpty(age)||!TextUtils.isEmpty(aadhar)||!TextUtils.isEmpty(address)||!TextUtils.isEmpty(pin)
                ||!TextUtils.isEmpty(mobile)||!TextUtils.isEmpty(subject)||!TextUtils.isEmpty(email)){

            String id = databaseComplaints.push().getKey();

            Model complaints=new Model(id,name,age,aadhar,address,locality,pin,email,mobile,subject,date,time,location,description,solution);

            databaseComplaints.child(id).setValue(complaints);



        }
        else
        {
//            Toast.makeText(this,"Enter All Fields",Toast.LENGTH_LONG).show();
            MDToast mdToast = MDToast.makeText(this, "Enter all Feilds", 1000, 3);

        }


    }

}

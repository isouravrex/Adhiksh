package com.bandwidth.adhiksh.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Spinner;

import com.bandwidth.adhiksh.Activities.FormSubmission;
import com.bandwidth.adhiksh.R;
import com.bandwidth.adhiksh.model.NocModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.valdesekamdem.library.mdtoast.MDToast;

public class NOCForm extends AppCompatActivity {

    MaterialButton submit;
    TextInputEditText namec,agec,aadharc,emailc,mobilec,subjectc,fathername,
            descriptionc;
    DatabaseReference databaseNoc;
    Spinner categoreys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nocform);
        setUIViews();

        databaseNoc = FirebaseDatabase.getInstance().getReference("Nocrequests");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNoc();
                startActivity(new Intent(NOCForm.this, FormSubmission.class));
            }
        });

    }

    private void setUIViews(){

        submit = findViewById(R.id.btn_requestNoc);
        namec = findViewById(R.id.edit_name);
        agec = findViewById(R.id.editAge);
        aadharc = findViewById(R.id.editAadhar);
        fathername = findViewById(R.id.fathers_et);
        emailc = findViewById(R.id.editEmail);
        mobilec = findViewById(R.id.edit_mob);
        subjectc = findViewById(R.id.editTextSubject);
        categoreys = findViewById(R.id.spinner);

        descriptionc = findViewById(R.id.editDescription);
    }

    private void addNoc(){

        String name = namec.getText().toString();
        String age = agec.getText().toString();
        String aadhar = aadharc.getText().toString();
        String fathersn = fathername.getText().toString();
        String category = categoreys.getSelectedItem().toString();

        String email = emailc.getText().toString();
        String mobile = mobilec.getText().toString();
        String subject = subjectc.getText().toString();

        String description = descriptionc.getText().toString();

        if(!TextUtils.isEmpty(name)||!TextUtils.isEmpty(age)||!TextUtils.isEmpty(aadhar)
                ||!TextUtils.isEmpty(mobile)||!TextUtils.isEmpty(subject)||!TextUtils.isEmpty(email)){

            String id = databaseNoc.push().getKey();

            NocModel noc=new NocModel(id,name,age,aadhar,fathersn,category,email,mobile,subject,description);

            databaseNoc.child(id).setValue(noc);

            MDToast mdToast = MDToast.makeText(this, "Form Submitted", 1000, 1);
            mdToast.show();





        }
        else
        {
//            Toast.makeText(this,"Enter All Fields",Toast.LENGTH_LONG).show();
            MDToast mdToast = MDToast.makeText(this, "Enter all Feilds", 1000, 3);
            mdToast.show();
        }


    }
}
//        MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.spinner1);
//        spinner.setItems("Job", "Loan", "Property", "Vehicle");
//        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
//
//            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
//                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
//            }
//        });

package com.bandwidth.adhiksh.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bandwidth.adhiksh.AuthorityHomepage;
import com.bandwidth.adhiksh.CitizenHomepage;
import com.bandwidth.adhiksh.NocDetails;
import com.bandwidth.adhiksh.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.valdesekamdem.library.mdtoast.MDToast;

import javax.security.auth.Subject;

import static com.bandwidth.adhiksh.MainActivity.b;

public class AppointmentDetails extends AppCompatActivity {

    MaterialButton back;
    TextInputLayout remarks;
    LinearLayout selectc,statuss;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    TextView subj,auth,authname,datec,aadhare,timec,namee,emaile,mobe,subjecte,datee,agee,desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_details);

        setDatabase();

        setUIViews();

        if(b==true)
        {
            back.setVisibility(View.INVISIBLE);
            remarks.setVisibility(View.INVISIBLE);
            selectc.setVisibility(View.INVISIBLE);
        }
        else {
            statuss.setVisibility(View.INVISIBLE);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MDToast mdToast = MDToast.makeText(AppointmentDetails.this, "Response Submitted", 1000, 1);
                mdToast.show();
                startActivity(new Intent(AppointmentDetails.this, AuthorityHomepage.class));
            }

        });

    }

    private void setDatabase(){

        String id=getIntent().getStringExtra("appointmentId");
        DatabaseReference myRef = database.getReference("Appointments").child(id);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                String subject=dataSnapshot.child("subject").getValue().toString();
                subj.setText(subject);
                String loc=dataSnapshot.child("authority").getValue().toString();
                auth.setText(loc);
                String name=dataSnapshot.child("name").getValue().toString();
                namee.setText(name);
                String age=dataSnapshot.child("authorityname").getValue().toString();
                authname.setText(age);
//                String aadhar=dataSnapshot.child("aadhar").getValue().toString();
//                aadhare.setText(aadhar);
//                String add=dataSnapshot.child("date").getValue().toString();

                String loca=dataSnapshot.child("time").getValue().toString();
                timec.setText(loca);

                String email=dataSnapshot.child("email").getValue().toString();
                emaile.setText(email);
                String des=dataSnapshot.child("description").getValue().toString();
                desc.setText(des);
                String mob=dataSnapshot.child("mob").getValue().toString();
                mobe.setText(mob);
                subjecte.setText(subject);
                String date=dataSnapshot.child("date").getValue().toString();
                datee.setText(date);
                datec.setText(date);
                String locality=dataSnapshot.child("age").getValue().toString();
                agee.setText(locality);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void setUIViews(){

        back = findViewById(R.id.btn_appoint_sub);
        remarks= findViewById(R.id.remarkss);
        selectc= findViewById(R.id.select);
        statuss= findViewById(R.id.status);
        subj=findViewById(R.id.subject_tv);
        auth=findViewById(R.id.authoritytv);
        namee=findViewById(R.id.nametv);
        authname    =findViewById(R.id.authorityname);
        aadhare =findViewById(R.id.aadhartv);
        datec=findViewById(R.id.date_tv);
        timec=findViewById(R.id.timetv);
        agee  =findViewById(R.id.age_tv);
        emaile=findViewById(R.id.emailtv);
        mobe=findViewById(R.id.mob);
        subjecte=findViewById(R.id.subject_tv);
        datee=findViewById(R.id.datetv);
        desc=findViewById(R.id.destv);


    }
}


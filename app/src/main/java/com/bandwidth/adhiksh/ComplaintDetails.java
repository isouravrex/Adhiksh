package com.bandwidth.adhiksh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ComplaintDetails extends AppCompatActivity {

     MaterialButton back;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    TextView subj,loce,namee,agee,aadhare,adde,locae,pine,emaile,mobe,subjecte,datee,localitye,dese,sole;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_details);

        setDatabase();
        setUIViews();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ComplaintDetails.this,"Response submitted",Toast.LENGTH_LONG).show();
                startActivity(new Intent(ComplaintDetails.this, AuthorityHomepage.class));
            }

        });

    }

    private void setDatabase(){

        String id=getIntent().getStringExtra("ComplaintId");
        DatabaseReference myRef = database.getReference("Complaints").child(id);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                String subject=dataSnapshot.child("subject").getValue().toString();
                subj.setText(subject);
                String loc=dataSnapshot.child("location").getValue().toString();
                loce.setText(loc);
                String name=dataSnapshot.child("name").getValue().toString();
                namee.setText(name);
                String age=dataSnapshot.child("age").getValue().toString();
                agee.setText(age);
                String aadhar=dataSnapshot.child("aadhar").getValue().toString();
                aadhare.setText(aadhar);
                String add=dataSnapshot.child("add").getValue().toString();
                adde.setText(add);
                String loca=dataSnapshot.child("locality").getValue().toString();
                locae.setText(loca);
                String pin=dataSnapshot.child("pin").getValue().toString();
                pine.setText(pin);
                String email=dataSnapshot.child("email").getValue().toString();
                emaile.setText(email);
                String mob=dataSnapshot.child("mob").getValue().toString();
                mobe.setText(mob);
                subjecte.setText(subject);
                String date=dataSnapshot.child("date").getValue().toString();
                datee.setText(date);
                String locality=dataSnapshot.child("location").getValue().toString();
                localitye.setText(locality);
                String des=dataSnapshot.child("des").getValue().toString();
                dese.setText(des);
                String sugg=dataSnapshot.child("solution").getValue().toString();
                sole.setText(sugg);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void setUIViews(){

        back = findViewById(R.id.btn_complaint_sub);
        subj=findViewById(R.id.subj_tv);
        loce=findViewById(R.id.loc);
        namee=findViewById(R.id.nametv);
            agee    =findViewById(R.id.age_tv);
               aadhare =findViewById(R.id.aadhartv);
                adde=findViewById(R.id.addtv);
                locae=findViewById(R.id.loca);
              pine  =findViewById(R.id.pin);
                emaile=findViewById(R.id.emailtv);
                mobe=findViewById(R.id.mob);
                subjecte=findViewById(R.id.subject_tv);
               datee=findViewById(R.id.datetv);
                localitye=findViewById(R.id.locality);
                dese=findViewById(R.id.des);
                sole=findViewById(R.id.sugg);


    }
}

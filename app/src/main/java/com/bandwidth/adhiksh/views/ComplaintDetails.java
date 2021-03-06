package com.bandwidth.adhiksh.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bandwidth.adhiksh.Activities.AuthorityHomepage;
import com.bandwidth.adhiksh.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.valdesekamdem.library.mdtoast.MDToast;

import static com.bandwidth.adhiksh.Activities.MainActivity.b;

public class ComplaintDetails extends AppCompatActivity {

     MaterialButton back;
    TextInputLayout remarks;
    LinearLayout selectc,statuss;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    TextView subj,loce,namee,agee,aadhare,adde,locae,pine,emaile,mobe,subjecte,datee,localitye,dese,sole;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_details);

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
                MDToast mdToast = MDToast.makeText(ComplaintDetails.this, "Response Submitted", 1000, 1);
                mdToast.show();
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
                mobe=findViewById(R.id.mobtv);
                subjecte=findViewById(R.id.subject_tv);
               datee=findViewById(R.id.datetv);
                localitye=findViewById(R.id.locality);
                dese=findViewById(R.id.des);
                sole=findViewById(R.id.sugg);
        remarks= findViewById(R.id.remarkss);
        selectc= findViewById(R.id.select);
        statuss= findViewById(R.id.status);


    }
}

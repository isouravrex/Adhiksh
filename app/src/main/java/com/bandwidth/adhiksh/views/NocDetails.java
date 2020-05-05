package com.bandwidth.adhiksh.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bandwidth.adhiksh.Activities.AuthorityHomepage;
import com.bandwidth.adhiksh.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.FirebaseDatabase;

import static com.bandwidth.adhiksh.Activities.MainActivity.b;

public class   NocDetails extends AppCompatActivity {
    MaterialButton back;
    TextInputLayout remarks;
    LinearLayout selectc,statuss;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    TextView subj,auth,authname,datec,aadhare,timec,namee,emaile,mobe,subjecte,datee,agee,desc;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noc_details);
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
                Toast.makeText(NocDetails.this,"Response submitted",Toast.LENGTH_LONG).show();
                startActivity(new Intent(NocDetails.this, AuthorityHomepage.class));
            }

        });

    }

    private void setUIViews(){

        back = findViewById(R.id.btn_noc_sub);
        remarks= findViewById(R.id.remarkss);
        selectc= findViewById(R.id.select);
        statuss= findViewById(R.id.status);
    }
}

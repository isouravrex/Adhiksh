package com.bandwidth.adhiksh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import static com.bandwidth.adhiksh.MainActivity.b;

public class NocDetails extends AppCompatActivity {
    MaterialButton back;
    TextInputLayout remarks;
    LinearLayout selectc,statuss;



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

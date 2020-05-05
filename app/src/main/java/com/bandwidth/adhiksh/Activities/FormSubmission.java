package com.bandwidth.adhiksh.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bandwidth.adhiksh.views.CitizenHomepage;
import com.bandwidth.adhiksh.R;
import com.google.android.material.button.MaterialButton;

public class FormSubmission extends AppCompatActivity {
    MaterialButton back;
    TextView lar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_submission);
        setUIViews();

//        long numb =rand(10000000, 99999999);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormSubmission.this, CitizenHomepage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

    }

    private void setUIViews(){

        back = findViewById(R.id.btn_back);
        lar = findViewById(R.id.lar);

    }

//    private long rand(int i, int i1) {
//        long num;
//        num= rand(10000000, 99999999);
//        return num;
//    }
}

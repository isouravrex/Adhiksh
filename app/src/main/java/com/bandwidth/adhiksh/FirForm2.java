package com.bandwidth.adhiksh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class FirForm2 extends AppCompatActivity {

    MaterialButton submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fir_form2);
        setUIViews();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirForm2.this, FormSubmission.class));
            }
        });

    }

    private void setUIViews(){

        submit = findViewById(R.id.btn_submitFir);
    }
}

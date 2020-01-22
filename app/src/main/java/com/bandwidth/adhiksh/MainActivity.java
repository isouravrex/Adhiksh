package com.bandwidth.adhiksh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    MaterialButton login;
    TextView signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUIViews();
        final RadioButton radioButtonCitizen = (RadioButton) findViewById(R.id.radioCitizen);
        final RadioButton radioButtonAuthority = (RadioButton) findViewById(R.id.radioAuthority);// initiate a radio button


            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(radioButtonAuthority.isChecked()) {
                        startActivity(new Intent(MainActivity.this, AuthorityHome.class));
                    }
                    else if(radioButtonCitizen.isChecked())
                    {
                        startActivity(new Intent(MainActivity.this, CitizenHomepage.class));
                    }

                }
            });




        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUp.class));
            }
        });
    }

    private void setUIViews(){
        login = findViewById(R.id.btn_login);
        signUp = findViewById(R.id.tv_signup);
    }

}

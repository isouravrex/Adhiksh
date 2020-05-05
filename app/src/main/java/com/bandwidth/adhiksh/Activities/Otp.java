package com.bandwidth.adhiksh.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bandwidth.adhiksh.views.CitizenHomepage;
import com.bandwidth.adhiksh.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.valdesekamdem.library.mdtoast.MDToast;

public class Otp extends AppCompatActivity {

    TextInputEditText otpe;
    MaterialButton verify;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        otpe=findViewById(R.id.editOtp);
        verify=findViewById(R.id.btn_verify);

        String otp= otpe.getText().toString();

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(Otp.this, CitizenHomepage.class));

                MDToast mdToast = MDToast.makeText(Otp.this, "Sign In successful", 1000, 1);
                mdToast.show();
            }
        });




    }
}

package com.bandwidth.adhiksh.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.bandwidth.adhiksh.Activities.AuthorityHomepage;
import com.bandwidth.adhiksh.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.valdesekamdem.library.mdtoast.MDToast;

import static com.bandwidth.adhiksh.Activities.MainActivity.b;

public class FirDetails extends AppCompatActivity {
    MaterialButton back;
//    TextInputEditText remarkss;
    TextInputLayout remarks;
    LinearLayout selectc,statuss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fir_details);

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
                MDToast mdToast = MDToast.makeText(FirDetails.this, "Response Submitted", 1000, 1);
                mdToast.show();
                startActivity(new Intent(FirDetails.this, AuthorityHomepage.class));
            }

        });

    }

    private void setUIViews(){

        back = findViewById(R.id.btn_fir_sub);
        remarks= findViewById(R.id.remarkss);
        selectc= findViewById(R.id.select);
        statuss= findViewById(R.id.status);
    }
}


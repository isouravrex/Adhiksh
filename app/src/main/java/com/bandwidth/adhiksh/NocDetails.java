package com.bandwidth.adhiksh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class NocDetails extends AppCompatActivity {
    MaterialButton back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noc_details);
        setUIViews();

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
    }
}

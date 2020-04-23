package com.bandwidth.adhiksh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.valdesekamdem.library.mdtoast.MDToast;

import static com.bandwidth.adhiksh.MainActivity.b;

public class AuthorityPanel extends AppCompatActivity {

    MaterialButton submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authority_panel);

        submit=findViewById(R.id.btn_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AuthorityPanel.this, AuthorityHomepage.class));
                MDToast.makeText(AuthorityPanel.this, "Response Submitted", 4000, 1).show();

            }
        });
    }
}

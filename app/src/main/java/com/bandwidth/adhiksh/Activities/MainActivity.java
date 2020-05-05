package com.bandwidth.adhiksh.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bandwidth.adhiksh.views.CitizenHomepage;
import com.bandwidth.adhiksh.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.valdesekamdem.library.mdtoast.MDToast;

public class MainActivity extends AppCompatActivity {

    MaterialButton login;
    TextView signUp;
    TextInputEditText emailEt, passwordEt;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;
    public static boolean b=true;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUIViews();
        final RadioButton radioButtonCitizen = (RadioButton) findViewById(R.id.radioCitizen);
        final RadioButton radioButtonAuthority = (RadioButton) findViewById(R.id.radioAuthority);// initiate a radio button

        progressBar = findViewById(R.id.progress_bar);

        emailEt = findViewById(R.id.emailEt);
        passwordEt = findViewById(R.id.passwordEt);
        mAuth = FirebaseAuth.getInstance();

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(radioButtonAuthority.isChecked()) {
                        startActivity(new Intent(MainActivity.this, AuthorityHomepage.class));
                        MDToast mdToast = MDToast.makeText(MainActivity.this, "Log In Successful As Authority", 3000, 1);
                        mdToast.show();

                        b = false;
                    }
                    else if(radioButtonCitizen.isChecked()) {
                        b=true;
                        String email = emailEt.getText().toString();
                        String password = passwordEt.getText().toString();

                        if(!(email.isEmpty() || password.isEmpty()))
                            login(email, password);
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

    private void login(String email, String password){
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressBar.setVisibility(View.GONE);
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(MainActivity.this, CitizenHomepage.class));
                            MDToast mdToast = MDToast.makeText(MainActivity.this, "Log In Successful", 3000, 1);
                            mdToast.show();

                        } else {
                            progressBar.setVisibility(View.GONE);
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            MDToast mdToast = MDToast.makeText(MainActivity.this, "Authentucation Failed", 2000, 3);
                            mdToast.show();
                        }
                    }
                });
    }

}

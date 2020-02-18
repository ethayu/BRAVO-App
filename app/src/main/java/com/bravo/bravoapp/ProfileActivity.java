package com.bravo.bravoapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    TextView pName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Profile");

        firebaseAuth = firebaseAuth.getInstance();
        pName = findViewById(R.id.pName);
    }

    private void checkUserStatus() {
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user == null) {
            startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            finish();
        } else {
            pName.setText(user.getEmail());
        }
    }

    @Override
    protected void onStart() {
        checkUserStatus();
        super.onStart();
    }
}

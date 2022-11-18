package com.sebastian.tasteit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sebastian.tasteit.R;

public class supportpage extends AppCompatActivity {
    Button btnFb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supportpage);
        bottomNavigation();

        btnFb =(Button) findViewById(R.id.btnFeedback);

        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(supportpage.this, "Feedback Reported", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);
        LinearLayout profileBtn=findViewById(R.id.profileBtn);
        LinearLayout supportBtn=findViewById(R.id.supportBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(supportpage.this,MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(supportpage.this,CartActivity.class));
            }
        });

        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(supportpage.this,supportpage.class));
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(supportpage.this,customer_profile.class));
            }
        });
    }
}
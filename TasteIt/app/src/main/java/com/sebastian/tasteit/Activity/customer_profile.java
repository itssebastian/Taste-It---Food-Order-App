package com.sebastian.tasteit.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sebastian.tasteit.R;

import java.util.ArrayList;
import java.util.HashMap;

public class customer_profile extends AppCompatActivity {
    private static final String PREFER_NAME = "Reg";
    EditText uname,mobile,pass,email,adrs;
    Button update;
    TextView logout;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);

        sharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);

        uname = (EditText) findViewById(R.id.fnamee);
        mobile = (EditText) findViewById(R.id.mobilenumber);
        email = (EditText) findViewById(R.id.emailID);
        adrs = (EditText) findViewById(R.id.address);
        logout =(TextView) findViewById(R.id.logoutt);


        String name = uname.getText().toString();
        String email_ = email.getText().toString();
        String adrs_ = adrs.getText().toString();
        String mobile_ = mobile.getText().toString();

        name= sharedPreferences.getString("Name", "");
        email_ = sharedPreferences.getString("Email","");
        adrs_ = sharedPreferences.getString("adrs","");
        mobile_=sharedPreferences.getString("mobile","");

        uname.setText(name);
        mobile.setText(mobile_);
        email.setText(email_);
        adrs.setText(adrs_);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(customer_profile.this, IntroActivity.class);
                startActivity(intent);
            }
        });

    }
}
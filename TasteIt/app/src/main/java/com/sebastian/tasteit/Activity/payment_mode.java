package com.sebastian.tasteit.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sebastian.tasteit.R;

import java.util.HashMap;

public class payment_mode extends AppCompatActivity {

    TextView OnlinePayment, CashPayment;
    String RandomUID, ChefID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_mode);
        CashPayment = (TextView) findViewById(R.id.cash);
        OnlinePayment = (TextView) findViewById(R.id.online);

        CashPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(payment_mode.this,after_ordered.class);
                startActivity(intent);
            }
        });

        OnlinePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(payment_mode.this, "This feature not available yet.", Toast.LENGTH_SHORT).show();
               /* Intent intent = new Intent(payment_mode.this,card_details.class);
                startActivity(intent);*/
            }
        });


    }
}
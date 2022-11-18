package com.sebastian.tasteit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sebastian.tasteit.R;

public class enter_address extends AppCompatActivity {
    Button adrsBtnGo;
    EditText localadrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_address);
        localadrs = (EditText) findViewById(R.id.LA);

        adrsBtnGo = findViewById(R.id.adrs_goBtn);
        adrsBtnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (localadrs.length()==0)
                {
                    Toast.makeText(enter_address.this, "Please enter a address", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(enter_address.this,payment_mode.class);
                    startActivity(intent);
                }

            }
        });
    }
}
package com.sebastian.tasteit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sebastian.tasteit.R;

public class profile_name extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_name);
        EditText personName,phoneNum;
        Button continueBtn;
        Vibrator Vibrator;
        Vibrator = (Vibrator)getSystemService(MainActivity.VIBRATOR_SERVICE);

        personName = findViewById(R.id.editTextPersonName);
        phoneNum = findViewById(R.id.editTextphoneNum);
        continueBtn = findViewById(R.id.continueBtn);


        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = personName.getText().toString();

                if (personName.getText().toString().length() == 0 || phoneNum.getText().toString().length() == 1){
                    Toast.makeText(profile_name.this, "Empty field not allowed!", Toast.LENGTH_SHORT).show();
                }
               else if (phoneNum.getText().toString().length() != 10){
                    Toast.makeText(profile_name.this, " Not Valid Num!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(profile_name.this, "Welcome !!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    //startActivity(new Intent(profile_name.this,MainActivity.class));
                    intent.putExtra("message_key",str);
                    startActivity(intent);

                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        vibrator.vibrate(200);
                    }

                }

            }
        });


    }
}
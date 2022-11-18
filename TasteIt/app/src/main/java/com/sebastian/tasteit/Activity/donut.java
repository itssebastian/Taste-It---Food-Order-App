package com.sebastian.tasteit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sebastian.tasteit.R;

public class donut extends AppCompatActivity {
    TextView addToCartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);
        addToCartBtn = (TextView) findViewById(R.id.addToCartBtndonut);
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(donut.this, "Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
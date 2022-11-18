package com.sebastian.tasteit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sebastian.tasteit.R;

public class hotdog extends AppCompatActivity {
    TextView addToCartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotdog);
        addToCartBtn = (TextView) findViewById(R.id.addToCartBtnhotdog);

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(hotdog.this, "Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package com.sebastian.tasteit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sebastian.tasteit.Domain.FoodDomain;
import com.sebastian.tasteit.Helper.ManagementCart;
import com.sebastian.tasteit.R;

public class burger extends AppCompatActivity {
    TextView addToCartBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger);
        addToCartBtn = (TextView) findViewById(R.id.addToCartBtnburger);

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(burger.this, "Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
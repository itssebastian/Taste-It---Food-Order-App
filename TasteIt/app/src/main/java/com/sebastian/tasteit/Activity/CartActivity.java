package com.sebastian.tasteit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.sebastian.tasteit.Adapter.CartListAdapter;
import com.sebastian.tasteit.Helper.ManagementCart;
import com.sebastian.tasteit.Interface.ChangeNumberItemListener;
import com.sebastian.tasteit.R;

public class CartActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart  managementCart;
    private TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt,checkout;
    private double tax;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        checkout=findViewById(R.id.checkoutBtn);

        managementCart=new ManagementCart(this);

        initView();
        initList();
        bottomNavigation();
        calculateCard();

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CartActivity.this, "Ohhhh Yeah !! Just one more Step ", Toast.LENGTH_SHORT).show();
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(200);
                }

                Intent intent = new Intent(getApplicationContext(),enter_address.class);
                startActivity(intent);
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
                startActivity(new Intent(CartActivity.this,MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this,CartActivity.class));
            }
        });

        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this,supportpage.class));
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this,customer_profile.class));
            }
        });
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter=new CartListAdapter(managementCart.getListCart(), this, new ChangeNumberItemListener() {
            @Override
            public void changed() {
                calculateCard();
            }
        });
        recyclerViewList.setAdapter(adapter);
        if(managementCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);

        }else{
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCard() {
        double percentTax = 0.02; //you can this item for tax price
        double delivery = 10; //you change this item you need price for delivery

        tax = Math.round((managementCart.getTotalFee() * percentTax) * 100.0) / 100.0;
        double total = Math.round((managementCart.getTotalFee() + tax + delivery) * 100.0) /100.0;
        double itemTotal = Math.round(managementCart.getTotalFee() * 100.0)/100.0;

        totalFeeTxt.setText("$"+itemTotal);
        taxTxt.setText("$"+tax);
        deliveryTxt.setText("$"+delivery);
        totalTxt.setText("$"+total);
    }

    private void initView() {
        totalFeeTxt=findViewById(R.id.totalFeeTxt);
        taxTxt=findViewById(R.id.taxTxt);
        deliveryTxt=findViewById(R.id.deliveryTxt);
        totalTxt=findViewById(R.id.totalTxt);
        recyclerViewList=findViewById(R.id.view);
        scrollView=findViewById(R.id.scrollView);
        emptyTxt=findViewById(R.id.emptyTxt);
    }

}
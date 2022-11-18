package com.sebastian.tasteit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sebastian.tasteit.Adapter.CategoryAdapter;
import com.sebastian.tasteit.Adapter.RecommendedAdapter;
import com.sebastian.tasteit.Domain.CategoryDomain;
import com.sebastian.tasteit.Domain.FoodDomain;
import com.sebastian.tasteit.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerInterface{
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
    TextView personnameDisplay;
    ImageView personImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personImg = (ImageView) findViewById(R.id.profileImg);

        personnameDisplay =findViewById(R.id.PersonNameDisplay);
        Intent intent = getIntent();
        //String str = intent.getStringExtra("message_key");
        personnameDisplay.setText("Hi Sebastian");

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();

        personImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,customer_profile.class));
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
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,customer_profile.class));
            }
        });

        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,supportpage.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });

    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Pepperoni pizza","pizza1","slices pepperoni , mozzarella cheese, fresh oregano, ground black pepper, pizza sauce",13.0,5,20,1000));
        foodlist.add(new FoodDomain("Cheese Burger","burger","beef,Gouda Cheese,Special sauce, Lettuce, tomato",15.20,4,16,1500));
        foodlist.add(new FoodDomain("Vegetable pizza","pizza3","olive oil , Vegetable oil , pitted Kalamata, cherry tomatoes, fresh oregano,basil",11.0,3,18,800));

        adapter2= new RecommendedAdapter(foodlist,this);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList = findViewById(R.id.view1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza","cat_1"));
        categoryList.add(new CategoryDomain("Burger","cat_2"));
        categoryList.add(new CategoryDomain("Hotdog","cat_3"));
        categoryList.add(new CategoryDomain("Drink","cat_4"));
        categoryList.add(new CategoryDomain("Donut","cat_5"));

        adapter = new CategoryAdapter(categoryList,this);
        recyclerViewCategoryList.setAdapter(adapter);


    }


    @Override
    public void onItemClick(int position) {

        switch(position){

            case 0:{
                Intent intent = new Intent(MainActivity.this,pizza.class);
                startActivity(intent);

                break;
            }
            case 1:{
                Intent intent = new Intent(MainActivity.this,burger.class);
                startActivity(intent);
                break;
            }
            case 2:{
                Intent intent = new Intent(MainActivity.this,hotdog.class);
                startActivity(intent);
                break;
            }
            case 3:{
                Intent intent = new Intent(MainActivity.this,drink.class);
                startActivity(intent);
                break;
            }
            case 4:{
                Intent intent = new Intent(MainActivity.this,donut.class);
                startActivity(intent);
                break;
            }
        }

    }

    @Override
    public void onItemClick2(int position) {

        switch(position){

            case 0:{
                Intent intent = new Intent(MainActivity.this,pizza.class);
                startActivity(intent);
                break;
            }
            case 1:{
                Intent intent = new Intent(MainActivity.this,burger.class);
                startActivity(intent);
                break;
            }
            case 2:{
                Intent intent = new Intent(MainActivity.this,vegetable_pizaa.class);
                startActivity(intent);
                break;

            }
        }

    }
}
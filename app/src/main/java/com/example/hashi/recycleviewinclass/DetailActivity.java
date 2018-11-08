package com.example.hashi.recycleviewinclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";
    private TextView tvDishName, tvDishPrice, tvDishCalories, tvDishRatings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDishName = findViewById(R.id.tvDishName);
        tvDishPrice = findViewById(R.id.tvPrice);
        tvDishCalories = findViewById(R.id.tvCalories);
        tvDishRatings = findViewById(R.id.tvRatings);

        Intent intent = getIntent();
        Food food = (Food) intent.getSerializableExtra("food");
        tvDishName.setText(food.getDishName());
        tvDishPrice.setText(String.valueOf(food.getPrice()));
        tvDishCalories.setText(String.valueOf(food.getCalories()));
        tvDishRatings.setText(String.valueOf(food.getRatings()));

        Log.d(TAG, "onCreate");
    }
}


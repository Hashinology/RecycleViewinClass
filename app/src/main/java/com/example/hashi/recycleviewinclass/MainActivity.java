package com.example.hashi.recycleviewinclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Food> foodList;
    private RecyclerView rvFoodList;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.ItemAnimator itemAnimator;
    private  FoodListAdapter foodListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodList = new ArrayList<>();
        rvFoodList = findViewById(R.id.rvFoodList);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rvFoodList.setLayoutManager(layoutManager);
        rvFoodList.setItemAnimator(itemAnimator);
        //Initialize the Adapter
        foodListAdapter = new FoodListAdapter(foodList);
        rvFoodList.setAdapter(foodListAdapter);

        initfoodList();
        foodListAdapter.notifyDataSetChanged();
    }

    private void initfoodList(){
        foodList.add(new Food("Burger", 12, 300, 4.5));
        foodList.add(new Food("Pizza", 34, 340, 4.9));
        foodList.add(new Food("Soup", 14, 500, 4.1));
        foodList.add(new Food("Fried Rice", 15, 600, 2.5));
    }
}

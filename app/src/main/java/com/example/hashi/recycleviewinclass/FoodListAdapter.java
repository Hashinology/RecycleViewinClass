package com.example.hashi.recycleviewinclass;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.List;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ViewHolder> {

    private static final String TAG = "FoodListAdaptor";
    private List<Food> foodList;
    private Context context;
    private int lastPosition = -1;

    public FoodListAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder");
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.foodlist_item,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(position > lastPosition){
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            animation.setInterpolator(context, android.R.interpolator.bounce);
            holder.itemView.startAnimation(animation);
        }
        Log.d(TAG, "onBindViewHolder");
        Food food = foodList.get(position);
        holder.tvDishName.setText(food.getDishName());
        holder.tvPrice.setText(String.valueOf(food.getPrice()));
        holder.tvCalories.setText(String.valueOf(food.getCalories()));
        holder.tvRatings.setText(String.valueOf(food.getRatings()));
        holder.itemView.setOnClickListener((view)->{
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("food", food);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        //
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDishName, tvCalories, tvPrice, tvRatings;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDishName = itemView.findViewById(R.id.tvFoodName);
            tvPrice = itemView.findViewById(R.id.tvFoodPrice);
            tvCalories = itemView.findViewById(R.id.tvFoodCalories);
            tvRatings = itemView.findViewById(R.id.tvFoodRatings);
        }
    }
}

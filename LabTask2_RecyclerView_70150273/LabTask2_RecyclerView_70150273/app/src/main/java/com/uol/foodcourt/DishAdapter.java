package com.uol.foodcourt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Adapter - writes each dish's data into its card (Scenario 1, Step 3)
// Also holds the click interface used in Scenario 2, Step 1
public class DishAdapter extends RecyclerView.Adapter<DishAdapter.ViewHolder> {

    // Interface that tells MainActivity which card was tapped
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private ArrayList<Dish> dishes;
    private OnItemClickListener listener;

    public DishAdapter(ArrayList<Dish> dishes, OnItemClickListener listener) {
        this.dishes = dishes;
        this.listener = listener;
    }

    // ViewHolder - keeps the card's views so they are found only once
    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivDishImage;
        TextView tvDishName;
        TextView tvDishPrice;

        public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            ivDishImage = itemView.findViewById(R.id.ivDishImage);
            tvDishName = itemView.findViewById(R.id.tvDishName);
            tvDishPrice = itemView.findViewById(R.id.tvDishPrice);

            // Report the tapped card's position to MainActivity
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(getBindingAdapterPosition());
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dish, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dish dish = dishes.get(position);
        holder.ivDishImage.setImageResource(dish.getImageResId());
        holder.tvDishName.setText(dish.getName());
        holder.tvDishPrice.setText("Rs. " + dish.getPrice());
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }
}

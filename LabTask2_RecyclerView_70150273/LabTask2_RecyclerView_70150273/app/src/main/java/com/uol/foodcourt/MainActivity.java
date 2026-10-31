package com.uol.foodcourt;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Menu screen - shows the grid of dishes and handles card taps
public class MainActivity extends AppCompatActivity
        implements DishAdapter.OnItemClickListener {

    private RecyclerView rvMenu;
    private ArrayList<Dish> dishes;
    private DishAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("UOL Food Court Menu");

        rvMenu = findViewById(R.id.rvMenu);

        // Data - at least eight dishes (Scenario 1, Step 4)
        dishes = new ArrayList<>();
        dishes.add(new Dish("Chicken Biryani", "Desi",
                "Spicy chicken biryani with raita and salad. Fresh and hot, made at the Desi stall.",
                "03011111111", 350, R.drawable.dish_biryani));
        dishes.add(new Dish("Zinger Burger", "Fast Food",
                "Crispy fried chicken burger with fries and a cold drink. Made at the Fast Food stall.",
                "03022222222", 450, R.drawable.dish_burger));
        dishes.add(new Dish("Chicken Tikka Pizza", "Pizza",
                "Small chicken tikka pizza with extra cheese and olives. Baked fresh at the Pizza stall.",
                "03033333333", 650, R.drawable.dish_pizza));
        dishes.add(new Dish("Alfredo Pasta", "Italian",
                "White sauce pasta with grilled chicken and garlic bread. Made at the Italian stall.",
                "03044444444", 550, R.drawable.dish_pasta));
        dishes.add(new Dish("Loaded Fries", "Snacks",
                "Fries loaded with cheese sauce, chicken pieces and jalapenos. Made at the Snacks stall.",
                "03055555555", 300, R.drawable.dish_fries));
        dishes.add(new Dish("Chicken Shawarma", "Shawarma",
                "Chicken shawarma with garlic sauce and fresh vegetables. Made at the Shawarma stall.",
                "03066666666", 250, R.drawable.dish_shawarma));
        dishes.add(new Dish("Club Sandwich", "Snacks",
                "Triple layer club sandwich with egg, chicken and fries. Made at the Snacks stall.",
                "03077777777", 400, R.drawable.dish_sandwich));
        dishes.add(new Dish("Chicken Karahi", "Desi",
                "Half chicken karahi with naan. Spicy desi taste, made at the Desi stall.",
                "03088888888", 700, R.drawable.dish_karahi));

        // Grid of two columns, adapter attached (Scenario 1, Step 4)
        adapter = new DishAdapter(dishes, this);
        rvMenu.setLayoutManager(new GridLayoutManager(this, 2));
        rvMenu.setAdapter(adapter);
    }

    // Called when any dish card is tapped (Scenario 2, Step 2)
    @Override
    public void onItemClick(int position) {
        Dish dish = dishes.get(position);

        Intent intent = new Intent(MainActivity.this, DishDetailActivity.class);
        intent.putExtra(DishDetailActivity.EXTRA_NAME, dish.getName());
        intent.putExtra(DishDetailActivity.EXTRA_CATEGORY, dish.getCategory());
        intent.putExtra(DishDetailActivity.EXTRA_DESCRIPTION, dish.getDescription());
        intent.putExtra(DishDetailActivity.EXTRA_PHONE, dish.getStallPhone());
        intent.putExtra(DishDetailActivity.EXTRA_PRICE, dish.getPrice());
        intent.putExtra(DishDetailActivity.EXTRA_IMAGE, dish.getImageResId());
        startActivity(intent);
    }
}

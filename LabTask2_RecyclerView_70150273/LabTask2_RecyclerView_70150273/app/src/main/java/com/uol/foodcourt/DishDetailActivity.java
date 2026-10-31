package com.uol.foodcourt;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// Details screen - shows only the tapped dish (Scenario 2, Step 3 and 4)
public class DishDetailActivity extends AppCompatActivity {

    // Public key constants for the data carried by the Intent
    public static final String EXTRA_NAME = "dish_name";
    public static final String EXTRA_CATEGORY = "dish_category";
    public static final String EXTRA_DESCRIPTION = "dish_description";
    public static final String EXTRA_PHONE = "dish_phone";
    public static final String EXTRA_PRICE = "dish_price";
    public static final String EXTRA_IMAGE = "dish_image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_detail);

        ImageView ivDetailImage = findViewById(R.id.ivDetailImage);
        TextView tvDetailName = findViewById(R.id.tvDetailName);
        TextView tvDetailCategory = findViewById(R.id.tvDetailCategory);
        TextView tvDetailPrice = findViewById(R.id.tvDetailPrice);
        TextView tvDetailDescription = findViewById(R.id.tvDetailDescription);
        Button btnCallToOrder = findViewById(R.id.btnCallToOrder);

        // Read the values sent by MainActivity
        String name = getIntent().getStringExtra(EXTRA_NAME);
        String category = getIntent().getStringExtra(EXTRA_CATEGORY);
        String description = getIntent().getStringExtra(EXTRA_DESCRIPTION);
        final String stallPhone = getIntent().getStringExtra(EXTRA_PHONE);
        int price = getIntent().getIntExtra(EXTRA_PRICE, 0);
        int imageResId = getIntent().getIntExtra(EXTRA_IMAGE, R.drawable.dish_biryani);

        // Show the tapped dish only
        ivDetailImage.setImageResource(imageResId);
        tvDetailName.setText(name);
        tvDetailCategory.setText(category);
        tvDetailPrice.setText("Rs. " + price);
        tvDetailDescription.setText(description);
        setTitle(name);

        // Open the dialer with this dish's stall number only
        btnCallToOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_DIAL,
                            Uri.parse("tel:" + stallPhone));
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(DishDetailActivity.this,
                            "No dialer app found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

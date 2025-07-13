package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    private int quantity = 1; // Khởi tạo số lượng mặc định

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ImageView imageView = findViewById(R.id.product_image);
        TextView nameView = findViewById(R.id.product_name);
        TextView priceView = findViewById(R.id.product_price);
        TextView quantityView = findViewById(R.id.product_quantity);
        TextView descriptionView = findViewById(R.id.product_description);

        // Lấy dữ liệu từ Intent
        int imageResId = getIntent().getIntExtra("image", 0);
        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        String description = getIntent().getStringExtra("description");

        // Thiết lập dữ liệu vào các view
        if (imageResId != 0) {
            imageView.setImageResource(imageResId);
        }
        nameView.setText(name);
        priceView.setText(price);
        quantityView.setText(String.valueOf(quantity));
        descriptionView.setText(description);

        // Nút quay lại
        Button btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(v -> finish());

        // Tăng/giảm số lượng
        Button increaseButton = findViewById(R.id.increase_quantity);
        Button decreaseButton = findViewById(R.id.decrease_quantity);

        increaseButton.setOnClickListener(v -> {
            quantity++;
            quantityView.setText(String.valueOf(quantity));
        });

        decreaseButton.setOnClickListener(v -> {
            if (quantity > 1) {
                quantity--;
                quantityView.setText(String.valueOf(quantity));
            }
        });

        // Thêm vào giỏ
        Button addToCart = findViewById(R.id.add_to_cart);
        addToCart.setOnClickListener(v -> {
            Intent intent = new Intent(ProductDetailActivity.this, CartActivity.class);
            intent.putExtra("image", imageResId);
            intent.putExtra("name", name);
            intent.putExtra("price", price);
            intent.putExtra("quantity", String.valueOf(quantity));
            startActivity(intent);
        });

        // Thanh toán
        Button payButton = findViewById(R.id.pay_button);
        payButton.setOnClickListener(v -> {
            Intent payIntent = new Intent(ProductDetailActivity.this, PaymentActivity.class);
            payIntent.putExtra("image", imageResId);
            payIntent.putExtra("name", name);
            payIntent.putExtra("price", price);
            payIntent.putExtra("quantity", String.valueOf(quantity));
            startActivity(payIntent);
        });
    }
}

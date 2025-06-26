package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        int image = intent.getIntExtra("image", 0);
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");
        String quantity = intent.getStringExtra("quantity");

        // Ánh xạ view
        ImageView imageView = findViewById(R.id.payment_image);
        TextView nameView = findViewById(R.id.payment_name);
        TextView priceView = findViewById(R.id.payment_price);
        TextView quantityView = findViewById(R.id.payment_quantity);

        // Gán dữ liệu
        imageView.setImageResource(image);
        nameView.setText(name);
        priceView.setText("Giá: " + price);
        quantityView.setText("Số lượng: " + quantity);
    }
}

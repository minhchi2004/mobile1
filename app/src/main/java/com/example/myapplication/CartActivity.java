package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        int image = intent.getIntExtra("image", 0);
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");
        String quantity = intent.getStringExtra("quantity");

        // Ánh xạ View
        ImageView imageView = findViewById(R.id.item_image_1);
        TextView nameView = findViewById(R.id.item_name_1);
        TextView priceView = findViewById(R.id.item_price_1);
        TextView quantityView = findViewById(R.id.item_quantity_1);
        LinearLayout itemContainer = findViewById(R.id.item_1_container);
        Button checkoutBtn = findViewById(R.id.btn_checkout_1);
        Button deleteBtn = findViewById(R.id.btn_delete_1);
        Button btnBack = findViewById(R.id.btn_back);

        // Gán dữ liệu
        imageView.setImageResource(image);
        nameView.setText(name);
        priceView.setText("Giá: " + price);
        quantityView.setText("Số lượng: " + quantity);

        // Xử lý nút Thanh toán
        checkoutBtn.setOnClickListener(v -> {
            Intent checkoutIntent = new Intent(CartActivity.this, PaymentActivity.class);
            checkoutIntent.putExtra("image", image);
            checkoutIntent.putExtra("name", name);
            checkoutIntent.putExtra("price", price);
            checkoutIntent.putExtra("quantity", quantity);
            startActivity(checkoutIntent);
        });

        // Xử lý nút Xóa
        deleteBtn.setOnClickListener(v -> {
            itemContainer.setVisibility(View.GONE);
            Toast.makeText(CartActivity.this, "Đã xóa sản phẩm khỏi giỏ", Toast.LENGTH_SHORT).show();
        });

        // Nút quay lại
        btnBack.setOnClickListener(v -> {
            Intent backIntent = new Intent(CartActivity.this, ProductDetailActivity.class);
            backIntent.putExtra("image", image);
            backIntent.putExtra("name", name);
            backIntent.putExtra("price", price);
            backIntent.putExtra("quantity", quantity);
            startActivity(backIntent);
        });
    }
}

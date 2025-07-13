package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
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
        int imageResId     = intent.getIntExtra("image", 0);
        String name        = intent.getStringExtra("name");
        String price       = intent.getStringExtra("price");
        String quantity    = intent.getStringExtra("quantity");
        String description = intent.getStringExtra("description"); // nếu có mô tả

        // Ánh xạ view
        ImageView tickIcon     = findViewById(R.id.payment_icon);   // dấu tick ✔
        ImageView productImage = findViewById(R.id.payment_image);  // ảnh sản phẩm
        TextView nameView      = findViewById(R.id.payment_name);
        TextView priceView     = findViewById(R.id.payment_price);
        TextView quantityView  = findViewById(R.id.payment_quantity);
        Button buyAgainButton  = findViewById(R.id.btn_buy_again);

        // Gán dữ liệu
        if (imageResId != 0) {
            productImage.setImageResource(imageResId); // Ảnh sản phẩm
        }

        nameView.setText(name != null ? "Tên sản phẩm: " + name : "Tên sản phẩm không có");
        priceView.setText(price != null ? "Giá: " + price : "Giá không có");
        quantityView.setText(quantity != null ? "Số lượng: " + quantity : "Số lượng không có");

        // Sự kiện: Mua lại → quay lại ProductDetailActivity với dữ liệu sản phẩm
        buyAgainButton.setOnClickListener(v -> {
            Intent detailIntent = new Intent(PaymentActivity.this, ProductDetailActivity.class);
            detailIntent.putExtra("image", imageResId);
            detailIntent.putExtra("name", name);
            detailIntent.putExtra("price", price);
            detailIntent.putExtra("quantity", quantity);
            detailIntent.putExtra("description", description);
            startActivity(detailIntent);
            finish(); // Đóng PaymentActivity
        });
    }
}

package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class ProductDetailActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ImageView imageView = findViewById(R.id.product_image);
        TextView nameView = findViewById(R.id.product_name);

        // Lấy dữ liệu từ Intent
        int imageResId = getIntent().getIntExtra("image", 0);
        String name = getIntent().getStringExtra("name");

        imageView.setImageResource(imageResId);
        nameView.setText(name);
        Button btnLogin = findViewById(R.id.back);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(b);
            }
        });
        // ✅ Thêm xử lý nút "Thêm vào giỏ hàng" TẠI ĐÂY
        Button addToCart = findViewById(R.id.add_to_cart);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailActivity.this, CartActivity.class);
                intent.putExtra("image", imageResId);
                intent.putExtra("name", name);
                intent.putExtra("price", "200.000đ"); // Tạm cứng
                intent.putExtra("quantity", "1");     // Tạm cứng
                startActivity(intent);
            }

        });

    }

}

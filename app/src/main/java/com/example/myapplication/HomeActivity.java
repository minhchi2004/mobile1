package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Thiết lập sự kiện cho từng sản phẩm
        setupProduct(R.id.category1, R.id.name1, "Váy trễ vai lông body", R.drawable.minhchi1, R.id.add_to_cart1, "200.000đ", "1", "Mô tả sản phẩm 1");
        setupProduct(R.id.category2, R.id.name2, "Set áo chun quây gân tăm kèm quần", R.drawable.minhchi2, R.id.add_to_cart2, "300.000đ", "1", "Mô tả sản phẩm 2");
        setupProduct(R.id.category3, R.id.name3, "Áo 2 dây nữ thời trang", R.drawable.minhchi3, R.id.add_to_cart3, "150.000đ", "1", "Mô tả sản phẩm 3");
        setupProduct(R.id.category4, R.id.name4, "Váy body dài tay nữ tính", R.drawable.minhchi4, R.id.add_to_cart4, "250.000đ", "1", "Mô tả sản phẩm 4");

        // Link đến giỏ hàng
        ImageView btnBack = findViewById(R.id.cart_icon);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), CartActivity.class);
            startActivity(intent);
        });
    }

    private void setupProduct(int imageViewId, int textViewId, String productName, int imageResId, int addToCartId, String price, String quantity, String description) {
        ImageView categoryImage = findViewById(imageViewId);
        TextView nameText = findViewById(textViewId);
        ImageView addToCart = findViewById(addToCartId);

        // Mở chi tiết sản phẩm khi nhấp vào hình ảnh hoặc tên sản phẩm
        categoryImage.setOnClickListener(v -> openProductDetail(productName, imageResId, price, quantity, description));
        nameText.setOnClickListener(v -> openProductDetail(productName, imageResId, price, quantity, description));

        // Thêm vào giỏ hàng
        addToCart.setOnClickListener(v -> addToCart(productName, imageResId, price, quantity));
    }

    private void openProductDetail(String productName, int imageResId, String price, String quantity, String description) {
        Intent intent = new Intent(HomeActivity.this, ProductDetailActivity.class);
        intent.putExtra("image", imageResId);
        intent.putExtra("name", productName);
        intent.putExtra("price", price);
        intent.putExtra("quantity", quantity);
        intent.putExtra("description", description);
        startActivity(intent);
    }

    private void addToCart(String productName, int imageResId, String price, String quantity) {
        // Logic thêm vào giỏ hàng (có thể thêm vào CartActivity)
        Intent intent = new Intent(HomeActivity.this, CartActivity.class);
        intent.putExtra("image", imageResId);
        intent.putExtra("name", productName);
        intent.putExtra("price", price);
        intent.putExtra("quantity", quantity);
        startActivity(intent);
        Toast.makeText(this, productName + " đã được thêm vào giỏ hàng!", Toast.LENGTH_SHORT).show();
    }

}

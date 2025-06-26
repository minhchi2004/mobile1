package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.ImageView;
import android.widget.TextView;

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
            v.setPadding(0, systemBars.top, 0, 0);
            return insets;
        });

        ImageView category1 = findViewById(R.id.category1);
        TextView name1 = findViewById(R.id.name1);
        // Sự kiện cho hình ảnh

        category1.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProductDetailActivity.class);
            intent.putExtra("image", R.drawable.minhchi1);
            intent.putExtra("name", "Váy trễ vai lông body ");
            startActivity(intent);
        });
        // Sự kiện cho chữ
        name1.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProductDetailActivity.class);
            intent.putExtra("image", R.drawable.minhchi1);
            intent.putExtra("name", "Váy trễ vai lông body");
            startActivity(intent);
        });

        ImageView category2 = findViewById(R.id.category2);
        TextView name2 = findViewById(R.id.name2);
        // Sự kiện cho hình ảnh

        category2.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProductDetailActivity.class);
            intent.putExtra("image", R.drawable.minhchi2);
            intent.putExtra("name", "Set áo chun quây gân tăm kèm quần");
            startActivity(intent);
        });
        // Sự kiện cho chữ
        name2.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProductDetailActivity.class);
            intent.putExtra("image", R.drawable.minhchi2);
            intent.putExtra("name", "Set áo chun quây gân tăm kèm quần");
            startActivity(intent);
        });

        ImageView category3 = findViewById(R.id.category3);
        TextView name3 = findViewById(R.id.name3);
        // Sự kiện cho hình ảnh

        category3.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProductDetailActivity.class);
            intent.putExtra("image", R.drawable.minhchi3);
            intent.putExtra("name", "Áo 2 dây nữ thời trang");
            startActivity(intent);
        });
        // Sự kiện cho chữ
        name3.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProductDetailActivity.class);
            intent.putExtra("image", R.drawable.minhchi3);
            intent.putExtra("name", "Áo 2 dây nữ thời trang");
            startActivity(intent);
        });

        ImageView category4 = findViewById(R.id.category4);
        TextView name4 = findViewById(R.id.name4);
        // Sự kiện cho hình ảnh

        category4.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProductDetailActivity.class);
            intent.putExtra("image", R.drawable.minhchi4);
            intent.putExtra("name", "Váy body dài tay nữ tính");
            startActivity(intent);
        });
        // Sự kiện cho chữ
        name4.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProductDetailActivity.class);
            intent.putExtra("image", R.drawable.minhchi4);
            intent.putExtra("name", "Váy body dài tay nữ tính");
            startActivity(intent);
        });
        // link gio hang
        ImageView btnBack = findViewById(R.id.cart_icon);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(), CartActivity.class);
                startActivity(b);
            }
        });


//        Button btnLogin = findViewById(R.id.btnBack);
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent b = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(b);
//            }
//        });

    }
}
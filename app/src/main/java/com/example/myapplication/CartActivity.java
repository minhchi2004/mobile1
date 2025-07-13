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

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private LinearLayout cartContainer;
    private ArrayList<Product> cartProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);

        cartContainer = findViewById(R.id.cart_container);
        cartProducts = new ArrayList<>();

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");
        String quantity = intent.getStringExtra("quantity");
        int image = intent.getIntExtra("image", 0);

        // Thêm sản phẩm vào giỏ hàng
        addProductToCart(name, price, quantity, image);

        // Nút quay lại
        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());
    }

    private void addProductToCart(String name, String price, String quantity, int image) {
        Product product = new Product(name, image, price, quantity);
        cartProducts.add(product);
        updateCartUI();
    }

    private void updateCartUI() {
        cartContainer.removeAllViews();

        for (Product product : cartProducts) {
            View itemView = getLayoutInflater().inflate(R.layout.cart_item_layout, cartContainer, false);

            ImageView itemImage = itemView.findViewById(R.id.item_image);
            TextView itemName = itemView.findViewById(R.id.item_name);
            TextView itemPrice = itemView.findViewById(R.id.item_price);
            TextView itemQuantity = itemView.findViewById(R.id.item_quantity);
            Button checkoutBtn = itemView.findViewById(R.id.btn_checkout);
            Button deleteBtn = itemView.findViewById(R.id.btn_delete);

            // Gán dữ liệu
            itemImage.setImageResource(product.getImageResId());
            itemName.setText(product.getName());
            itemPrice.setText("Giá: " + product.getPrice());
            itemQuantity.setText("Số lượng: " + product.getQuantity());

            // Xử lý nút Thanh toán
            checkoutBtn.setOnClickListener(v -> {
                Intent checkoutIntent = new Intent(CartActivity.this, PaymentActivity.class);
                checkoutIntent.putExtra("image", product.getImageResId());
                checkoutIntent.putExtra("name", product.getName());
                checkoutIntent.putExtra("price", product.getPrice());
                checkoutIntent.putExtra("quantity", product.getQuantity());
                startActivity(checkoutIntent);
            });

            // Xử lý nút Xóa
            deleteBtn.setOnClickListener(v -> {
                cartProducts.remove(product);
                updateCartUI();
                Toast.makeText(CartActivity.this, "Đã xóa sản phẩm khỏi giỏ", Toast.LENGTH_SHORT).show();
            });

            cartContainer.addView(itemView);
        }
    }
}
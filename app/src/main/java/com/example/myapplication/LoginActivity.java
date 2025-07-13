package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(v -> {
            Intent b = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(b);
        });

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            EditText objPhone = findViewById(R.id.editTextPhone);
            String txtPhone = objPhone.getText().toString().trim();

            EditText objPass = findViewById(R.id.editTextNumberPassword);
            String txtPass = objPass.getText().toString().trim();

            if (txtPhone.isEmpty() || txtPass.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter both fields", Toast.LENGTH_LONG).show();
            } else if (txtPass.equals("123") && txtPhone.equals("130504")) {
                Intent it = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(it);
            } else {
                Toast.makeText(getApplicationContext(), "Login failed. Please check your credentials.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
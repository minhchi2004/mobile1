package com.example.myapplication; // Thay đổi theo package của bạn

public class Product {
    private String name;       // Tên sản phẩm
    private int imageResId;   // ID tài nguyên hình ảnh
    private String price;      // Giá sản phẩm
    private String quantity;   // Số lượng sản phẩm

    // Constructor để khởi tạo đối tượng Product
    public Product(String name, int imageResId, String price, String quantity) {
        this.name = name;
        this.imageResId = imageResId;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter methods để lấy thông tin sản phẩm
    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }
}
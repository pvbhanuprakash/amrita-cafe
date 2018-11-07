package com.example.venug.amritacafe.Model;

/**
 * Created by venug on 06/11/2018.
 */

public class Order {
    private String ProductName;
    private String Productimg;
    private String Productmenu;
    private String Quantity;
    private String Productprice;

    public Order() {
    }

    public Order(String productName, String productimg, String productmenu, String quantity, String productprice) {
        ProductName = productName;
        Productimg = productimg;
        Productmenu = productmenu;
        Quantity = quantity;
        Productprice = productprice;
    }


    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductimg() {
        return Productimg;
    }

    public void setProductimg(String productimg) {
        Productimg = productimg;
    }

    public String getProductmenu() {
        return Productmenu;
    }

    public void setProductmenu(String productmenu) {
        Productmenu = productmenu;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getProductprice() {
        return Productprice;
    }

    public void setProductprice(String productprice) {
        Productprice = productprice;
    }
}

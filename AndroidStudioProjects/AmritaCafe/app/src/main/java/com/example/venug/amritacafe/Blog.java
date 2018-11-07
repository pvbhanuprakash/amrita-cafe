package com.example.venug.amritacafe;

/**
 * Created by venug on 04/11/2018.
 */

public class Blog {
    private String Fname;
    private String Fprice;
    private String Menuid;
    private String Imgid;

    public Blog() {
    }

    public Blog(String fname, String fprice, String menuid, String imgid) {
        Fname = fname;
        Fprice = fprice;
        Menuid = menuid;
        Imgid = imgid;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getFprice() {
        return Fprice;
    }

    public void setFprice(String fprice) {
        Fprice = fprice;
    }

    public String getMenuid() {
        return Menuid;
    }

    public void setMenuid(String menuid) {
        Menuid = menuid;
    }

    public String getImgid() {
        return Imgid;
    }

    public void setImgid(String imgid) {
        Imgid = imgid;
    }
}

package com.example.venug.amritacafe.Model;

/**
 * Created by venug on 04/11/2018.
 */

public class Blog {
    private String Fname;
    private String Fimgid;
    private String Fprice;
    private String Fmenuid;

    public Blog() {
    }

    public Blog(String fname, String fimgid, String fprice, String fmenuid) {
        Fname = fname;
        Fimgid = fimgid;
        Fprice = fprice;
        Fmenuid = fmenuid;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getFimgid() {
        return Fimgid;
    }

    public void setFimgid(String fimgid) {
        Fimgid = fimgid;
    }

    public String getFprice() {
        return Fprice;
    }

    public void setFprice(String fprice) {
        Fprice = fprice;
    }

    public String getFmenuid() {
        return Fmenuid;
    }

    public void setFmenuid(String fmenuid) {
        Fmenuid = fmenuid;
    }
}


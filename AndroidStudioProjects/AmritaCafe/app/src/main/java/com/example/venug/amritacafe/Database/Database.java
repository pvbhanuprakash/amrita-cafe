package com.example.venug.amritacafe.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.venug.amritacafe.Model.Order;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import java.util.List;
import java.util.ArrayList;

import java.lang.String;
/**
 * Created by venug on 06/11/2018.
 */

public class Database extends SQLiteAssetHelper{
    private static final String DB_NAME="AmritaCafeDB.db";
    private static final int DB_VER=1;
     public Database(Context context)
     {
        super(context, DB_NAME,null, DB_VER);
     }
    public List<Order> getCarts()
    {
        SQLiteDatabase db=getReadableDatabase();
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();
        String[] sqlSelect={"ProductName","Productimg","Productmenu","Quantity","Productprice"};
        String sqlTable="OrderDetail";

        qb.setTables(sqlTable);
        Cursor c=qb.query(db,sqlSelect,null,null,null,null,null);


        final List<Order> result =new ArrayList<>();
        if (c.moveToFirst())
        {
           while(c.moveToNext())
            {
                result.add(new Order(
                        c.getString(c.getColumnIndex("Quantity")+1),
                        c.getString(c.getColumnIndex("ProductName")+1),
                        c.getString(c.getColumnIndex("Productimg")+1),
                        c.getString(c.getColumnIndex("Productmenu")+1),
                        c.getString(c.getColumnIndex("Productprice")+1)
                ));
            }
        }
        return result;
     }


     public void addToCart(Order order)
     {
         SQLiteDatabase db=getReadableDatabase();
         db.execSQL("CREATE TABLE IF NOT EXISTS OrderDetail(ProductName VARCHAR,Productimg VARCHAR,Productmenu VARCHAR,Quantity VARCHAR,ProductPrice VARCHAR)");
         String query=String.format("INSERT INTO OrderDetail(ProductName,Productimg,Productmenu,Quantity,Productprice) VALUES('%s','%s','%s','%s','%s');",
                 order.getProductName(),
                 order.getProductimg(),
                 order.getProductmenu(),
                 order.getQuantity(),
                 order.getProductprice());
         db.execSQL(query);
     }

    public void cleanCart()
    {
        SQLiteDatabase db=getReadableDatabase();
        String query=String.format("DELETE FROM OrderDetail");
        db.execSQL(query);
    }
 }

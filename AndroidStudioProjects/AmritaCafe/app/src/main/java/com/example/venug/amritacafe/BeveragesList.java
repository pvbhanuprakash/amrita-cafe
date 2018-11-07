package com.example.venug.amritacafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.venug.amritacafe.Interface.ItemClickListener;
import com.example.venug.amritacafe.ViewHolder.FoodViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class BeveragesList extends AppCompatActivity {

    private RecyclerView mBlogList;
    private DatabaseReference mdatabase;
    String menuid="";
    FirebaseRecyclerAdapter<Blog,BlogViewHolder> firebaseRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverages_list);

        mdatabase= FirebaseDatabase.getInstance().getReference().child("Food");
        mdatabase.keepSynced(true);


        FloatingActionButton fab;
        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(BeveragesList.this,Cart.class);
                startActivity(i);

            }
        });
        mBlogList=(RecyclerView)findViewById(R.id.myrecyclerview) ;
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(this));

        if (getIntent()!=null)
            menuid =getIntent().getStringExtra("Menuid");
        if (!menuid.isEmpty() && menuid!=null)
        {
            onStart(menuid);
        }
    }


    protected void onStart(String menuid) {
        super.onStart();


        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Blog, BlogViewHolder>
                (Blog.class,R.layout.blog_row,BlogViewHolder.class,mdatabase.orderByChild("Menuid").equalTo(menuid)) {
            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, Blog model, int position) {
                    viewHolder.setFname(model.getFname());
                    viewHolder.setFprice(model.getFprice());
                    viewHolder.setImgid(getApplicationContext(), model.getImgid());
                    viewHolder.setMenuid(model.getMenuid());

                    viewHolder.setItemClickListener(new ItemClickListener() {
                        @Override
                        public void onClick(View v, int position, boolean isLongClick) {
                            Intent foodlist =new Intent(BeveragesList.this,FoodDetail.class);
                            foodlist.putExtra("Fname",firebaseRecyclerAdapter.getRef(position).getKey());
                            startActivity(foodlist);
                        }
                    });
            }
        };

        mBlogList.setAdapter(firebaseRecyclerAdapter);

    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        public TextView post_title,sample,post_price;
        public ImageView post_image;
        View mView;
        private ItemClickListener itemClickListener;
        public BlogViewHolder(View itemView)
        {
            super(itemView);
            mView=itemView;
            TextView post_title=(TextView)mView.findViewById(R.id.post_title);
            TextView post_price=(TextView)mView.findViewById(R.id.post_price);
            TextView sample=(TextView)mView.findViewById(R.id.sample);
            ImageView post_image=(ImageView)mView.findViewById(R.id.post_image);

            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public void setFname(String Fname)
        {
            TextView post_title=(TextView)mView.findViewById(R.id.post_title);
            post_title.setText(Fname);
        }
        public void setFprice(String Fprice)
        {
            TextView post_price=(TextView)mView.findViewById(R.id.post_price);
            post_price.setText(Fprice);
        }
        public void setMenuid(String Menuid)
        {
            TextView sample=(TextView)mView.findViewById(R.id.sample);
            sample.setText(Menuid);
        }
        public void setImgid(Context ctx,String Imgid)
        {
            ImageView post_image=(ImageView)mView.findViewById(R.id.post_image);
            Picasso.with(ctx).load(Imgid).into(post_image);
        }

        @Override
        public void onClick(View v) {

        itemClickListener.onClick(v,getAdapterPosition(),false);
    }


    }
}

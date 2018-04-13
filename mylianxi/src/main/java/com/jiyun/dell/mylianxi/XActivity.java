package com.jiyun.dell.mylianxi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class XActivity extends AppCompatActivity {

    private ImageView imgx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x);
        initView();
    }

    private void initView() {
        imgx = (ImageView) findViewById(R.id.imgx);
        Intent intent = getIntent();
        int img1 = intent.getIntExtra("img", 0);
        Glide.with(this).load(img1).into(imgx);

    }
}

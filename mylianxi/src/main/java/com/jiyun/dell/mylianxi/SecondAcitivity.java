package com.jiyun.dell.mylianxi;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class SecondAcitivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout fragment;
    private LinearLayout ll;
    private NavigationView nav;
    private Button button1;
    private Button button2;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acitivity);
        initView();
        initData();
    }

    private void initData() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment, new AFragment());
        fragmentTransaction.commit();
    }

    private void initView() {
        fragment = (FrameLayout) findViewById(R.id.fragment);
        ll = (LinearLayout) findViewById(R.id.ll);
        nav = (NavigationView) findViewById(R.id.nav);
        nav.findViewById(R.id.img1);
        nav.findViewById(R.id.img2);
        nav.findViewById(R.id.img3);
        nav.findViewById(R.id.img4);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new AFragment());
                fragmentTransaction.commit();


                break;
            case R.id.button2:
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.fragment, new BFragment());
                fragmentTransaction1.commit();
                break;
        }
    }
}

package com.example.administrator.baseapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TwoActivity extends BaseActivity {

    NavigationView navigation_view;
    String text;
    TextView textbutton;
    ImageView ImageView;
    FloatingActionButton floatbutton;

    @Override
    public void widgetClick(View v) {

        switch (v.getId()) {
            case R.id.text:
                textbutton.setText(text);
                break;
            case R.id.image:
                showToast("图片");
                break;
            case R.id.floatbutton:
                break;
        }
    }

    @Override
    public void initParms(Bundle parms) {

        setSteepStatusBar(false);
        setAllowFullScreen(false);
        setScreenRoate(false);

        parms = getIntent().getExtras();
        text = parms.getString("key");
    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_two;
    }

    @Override
    public void initView(View view) {

        navigation_view = (NavigationView) findViewById(R.id.navigation_view);
        textbutton = (TextView) findViewById(R.id.text);
        floatbutton = (FloatingActionButton) findViewById(R.id.floatbutton);

        View HeadView = navigation_view.getHeaderView(0);
        ImageView = (android.widget.ImageView) HeadView.findViewById(R.id.image);
        navigation_view.setItemIconTintList(null);

    }

    @Override
    public void setListener() {

        textbutton.setOnClickListener(this);
        ImageView.setOnClickListener(this);
        floatbutton.setOnClickListener(this);
        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                showToast(String.valueOf(item));
                return false;
            }
        });
    }

    @Override
    public void doBusiness(Context mContext) {


    }
}

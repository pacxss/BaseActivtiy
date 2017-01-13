package com.example.administrator.baseapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends BaseActivity {

    EditText edittext;
    Button click;
    LinearLayout left;
    LinearLayout right;
    FloatingActionButton floatingActionButton;

    /**
     * 是否沉浸状态栏
     **/
    private boolean isSetStatusBar;
    /**
     * 是否允许全屏
     **/
    private boolean mAllowFullScreen;
    /**
     * 是否禁止旋转屏幕
     **/
    private boolean isAllowScreenRoate;

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.click:
                if (verifyClickTime() == true)
                    closeInputMethod();
                else
                    showToast("太快啦");
                break;
            case R.id.floatbutton:
                Bundle bundle = new Bundle();
                bundle.putString("key", "跳转");
                startActivity(TwoActivity.class, bundle);
                break;
        }
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {

        click = (Button) findViewById(R.id.click);
        edittext = (EditText) findViewById(R.id.edittext);
        left = (LinearLayout) findViewById(R.id.left);
        right = (LinearLayout) findViewById(R.id.right);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatbutton);

    }

    @Override
    public void setListener() {

        click.setOnClickListener(this);
        floatingActionButton.setOnClickListener(this);
    }

    @Override
    public void doBusiness(Context mContext) {

        setAllowFullScreen(true);

    }
}

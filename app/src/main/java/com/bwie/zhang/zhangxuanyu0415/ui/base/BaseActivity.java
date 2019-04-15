package com.bwie.zhang.zhangxuanyu0415.ui.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by 可乐 on 2019/4/15.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContent());
        initView();
        if(isConnect(this)){
            initData();
        }else{
            Toast.makeText(this,"网络不可用",Toast.LENGTH_SHORT).show();
        }

    }
    /**
     * 初始化View
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 填充布局
     * @return
     */
    public abstract int getContent();

    public static boolean isConnect(Context context) {
        boolean isConnect = false;
        ConnectivityManager conManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = conManager.getActiveNetworkInfo();
        if (network != null) {
            isConnect = conManager.getActiveNetworkInfo().isAvailable();
        }
        return isConnect;
    }
}

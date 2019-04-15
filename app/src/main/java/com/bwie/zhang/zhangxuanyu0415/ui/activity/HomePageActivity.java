package com.bwie.zhang.zhangxuanyu0415.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.zhang.zhangxuanyu0415.R;
import com.bwie.zhang.zhangxuanyu0415.data.bean.DengBean;
import com.bwie.zhang.zhangxuanyu0415.di.contrant.Contrant;
import com.bwie.zhang.zhangxuanyu0415.di.presenter.IDengPresenterImpl;
import com.bwie.zhang.zhangxuanyu0415.ui.activity.MainActivity;
import com.bwie.zhang.zhangxuanyu0415.ui.activity.ZhuceActivity;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 可乐 on 2019/4/15.
 */

public class HomePageActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }
}

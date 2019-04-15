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
import com.bwie.zhang.zhangxuanyu0415.data.bean.ZhuceBean;
import com.bwie.zhang.zhangxuanyu0415.di.contrant.ZhuCeContrant;
import com.bwie.zhang.zhangxuanyu0415.di.presenter.IZheCePresenterImpl;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 可乐 on 2019/4/15.
 */

public class ZhuceActivity extends AppCompatActivity implements ZhuCeContrant.IZhuCerView {
    @BindView(R.id.zc_ed_sj)
    EditText zcEdSj;
    @BindView(R.id.zc_ed_pwd)
    EditText zcEdPwd;
    @BindView(R.id.text_dl)
    TextView textDl;
    @BindView(R.id.btn_dl)
    Button btnDl;
    private ZhuCeContrant.IZhuCePresenter presenter;
    private ZhuceBean zhuceBean;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        ButterKnife.bind(this);
        presenter = new IZheCePresenterImpl();
        presenter.attahView(this);
    }

    @OnClick({R.id.text_dl, R.id.btn_dl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_dl:
                Intent intent = new Intent(ZhuceActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btn_dl:
                String userName = zcEdSj.getText().toString();
                String pwd = zcEdPwd.getText().toString();
                presenter.requestData(userName , pwd);
                break;
        }
    }

    @Override
    public void showData(final String response) {
        gson = new Gson();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                zhuceBean = gson.fromJson(response, ZhuceBean.class);
                Toast.makeText(ZhuceActivity.this, zhuceBean.getMessage(), Toast.LENGTH_SHORT).show();

                if (zhuceBean.getStatus().equals("0000")) {
                    Intent intent = new Intent(ZhuceActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(this);
    }
}

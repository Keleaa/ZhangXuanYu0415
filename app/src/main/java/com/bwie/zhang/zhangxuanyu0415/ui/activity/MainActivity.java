package com.bwie.zhang.zhangxuanyu0415.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.zhang.zhangxuanyu0415.R;
import com.bwie.zhang.zhangxuanyu0415.data.bean.DengBean;
import com.bwie.zhang.zhangxuanyu0415.di.contrant.Contrant;
import com.bwie.zhang.zhangxuanyu0415.di.presenter.IDengPresenterImpl;
import com.bwie.zhang.zhangxuanyu0415.ui.activity.ZhuceActivity;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements Contrant.IDengView{

    @BindView(R.id.ed_dl_sj)
    EditText edDlSj;
    @BindView(R.id.ed_dl_pwd)
    EditText edDlPwd;
    @BindView(R.id.text_zc)
    TextView textZc;
    @BindView(R.id.btn_dl)
    Button btnDl;
    private Contrant.IDengPresenter dengPresenter;
    private Gson gson;
    private DengBean dengBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dengPresenter = new IDengPresenterImpl();
        dengPresenter.attachView(this);
    }

    @OnClick({R.id.text_zc, R.id.btn_dl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_zc:
                Intent intent = new Intent(MainActivity.this,ZhuceActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_dl:
                String userName = edDlSj.getText().toString();
                String password = edDlPwd.getText().toString();
                dengPresenter.requstLoginData(userName, password);
                break;
        }
    }

    @Override
    public void showData(final String responseData) {
        gson = new Gson();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dengBean = gson.fromJson(responseData, DengBean.class);
                Toast.makeText(MainActivity.this, dengBean.getMessage(), Toast.LENGTH_SHORT).show();

                String userName = edDlSj.getText().toString();
                String password = edDlPwd.getText().toString();



                if (dengBean.getStatus().equals("0000")) {
                    Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dengPresenter.detachView(this);
    }

    @Override
    public void jumpActivity() {

    }
}

package com.bwie.zhang.zhangxuanyu0415.di.contrant;

/**
 * Created by 可乐 on 2019/4/15.
 */

public interface Contrant {
    //登录的V层
    public interface IDengView{

        public void showData(String responseData);

        public void jumpActivity();
    }

    //登录的P层
    public interface IDengPresenter<IDengView>{

        public void attachView(Contrant.IDengView dengView);

        public void detachView(Contrant.IDengView dengView);

        public void requstLoginData(String userName, String password);
    }


    //登录的M层
    public interface IDengModel{

        public void containLoginResponseData(String userName, String password, CallBack callback);

        public interface CallBack {
            public void responseData(String responseData);
        }
    }
}
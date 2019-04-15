package com.bwie.zhang.zhangxuanyu0415.di.contrant;

/**
 * Created by 可乐 on 2019/4/15.
 */

public interface ZhuCeContrant {
    //注册V层
    public interface IZhuCerView {

        public void showData(String response);
    }

    //注册P层
    public interface IZhuCePresenter {

        public void attahView(IZhuCerView zhuceView);

        public void detachView(IZhuCerView zhuceView);

        public void requestData(String userName,String pwd);

    }


    //注册M层
    public interface IZheCeModel {

        public void containData(String userName, String pwd, CallBack callBack);

        public interface CallBack{
            public void responseData(String response);
        }

    }
}

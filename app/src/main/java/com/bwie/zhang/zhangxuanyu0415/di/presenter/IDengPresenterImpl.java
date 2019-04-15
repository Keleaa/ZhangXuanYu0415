package com.bwie.zhang.zhangxuanyu0415.di.presenter;

import com.bwie.zhang.zhangxuanyu0415.di.contrant.Contrant;
import com.bwie.zhang.zhangxuanyu0415.di.model.IDengModelImpl;

import java.lang.ref.SoftReference;

/**
 * Created by 可乐 on 2019/4/15.
 */

public class IDengPresenterImpl implements Contrant.IDengPresenter{
    Contrant.IDengView dengView;
    private SoftReference<Contrant.IDengView> reference;
    private Contrant.IDengModel dengModel;


    @Override
    public void attachView(Contrant.IDengView dengView) {
        this.dengView = dengView;

        reference = new SoftReference<>(dengView);

        dengModel = new IDengModelImpl();
    }

    @Override
    public void detachView(Contrant.IDengView dengView) {
        reference.clear();
    }

    @Override
    public void requstLoginData(String userName, String password) {
        dengModel.containLoginResponseData(userName, password, new Contrant.IDengModel.CallBack() {
            @Override
            public void responseData(String responseData) {
                dengView.showData(responseData);
            }
        });
    }
}

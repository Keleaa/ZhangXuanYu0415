package com.bwie.zhang.zhangxuanyu0415.di.presenter;

import com.bwie.zhang.zhangxuanyu0415.di.contrant.ZhuCeContrant;
import com.bwie.zhang.zhangxuanyu0415.di.model.IZheCeModelImpl;

import java.lang.ref.SoftReference;

/**
 * Created by 可乐 on 2019/4/15.
 */

public class IZheCePresenterImpl implements ZhuCeContrant.IZhuCePresenter {
    ZhuCeContrant.IZhuCerView zhuCerView;
    private SoftReference<ZhuCeContrant.IZhuCerView> reference;
    private ZhuCeContrant.IZheCeModel zheCeModel;


    @Override
    public void attahView(ZhuCeContrant.IZhuCerView zhuceView) {
        this.zhuCerView = zhuceView;

        reference = new SoftReference<>(zhuceView);
        zheCeModel = new IZheCeModelImpl();
    }

    @Override
    public void detachView(ZhuCeContrant.IZhuCerView zhuceView) {
        reference.clear();
    }

    @Override
    public void requestData(String userName, String pwd) {
        zheCeModel.containData(userName, pwd, new ZhuCeContrant.IZheCeModel.CallBack() {
            @Override
            public void responseData(String response) {
                zhuCerView.showData(response);
            }
        });
    }
}

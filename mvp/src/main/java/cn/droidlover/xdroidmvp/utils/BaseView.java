package cn.droidlover.xdroidmvp.utils;

import com.trello.rxlifecycle2.LifecycleTransformer;

import cn.droidlover.xdroidmvp.net.NetError;

public interface BaseView {
    //    void showLoading();
//
//    void hideLoading();

    void showError(NetError error);

    LifecycleTransformer bindLifecycle();
}

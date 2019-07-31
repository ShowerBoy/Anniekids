package com.annie.annieforchild.base.interfaces;

import cn.droidlover.xdroidmvp.utils.BaseView;

public interface BasePresenter<V extends BaseView> {
    void attachV(V view);

    void detachV();

    boolean hasV();

}

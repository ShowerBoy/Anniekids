package com.annie.annieforchild.base.interfaces;

import cn.droidlover.xdroidmvp.net.XApi;

public class BaseInteractor<T> {
    public static final String API_BASE_URL = "https://testapici.anniekids.com/Api/v2/";

    protected T mService;

    protected BaseInteractor(Class<T> clazz) {
        mService = XApi.getInstance().getRetrofit(API_BASE_URL, true).create(clazz);
    }

    public void onDetach() {
        if (mService != null) {
            mService = null;
        }
    }
}

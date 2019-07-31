package cn.droidlover.xdroidmvp.mvp;

import cn.droidlover.xdroidmvp.net.XApi;

public class XModel<T> {
    public static final String API_BASE_URL = "https://testapici.anniekids.com/Api/v2/";

    protected T mService;

    protected XModel(Class<T> clazz) {
        mService = XApi.getInstance().getRetrofit(API_BASE_URL, true).create(clazz);
    }

    protected void onDetach() {
        if (mService != null) {
            mService = null;
        }
    }
}

package com.annie.annieforchild.net;

import android.annotation.SuppressLint;
import android.os.Build;

import com.blankj.utilcode.util.AppUtils;

import cn.droidlover.xdroidmvp.net.XApi;

public class Api {
//    public static final String API_BASE_URL = "https://appapi.anniekids.com/Api/v2/";
    public static final String API_BASE_URL = "https://testapici.anniekids.com/Api/v2/";

    private static NetService netService;

    @SuppressLint("MissingPermission")
    public static NetService getNetService() {
        if (netService == null) {
            synchronized (Api.class) {
                if (netService == null) {
                    XApi.getInstance().setDeviceID(Build.SERIAL);
                    XApi.getInstance().setAppVersion(AppUtils.getAppVersionName());
                    netService = XApi.getInstance().getRetrofit(API_BASE_URL, true).create(NetService.class);
                }
            }
        }
        return netService;
    }
}

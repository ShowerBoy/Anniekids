package cn.droidlover.xdroidmvp.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;

import java.io.InputStream;

import cn.droidlover.xdroidmvp.net.XApi;
import okhttp3.OkHttpClient;

@GlideModule
public class BaseGlide extends AppGlideModule {
    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        super.registerComponents(context, glide, registry);
        //UnsafeOkHttpClient.getUnsafeOkHttpClient()
        OkHttpUrlLoader.Factory factory = new OkHttpUrlLoader.Factory(XApi.getInstance().getClient(XApi.API_BASE_URL, XApi.getCommonProvider()));
        registry.replace(GlideUrl.class, InputStream.class, factory);
    }
}

package com.annie.annieforchild.net;

import com.annie.annieforchild.model.Song;
import com.annie.annieforchild.model.login.LoginByCodeBean;
import com.annie.annieforchild.model.login.VcodeBean;

import cn.droidlover.xdroidmvp.kit.Kits;
import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface NetService {

    @FormUrlEncoded
    @POST("System/getVerificationCode")
    Flowable<VcodeBean> getVerificationCode(@Field("phone") String phone, @Field("type") int type);

    @FormUrlEncoded
    @POST("System/loginByCode")
    Flowable<LoginByCodeBean> loginByVcode(@Field("phone") String phone, @Field("code") int code, @Field("serialNumber") int serialNumber);

    @FormUrlEncoded
    @POST("System/login")
    Flowable<LoginByCodeBean> login(@Field("phone") String phone, @Field("password") String password);

}

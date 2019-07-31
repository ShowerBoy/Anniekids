package com.annie.annieforchild.interactor;

import com.annie.annieforchild.base.interfaces.BaseInteractor;
import com.annie.annieforchild.model.login.LoginByCodeBean;
import com.annie.annieforchild.model.login.VcodeBean;
import com.annie.annieforchild.net.Api;
import com.annie.annieforchild.net.NetService;

import cn.droidlover.xdroidmvp.net.XApi;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public class LoginInteractorImp extends BaseInteractor<NetService> implements LoginInteractor {

    public LoginInteractorImp(Class<NetService> clazz) {
        super(clazz);
    }

    @Override
    public Flowable<VcodeBean> getVerificationCode(String phone, int type) {
        return Api.getNetService().getVerificationCode(phone, type)
                .compose(XApi.<VcodeBean>getApiTransformer())
                .compose(XApi.<VcodeBean>getScheduler());
    }

    @Override
    public Flowable<LoginByCodeBean> loginByVcode(String phone, int vcode, int serialNum) {
        return Api.getNetService().loginByVcode(phone, vcode, serialNum)
                .compose(XApi.<LoginByCodeBean>getApiTransformer())
                .compose(XApi.<LoginByCodeBean>getScheduler());
    }

    @Override
    public Flowable<LoginByCodeBean> login(String phone, String password) {
        return Api.getNetService().login(phone, password)
                .compose(XApi.<LoginByCodeBean>getApiTransformer())
                .compose(XApi.<LoginByCodeBean>getScheduler());
    }
}

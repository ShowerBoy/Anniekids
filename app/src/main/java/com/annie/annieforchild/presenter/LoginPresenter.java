package com.annie.annieforchild.presenter;

import android.os.Bundle;
import android.view.View;

import com.annie.annieforchild.base.BaseFragment;
import com.annie.annieforchild.base.BaseLoginFragment;
import com.annie.annieforchild.model.login.LoginByCodeBean;
import com.annie.annieforchild.model.login.VcodeBean;
import com.annie.annieforchild.net.Api;
import com.annie.annieforchild.ui.activity.login.LoginActivity;
import com.annie.annieforchild.ui.fragment.login.VCodeFragment;
import com.annie.annieforchild.view.LoginView;

import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.mvp.XLazyFragment;
import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.droidlover.xdroidmvp.net.ApiSubscriber;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.XApi;

public class LoginPresenter extends XPresent<BaseLoginFragment>{

    public void getVerificationCode(String phone, int type) {
        Api.getNetService().getVerificationCode(phone, type)
                .compose(XApi.<VcodeBean>getApiTransformer())
                .compose(XApi.<VcodeBean>getScheduler())
                .compose(getV().<VcodeBean>bindToLifecycle())
                .subscribe(new ApiSubscriber<VcodeBean>() {
                    @Override
                    public void onNext(VcodeBean vcodeBean) {
                        getV().getVcodeResult(vcodeBean);
                    }

                    @Override
                    protected void onFail(NetError error) {
                        getV().showError(error);
                    }
                });
    }

    public void loginByVcode(String phone, int vcode, int serialNum) {
        Api.getNetService().loginByVcode(phone, vcode, serialNum)
                .compose(XApi.getApiTransformer())
                .compose(XApi.getScheduler())
                .compose(getV().bindToLifecycle())
                .subscribe(new ApiSubscriber<LoginByCodeBean>() {
                    @Override
                    public void onNext(LoginByCodeBean loginByCodeBean) {
                        getV().loginByCode(loginByCodeBean);
                    }

                    @Override
                    protected void onFail(NetError error) {
                        getV().showError(error);
                    }
                });
    }

    public void login(String phone, String password) {
        Api.getNetService().login(phone, password)
                .compose(XApi.getApiTransformer())
                .compose(XApi.getScheduler())
                .compose(getV().bindToLifecycle())
                .subscribe(new ApiSubscriber<LoginByCodeBean>() {
                    @Override
                    public void onNext(LoginByCodeBean loginByCodeBean) {
                        getV().loginByCode(loginByCodeBean);
                    }

                    @Override
                    protected void onFail(NetError error) {
                        getV().showError(error);
                    }
                });

    }

}

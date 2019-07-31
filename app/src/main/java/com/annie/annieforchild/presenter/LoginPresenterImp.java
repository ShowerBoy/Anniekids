package com.annie.annieforchild.presenter;

import com.annie.annieforchild.base.imp.BasePresenterImp;
import com.annie.annieforchild.interactor.LoginInteractorImp;
import com.annie.annieforchild.model.login.LoginByCodeBean;
import com.annie.annieforchild.model.login.VcodeBean;
import com.annie.annieforchild.net.Api;
import com.annie.annieforchild.net.NetService;
import com.annie.annieforchild.utils.SystemUtils;
import com.annie.annieforchild.view.LoginView;

import org.reactivestreams.Subscription;

import cn.droidlover.xdroidmvp.net.ApiSubscriber;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.XApi;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;

public class LoginPresenterImp extends BasePresenterImp<LoginView, LoginInteractorImp> implements LoginPresenter {

    @Override
    public void getVerificationCode(String phone, int type) {
        mModel.getVerificationCode(phone, type)
                .compose(getV().bindLifecycle())
                .subscribe(new ApiSubscriber<VcodeBean>() {
                    @Override
                    protected void onFail(NetError error) {
                        getV().showError(error);
                    }

                    @Override
                    public void onNext(VcodeBean vcodeBean) {
                        getV().getVcodeResult(vcodeBean);
                    }
                });
    }

    @Override
    public void loginByVcode(String phone, int vcode, int serialNum) {
        mModel.loginByVcode(phone, vcode, serialNum)
                .compose(getV().bindLifecycle())
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

    @Override
    public void login(String phone, String password) {
        mModel.login(phone, password)
                .compose(getV().bindLifecycle())
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

    @Override
    protected LoginInteractorImp getModel() {
        return new LoginInteractorImp(NetService.class);
    }

}

package com.annie.annieforchild.interactor;

import com.annie.annieforchild.model.login.LoginByCodeBean;
import com.annie.annieforchild.model.login.VcodeBean;

import io.reactivex.Flowable;

public interface LoginInteractor {
    Flowable<VcodeBean> getVerificationCode(String phone, int type);

    Flowable<LoginByCodeBean> loginByVcode(String phone, int vcode, int serialNum);

    Flowable<LoginByCodeBean> login(String phone, String password);
}

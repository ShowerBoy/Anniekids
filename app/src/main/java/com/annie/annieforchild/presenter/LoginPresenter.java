package com.annie.annieforchild.presenter;

import com.annie.annieforchild.base.interfaces.BasePresenter;
import com.annie.annieforchild.model.login.VcodeBean;

import io.reactivex.Flowable;

public interface LoginPresenter{
    void getVerificationCode(String phone, int type);

    void loginByVcode(String phone, int vcode, int serialNum);

    void login(String phone, String password);
}

package com.annie.annieforchild.view;

import android.view.View;

import com.annie.annieforchild.model.login.LoginByCodeBean;
import com.annie.annieforchild.model.login.VcodeBean;

import cn.droidlover.xdroidmvp.mvp.IView;
import cn.droidlover.xdroidmvp.net.NetError;

public interface LoginView extends IView {
    void showError(NetError error);

    void getVcodeResult(VcodeBean vcodeBean);

    void loginByCode(LoginByCodeBean loginByCodeBean);

}

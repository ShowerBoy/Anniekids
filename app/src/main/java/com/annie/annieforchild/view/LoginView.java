package com.annie.annieforchild.view;

import com.annie.annieforchild.model.login.LoginByCodeBean;
import com.annie.annieforchild.model.login.VcodeBean;

import cn.droidlover.xdroidmvp.utils.BaseView;

public interface LoginView extends BaseView {

    void getVcodeResult(VcodeBean vcodeBean);

    void loginByCode(LoginByCodeBean loginByCodeBean);

}

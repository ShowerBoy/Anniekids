package com.annie.annieforchild.base;

import com.annie.annieforchild.interactor.LoginInteractorImp;
import com.annie.annieforchild.model.login.LoginByCodeBean;
import com.annie.annieforchild.model.login.VcodeBean;
import com.annie.annieforchild.presenter.LoginPresenterImp;
import com.annie.annieforchild.ui.activity.MainActivity;
import com.annie.annieforchild.utils.SystemUtils;
import com.annie.annieforchild.view.LoginView;

import cn.droidlover.xdroidmvp.mvp.XLazyFragment;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.router.Router;

public abstract class BaseLoginFragment extends BaseFragment<LoginPresenterImp, LoginInteractorImp> implements LoginView {
    protected int serialNumber;

    @Override
    public void getVcodeResult(VcodeBean vcodeBean) {
        if (vcodeBean == null) return;
        serialNumber = vcodeBean.getSerialNumber();
    }

    @Override
    public void loginByCode(LoginByCodeBean loginByCodeBean) {
        Router.newIntent(getActivity()).to(MainActivity.class).launch();
        getActivity().finish();
    }

}

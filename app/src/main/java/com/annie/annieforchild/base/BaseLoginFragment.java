package com.annie.annieforchild.base;

import com.annie.annieforchild.model.login.LoginByCodeBean;
import com.annie.annieforchild.model.login.VcodeBean;
import com.annie.annieforchild.presenter.LoginPresenter;
import com.annie.annieforchild.ui.activity.MainActivity;
import com.annie.annieforchild.utils.SystemUtils;

import cn.droidlover.xdroidmvp.mvp.XLazyFragment;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.router.Router;

public abstract class BaseLoginFragment extends XLazyFragment<LoginPresenter> {
    protected int serialNumber;

    public void getVcodeResult(VcodeBean vcodeBean) {
        if (vcodeBean == null) return;
        serialNumber = vcodeBean.getSerialNumber();
    }

    public void loginByCode(LoginByCodeBean loginByCodeBean) {
        Router.newIntent(getActivity()).to(MainActivity.class).launch();
        getActivity().finish();
    }

    public void showError(NetError error) {
        if (error != null) {
            switch (error.getType()) {
                case NetError.ParseError:
                    SystemUtils.showInfo("数据解析异常");
                    break;

                case NetError.AuthError:
                    SystemUtils.showInfo("身份验证异常");
                    break;

                case NetError.BusinessError:
                    SystemUtils.showInfo("业务异常");
                    break;

                case NetError.NoConnectError:
                    SystemUtils.showInfo("网络无连接");
                    break;

                case NetError.NoDataError:
                    SystemUtils.showInfo("数据为空");
                    break;

                case NetError.OtherError:
                    SystemUtils.showInfo(error.getMessage());
                    break;
            }
        }
    }
}

package com.annie.annieforchild.ui.activity.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.annie.annieforchild.R;
import com.annie.annieforchild.base.BaseActivity;
import com.annie.annieforchild.model.login.LoginByCodeBean;
import com.annie.annieforchild.model.login.VcodeBean;
import com.annie.annieforchild.presenter.LoginPresenterImp;
import com.annie.annieforchild.view.LoginView;
import com.trello.rxlifecycle2.LifecycleTransformer;

import butterknife.BindView;
import butterknife.OnClick;
import cn.droidlover.xdroidmvp.net.NetError;

public class ForgetPsdActivity extends BaseActivity implements LoginView{
    @BindView(R.id.title_bar)
    TextView titleBar;
    @BindView(R.id.go_back)
    ImageView goBack;
    @BindView(R.id.edit_vphone)
    EditText editVphone;
    @BindView(R.id.edit_vcode)
    EditText editVcode;
    @BindView(R.id.get_vcode)
    TextView getVcode;
    @BindView(R.id.edit_psd)
    EditText editPsd;
    @BindView(R.id.edit_confirm_psd)
    EditText editConfirmPsd;
    @BindView(R.id.vloginBtn)
    Button vloginBtn;

    @Override
    public void initData(Bundle savedInstanceState) {
        titleBar.setText("忘记密码");
        goBack.setVisibility(View.VISIBLE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_forget_psd;
    }

    @Override
    public Object newP() {
        return new LoginPresenterImp();
    }

    @OnClick({R.id.go_back, R.id.get_vcode, R.id.vloginBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.go_back:
                finish();
                break;
            case R.id.get_vcode:

                break;
            case R.id.vloginBtn:
                break;
            default:
                break;
        }
    }

    @Override
    public void getVcodeResult(VcodeBean vcodeBean) {

    }

    @Override
    public void loginByCode(LoginByCodeBean loginByCodeBean) {

    }

}

package com.annie.annieforchild.ui.fragment.login;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.annie.annieforchild.R;
import com.annie.annieforchild.base.BaseLoginFragment;
import com.annie.annieforchild.presenter.LoginPresenterImp;
import com.annie.annieforchild.ui.activity.login.ForgetPsdActivity;
import com.annie.annieforchild.utils.SystemUtils;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.droidlover.xdroidmvp.router.Router;

public class LoginFragment extends BaseLoginFragment{
    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.edit_psd)
    EditText editPsd;
    @BindView(R.id.loginBtn)
    Button loginBtn;
    @BindView(R.id.forget_psd)
    TextView forgetPsd;
    Unbinder unbinder;

    public static LoginFragment instance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }


    @Override
    public void initData(Bundle savedInstanceState) {
        editPhone.addTextChangedListener(textWatcher);
        editPsd.addTextChangedListener(textWatcher);
        SystemUtils.setEditTextHintSize(editPhone, "请输入手机号", 12);
        SystemUtils.setEditTextHintSize(editPsd, "请输入密码", 12);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login
                ;
    }

    @Override
    public LoginPresenterImp newP() {
        return new LoginPresenterImp();
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (editPhone.getText().toString() != null && editPhone.getText().toString().length() > 0
                    && editPsd.getText().toString() != null && editPsd.getText().toString().length() > 0) {
                loginBtn.setEnabled(true);
            } else {
                loginBtn.setEnabled(false);
            }
        }
    };


    @OnClick(R.id.forget_psd)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forget_psd:
                Router.newIntent(getActivity()).to(ForgetPsdActivity.class).launch();
                break;
            default:
                break;
        }
    }
}

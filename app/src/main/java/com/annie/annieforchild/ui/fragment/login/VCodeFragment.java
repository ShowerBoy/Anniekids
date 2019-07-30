package com.annie.annieforchild.ui.fragment.login;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.annie.annieforchild.R;
import com.annie.annieforchild.base.BaseFragment;
import com.annie.annieforchild.base.BaseLoginFragment;
import com.annie.annieforchild.presenter.LoginPresenter;
import com.annie.annieforchild.utils.SystemUtils;
import com.annie.annieforchild.view.LoginView;
import com.blankj.utilcode.util.RegexUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.droidlover.xdroidmvp.mvp.XLazyFragment;

public class VCodeFragment extends BaseLoginFragment {
    @BindView(R.id.edit_vphone)
    EditText editVphone;
    @BindView(R.id.edit_vcode)
    EditText editVcode;
    @BindView(R.id.get_vcode)
    TextView getVcode;
    @BindView(R.id.vloginBtn)
    Button vloginBtn;
    private CountDownTimer countDownTimer;

    public static VCodeFragment instance() {
        VCodeFragment fragment = new VCodeFragment();
        return fragment;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        editVphone.addTextChangedListener(textWatcher);
        editVcode.addTextChangedListener(textWatcher);
        SystemUtils.setEditTextHintSize(editVphone, "请输入手机号", 12);
        SystemUtils.setEditTextHintSize(editVcode, "请输入验证码", 12);
        countDownTimer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long l) {
                getVcode.setText(l / 1000 + "s后重新发送");
                getVcode.setTextColor(getResources().getColor(R.color.text_gray));
            }

            @Override
            public void onFinish() {
                getVcode.setText("获取验证码");
                getVcode.setTextColor(getResources().getColor(R.color.text_orange));
                getVcode.setClickable(true);
            }
        };
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_vcode;
    }

    @Override
    public LoginPresenter newP() {
        return new LoginPresenter();
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
            if (editVphone.getText().toString() != null && editVphone.getText().toString().length() > 0
                    && editVcode.getText().toString() != null && editVcode.getText().toString().length() > 0) {
                vloginBtn.setEnabled(true);
            } else {
                vloginBtn.setEnabled(false);
            }
        }
    };

    @OnClick({R.id.get_vcode, R.id.vloginBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.get_vcode:
                if (TextUtils.isEmpty(editVphone.getText().toString())) {
                    SystemUtils.showInfo("请输入手机号");
                    return;
                }
                if (RegexUtils.isMobileSimple(editVphone.getText().toString())) {
                    getVcode.setClickable(false);
                    countDownTimer.start();
                    getP().getVerificationCode(editVphone.getText().toString().trim(), 1);
                } else {
                    SystemUtils.showInfo("请输入正确的手机号");
                }
                break;
            case R.id.vloginBtn:
                getP().loginByVcode(editVphone.getText().toString(), Integer.parseInt(editVcode.getText().toString().trim()), serialNumber);
                break;
            default:
                break;
        }
    }

}

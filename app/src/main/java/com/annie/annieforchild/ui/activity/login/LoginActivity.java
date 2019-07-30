package com.annie.annieforchild.ui.activity.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.annie.annieforchild.R;
import com.annie.annieforchild.base.BaseActivity;
import com.annie.annieforchild.ui.fragment.login.LoginFragment;
import com.annie.annieforchild.ui.fragment.login.VCodeFragment;
import com.annie.annieforchild.utils.advancedPagerTab.AdvancedPagerSlidingTabStrip;
import com.annie.annieforchild.utils.views.APSTSViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.title_bar)
    TextView title;
    @BindView(R.id.relative)
    RelativeLayout relative;
    @BindView(R.id.material_tab_layout)
    AdvancedPagerSlidingTabStrip materialTabLayout;
    @BindView(R.id.viewPager)
    APSTSViewPager viewPager;
    @BindView(R.id.agreement_1)
    TextView agreement1;
    @BindView(R.id.agreement_2)
    TextView agreement2;
    @BindView(R.id.go_back)
    ImageView goBack;

    private LoginFragment loginFragment;
    private VCodeFragment vCodeFragment;
    private FragmentAdapter fragmentAdapter;

    @Override
    public void initData(Bundle savedInstanceState) {
        title.setText("登陆");
        goBack.setVisibility(View.GONE);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(fragmentAdapter);
        fragmentAdapter.notifyDataSetChanged();
        materialTabLayout.setViewPager(viewPager);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public Object newP() {
        return null;
    }


    class FragmentAdapter extends FragmentStatePagerAdapter {

        private FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position >= 0 && position < 2) {
                switch (position) {
                    case 0:
                        if (null == vCodeFragment) {
                            vCodeFragment = VCodeFragment.instance();
                        }
                        return vCodeFragment;
                    case 1:
                        if (null == loginFragment) {
                            loginFragment = LoginFragment.instance();
                        }
                        return loginFragment;
                    default:
                        break;
                }
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position >= 0 && position < 2) {
                switch (position) {
                    case 0:
                        return "验证码登陆";
                    case 1:
                        return "密码登陆";
                    default:
                        break;
                }
            }
            return null;
        }
    }
}

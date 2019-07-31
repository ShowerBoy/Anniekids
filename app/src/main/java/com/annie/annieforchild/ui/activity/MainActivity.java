package com.annie.annieforchild.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.annie.annieforchild.R;
import com.annie.annieforchild.base.BaseFragment;
import com.annie.annieforchild.base.QuickNavigationBarActivity;
import com.annie.annieforchild.ui.fragment.FifthFragment;
import com.annie.annieforchild.ui.fragment.FirstFragment;
import com.annie.annieforchild.ui.fragment.FourthFragment;
import com.annie.annieforchild.ui.fragment.SecondFragment;
import com.annie.annieforchild.ui.fragment.ThirdFragment;

import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.mvp.XFragment;
import cn.droidlover.xdroidmvp.mvp.XLazyFragment;
import cn.droidlover.xdroidmvp.net.NetError;

public class MainActivity extends QuickNavigationBarActivity {

    @Override
    protected BaseFragment[] getFragments() {
        FirstFragment firstFragment = new FirstFragment();
        SecondFragment secondFragment = new SecondFragment();
        ThirdFragment thirdFragment = new ThirdFragment();
        FourthFragment fourthFragment = new FourthFragment();
        FifthFragment fifthFragment = new FifthFragment();
        return new BaseFragment[]{firstFragment, secondFragment, thirdFragment, fourthFragment, fifthFragment};
    }

    @Override
    protected String[] getText() {
        return new String[]{"首页", "课程", "打卡", "发现", "我的"};
    }

    @Override
    protected int[] getActive_icons() {
        return new int[]{R.drawable.icon_main_t, R.drawable.icon_lesson_t, R.drawable.icon_daka_t, R.drawable.icon_discover_t, R.drawable.icon_my_t};
    }

    @Override
    protected int[] getInactive_icons() {
        return new int[]{R.drawable.icon_main_f, R.drawable.icon_lesson_f, R.drawable.icon_daka_f, R.drawable.icon_discover_f, R.drawable.icon_my_f};
    }

    @Override
    protected int[] getActive_Color() {
        return new int[]{R.color.text_orange, R.color.text_orange, R.color.text_orange, R.color.text_orange, R.color.text_orange};
    }

    @Override
    protected int[] getInactive_Color() {
        return new int[]{R.color.navigation_bar_color, R.color.navigation_bar_color, R.color.navigation_bar_color, R.color.navigation_bar_color, R.color.navigation_bar_color};
    }

    @Override
    protected int getPlan() {
        return 1;
    }

}

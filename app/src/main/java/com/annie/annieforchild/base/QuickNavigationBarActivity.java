package com.annie.annieforchild.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.widget.FrameLayout;

import com.annie.annieforchild.R;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.mvp.XFragment;
import cn.droidlover.xdroidmvp.mvp.XLazyFragment;

public abstract class QuickNavigationBarActivity extends XActivity implements BottomNavigationBar.OnTabSelectedListener {
    @BindView(R.id.tabFrame)
    FrameLayout tabFrame;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    protected XLazyFragment[] fragments;//对应的fragment集合
    protected int[] active_icons;//底部选中图标
    protected int[] inactive_icons; //底部未选中图标
    protected String[] texts;//底部对应文字
    protected int[] active_colors;//选中时颜色
    protected int[] inactive_colors;//未选中时颜色
    protected int plan = 0;//方案选择 0：改变颜色（默认） 1：改变图标
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    @Override
    public void initData(Bundle savedInstanceState) {
        initialize();
        fragmentManager = getSupportFragmentManager();
        if (fragments != null) {
            transaction = fragmentManager.beginTransaction();
            for (XLazyFragment bf : fragments) {
                transaction.add(R.id.tabFrame, bf, bf.getTag());
            }
            hideFragment();
            showFragment(0);
        }
        transaction.commit();
        if (plan == 0) {
            /**
             * 方案1：改变颜色
             */
            if (active_icons != null && texts != null && active_colors != null && inactive_colors != null) {
                bottomNavigationBar
                        .setMode(BottomNavigationBar.MODE_FIXED)
                        .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT)
                        .addItem(new BottomNavigationItem(active_icons[0], texts[0]).setActiveColorResource(active_colors[0]).setInActiveColorResource(inactive_colors[0]))
                        .addItem(new BottomNavigationItem(active_icons[1], texts[1]).setActiveColorResource(active_colors[1]).setInActiveColorResource(inactive_colors[1]))
                        .addItem(new BottomNavigationItem(active_icons[2], texts[2]).setActiveColorResource(active_colors[2]).setInActiveColorResource(inactive_colors[2]))
                        .addItem(new BottomNavigationItem(active_icons[3], texts[3]).setActiveColorResource(active_colors[3]).setInActiveColorResource(inactive_colors[3]))
                        .addItem(new BottomNavigationItem(active_icons[4], texts[4]).setActiveColorResource(active_colors[4]).setInActiveColorResource(inactive_colors[4]))
                        .setFirstSelectedPosition(0)
                        .initialise();
            }
        } else if (plan == 1) {
            /**
             * 方案2：改变图标
             */
            if (active_icons != null && texts != null && inactive_icons != null) {
                bottomNavigationBar
                        .setMode(BottomNavigationBar.MODE_FIXED)
                        .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT)
                        .addItem(new BottomNavigationItem(active_icons[0], texts[0]).setInactiveIcon(ContextCompat.getDrawable(this, inactive_icons[0])).setActiveColorResource(active_colors[0]).setInActiveColorResource(inactive_colors[0]))
                        .addItem(new BottomNavigationItem(active_icons[1], texts[1]).setInactiveIcon(ContextCompat.getDrawable(this, inactive_icons[1])).setActiveColorResource(active_colors[1]).setInActiveColorResource(inactive_colors[1]))
                        .addItem(new BottomNavigationItem(active_icons[2], texts[2]).setInactiveIcon(ContextCompat.getDrawable(this, inactive_icons[2])).setActiveColorResource(active_colors[2]).setInActiveColorResource(inactive_colors[2]))
                        .addItem(new BottomNavigationItem(active_icons[3], texts[3]).setInactiveIcon(ContextCompat.getDrawable(this, inactive_icons[3])).setActiveColorResource(active_colors[3]).setInActiveColorResource(inactive_colors[3]))
                        .addItem(new BottomNavigationItem(active_icons[4], texts[4]).setInactiveIcon(ContextCompat.getDrawable(this, inactive_icons[4])).setActiveColorResource(active_colors[4]).setInActiveColorResource(inactive_colors[4]))
                        .setFirstSelectedPosition(0)
                        .initialise();
            }
        }
        bottomNavigationBar.setTabSelectedListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_quick_navigation_bar;
    }

    @Override
    public Object newP() {
        return null;
    }

    private void initialize() {
        setFragments();
        setTexts();
        setActive_icons();
        setInactive_icons();
        setActive_Color();
        setInactive_Color();
        setPlan();
    }

    @Override
    public void onTabSelected(int position) {
        hideFragment();
        showFragment(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    private void hideFragment() {
        FragmentTransaction trans = fragmentManager.beginTransaction();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                trans.hide(fragment);
            }
        }
        trans.commit();
    }

    private void showFragment(int index) {
        FragmentTransaction trans = fragmentManager.beginTransaction();
        trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        trans.show(fragments[index]);
        trans.commit();
    }

    protected void setFragments() {
        this.fragments = getFragments();
    }

    protected void setTexts() {
        this.texts = getText();
    }

    protected void setActive_icons() {
        this.active_icons = getActive_icons();
    }

    protected void setInactive_icons() {
        this.inactive_icons = getInactive_icons();
    }

    protected void setActive_Color() {
        this.active_colors = getActive_Color();
    }

    protected void setInactive_Color() {
        this.inactive_colors = getInactive_Color();
    }

    protected void setPlan() {
        this.plan = getPlan();
    }

    protected abstract XLazyFragment[] getFragments();

    protected abstract String[] getText();//获取底部文字

    protected abstract int[] getActive_icons();//获取选中时图标

    protected abstract int[] getInactive_icons();//获取未选中图标

    protected abstract int[] getActive_Color();//获取选中时颜色

    protected abstract int[] getInactive_Color();//获取未选中时颜色

    protected abstract int getPlan();//获取方案
}

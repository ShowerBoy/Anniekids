package com.annie.annieforchild.ui.fragment;

import android.os.Bundle;

import com.annie.annieforchild.R;
import com.annie.annieforchild.base.BaseFragment;

import cn.droidlover.xdroidmvp.mvp.XFragment;
import cn.droidlover.xdroidmvp.mvp.XLazyFragment;

public class SecondFragment extends BaseFragment {

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_second;
    }

    @Override
    public Object newP() {
        return null;
    }
}

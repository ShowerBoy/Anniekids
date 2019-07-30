package com.annie.annieforchild.ui.fragment;

import android.os.Bundle;

import com.annie.annieforchild.R;

import cn.droidlover.xdroidmvp.mvp.XFragment;
import cn.droidlover.xdroidmvp.mvp.XLazyFragment;

public class FifthFragment extends XLazyFragment {

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_fifth;
    }

    @Override
    public Object newP() {
        return null;
    }
}

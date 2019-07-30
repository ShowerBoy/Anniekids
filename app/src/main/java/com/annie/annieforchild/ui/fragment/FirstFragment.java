package com.annie.annieforchild.ui.fragment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.annie.annieforchild.R;
import com.annie.annieforchild.presenter.GrindPresenter;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.imageloader.ILFactory;
import cn.droidlover.xdroidmvp.imageloader.ILoader;
import cn.droidlover.xdroidmvp.mvp.XFragment;
import cn.droidlover.xdroidmvp.mvp.XLazyFragment;

public class FirstFragment extends XLazyFragment<GrindPresenter> {
    @BindView(R.id.top_user_headpic)
    ImageView headpic;
    @BindView(R.id.top_user_name)
    TextView username;
    @BindView(R.id.top_user_age)
    TextView userage;

    @Override
    public void initData(Bundle savedInstanceState) {
        ILFactory.getLoader().loadCircle("https://appapi.anniekids.com/Public/Uploads/avatar/20190709/5d23f44e5d64b.jpeg", headpic, new ILoader.Options(R.drawable.icon_system_headpic, R.drawable.icon_system_headpic));
        username.setText("香雪");
        userage.setText("2岁");
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_first;
    }

    @Override
    public GrindPresenter newP() {
        return new GrindPresenter();
    }


}

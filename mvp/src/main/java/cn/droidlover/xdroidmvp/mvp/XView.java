package cn.droidlover.xdroidmvp.mvp;

import com.trello.rxlifecycle2.LifecycleProvider;

public interface XView extends IView{
    void showLoad();

    void dismissLoad();
}

package com.annie.annieforchild.base.imp;

import com.annie.annieforchild.base.interfaces.BaseInteractor;
import com.annie.annieforchild.base.interfaces.BasePresenter;

import java.lang.ref.WeakReference;

import cn.droidlover.xdroidmvp.utils.BaseView;

public abstract class BasePresenterImp<V extends BaseView, M extends BaseInteractor> implements BasePresenter<V>{

    private WeakReference<V> v;
    protected M mModel;

    public void attachV(V view) {
        v = new WeakReference<V>(view);

        if (getModel() != null) {
            mModel = getModel();
        }
    }

    protected abstract M getModel();

    public void detachV() {
        if (v.get() != null) {
            v.clear();
        }
        v = null;
        mModel.onDetach();
    }

    protected V getV() {
        if (v == null || v.get() == null) {
            throw new IllegalStateException("v can not be null");
        }
        return v.get();
    }

    public boolean hasV() {
        return v != null && v.get() != null;
    }
}

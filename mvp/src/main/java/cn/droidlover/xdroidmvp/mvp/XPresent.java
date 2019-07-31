package cn.droidlover.xdroidmvp.mvp;

import java.lang.ref.WeakReference;


/**
 * Created by wanglei on 2016/12/29.
 */

public abstract class XPresent<V extends XView, M extends XModel>{
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

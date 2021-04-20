//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.aversyk.librarymvip.ui;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Averysk
 */
public abstract class BasePresenter<V extends IView> implements IPresenter<V> {
    protected Reference<V> viewRef;
    protected List<Reference<V>> viewRefList;

    public BasePresenter() {
    }

    @Override
    public void attachView(V view) {
        this.viewRef = new WeakReference(view);
        if (this.viewRefList == null) {
            viewRefList = new ArrayList<>();
        }
        viewRefList.add(viewRef);
    }

    @Override
    public void detachView() {
        if (this.viewRef != null) {
            if (this.viewRefList != null && this.viewRefList.size() > 0) {
                this.viewRefList.remove(viewRef);
            }
            this.viewRef.clear();
            this.viewRef = null;
            if (this.viewRefList != null && this.viewRefList.size() > 0) {
                viewRef = this.viewRefList.get(viewRefList.size() - 1);
            }
        }
    }

    public boolean isViewAttached() {
        return this.viewRef != null && this.viewRef.get() != null;
    }

    public V getView() {
        if (viewRef != null) {
            if (viewRef.get() != null) {
                return (V) this.viewRef.get();
            }
        }
        return null;
    }

    public List<Reference<V>> getViewList() {
        if (viewRefList != null) {
            return this.viewRefList;
        }
        return new ArrayList<>();
    }

}

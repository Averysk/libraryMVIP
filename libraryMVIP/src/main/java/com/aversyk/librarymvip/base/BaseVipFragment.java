package com.aversyk.librarymvip.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aversyk.librarymvip.ui.IPresenter;
import com.aversyk.librarymvip.ui.IView;

import me.yokeyword.fragmentation.SwipeBackLayout;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * 基类(自定义MVIP设计模式)
 * @author Averies
 * @date 2019/05/07
 */
@SuppressWarnings("rawtypes")
public abstract class BaseVipFragment<P extends IPresenter> extends SwipeBackFragment implements IView {
    protected P presenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.presenter = this.createPresenter();
        if (this.getPresenter() != null) {
            this.getPresenter().attachView(this);
        }
        hideSoftInput();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setSwipeBackEnable(isSwipeBackEnable());
        setParallaxOffset(getParallaxOffset());
        getSwipeBackLayout().setEdgeOrientation(getEdgeOrientation());
    }

    @Override
    public void onDestroyView() {
        if (this.getPresenter() != null) {
            this.getPresenter().detachView();
        }
        super.onDestroyView();
    }

    /**
     * 创建当前控制者
     * @return
     */
    public abstract P createPresenter();

    /**
     * 获取当前控制者
     * @return
     */
    public P getPresenter() {
        return this.presenter;
    }

    /**
     * 是否允许滑动，默认true: 允许
     * @return
     */
    public boolean isSwipeBackEnable() { return true; }

    /**
     * 滑动退出视觉差，默认0.33（类iOS）
     * @return
     */
    public float getParallaxOffset() {
        return 0.33f;
    }

    /**
     * 是滑动退出方向，默认左侧
     * @return
     */
    public int getEdgeOrientation() { return SwipeBackLayout.EDGE_LEFT; }

    /**
     * 显示正在加载中....
     */
    @Override
    public void showLoading() {}

    /**
     * 显示自定义提示标语
     */
    @Override
    public void showLoading(CharSequence tipWord) {}

    /**
     * 隐藏提示标语
     */
    @Override
    public void hideLoading() {}

    /**
     * 显示消息
     *
     * @param what
     * @param message
     */
    @Override
    public void showFailed(int what, String message) { }

    @Override
    public boolean showFailedBack(int what, String message) {
        return false;
    }
}

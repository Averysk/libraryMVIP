//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.aversyk.librarymvip.base;

import android.os.Bundle;

import androidx.annotation.Nullable;


import com.aversyk.librarymvip.ui.IPresenter;
import com.aversyk.librarymvip.ui.IView;

import me.yokeyword.fragmentation.SwipeBackLayout;
import me.yokeyword.fragmentation_swipeback.SwipeBackActivity;

/**
 * 基类(自定义MVIP设计模式)
 * @author Averies
 * @date 2019/05/07
 */
public abstract class BaseVipActivity<P extends IPresenter> extends SwipeBackActivity implements IView {
    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = this.createPresenter();
        if (this.getPresenter() != null) {
            this.getPresenter().attachView(this);
        }
        setSwipeBackEnable(isSwipeBackEnable());
        getSwipeBackLayout().setEdgeOrientation(getEdgeOrientation());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.getPresenter() != null){
            this.getPresenter().detachView();
        }
    }

    /**
     * 创建当前控制者
     * @return
     */
    protected abstract P createPresenter();

    /**
     * 获取当前控制者
     * @return
     */
    public P getPresenter() { return this.presenter;}

    /**
     * 是否允许滑动，默认true: 允许
     * @return
     */
    public boolean isSwipeBackEnable() { return true; }

    /**
     * 滑动退出方向，默认左侧
     * @return
     */
    public int getEdgeOrientation() { return SwipeBackLayout.EDGE_LEFT; }

    /**
     * 显示正在加载中....
     */
    @Override
    public void showLoading(){};

    /**
     * 显示自定义提示标语
     */
    @Override
    public void showLoading(CharSequence tipWord){}

    /**
     * 隐藏提示标语
     */
    @Override
    public void hideLoading(){}

    /**
     * 显示消息
     * @param what
     * @param message
     */
    @Override
    public void showFailed(int what, String message){ }

    /**
     * 显示消息
     * @param what
     * @param message
     */
    @Override
    public boolean showFailedBack(int what, String message){ return false; }

}

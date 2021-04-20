//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.aversyk.librarymvip.ui;

/**
 * Created by Averysk
 */
public interface IView {
    void showLoading();

    void showLoading(CharSequence tipWord);

    void hideLoading();

    void showFailed(int what, String message);

    boolean showFailedBack(int what, String message);
}

package com.github.ostea.bmpoptimize.main;

import com.github.ostea.bmpoptimize.mvp.BaseView;

import java.util.ArrayList;

/**
 * Desc:
 * Created by Thorn on 16/7/5.
 */
public interface MainContract {

    interface View extends BaseView<Presenter> {
        void initView();
        void initViewEvent();

        void loadComplete();
        void loadFail();
    }

    interface Presenter {
        void switch2Aty(int pos);
        ArrayList<String> loadData();
    }
}

package com.github.ostea.bmpoptimize.main;

import android.content.Context;
import android.content.Intent;
import android.widget.ListView;

import com.github.ostea.bmpoptimize.App.Constants;
import com.github.ostea.bmpoptimize.activity.matrix.MatrixActivity;
import com.github.ostea.bmpoptimize.activity.matrix.PatImageViewActivity;
import com.github.ostea.bmpoptimize.activity.matrix.RelectedBmpActivity;
import com.github.ostea.bmpoptimize.activity.svg.ShowSVGActivity;
import com.github.ostea.bmpoptimize.data.MainRepository;

import java.util.ArrayList;

/**
 * Desc:
 * Created by Thorn on 16/7/5.
 */
public class MainPresenter implements MainContract.Presenter {
    ListView mListView;
    MainContract.View mView;
    MainRepository mRepository;
    Context mContext;

    public MainPresenter(Context context, ListView mListView, MainContract.View mView) {
        this.mListView = mListView;
        this.mView = mView;
        this.mContext = context;
        this.mRepository = new MainRepository();
    }

    @Override
    public void switch2Aty(int pos) {
        switch (pos) {
            case Constants.SIMPLE_MATRIX:
                mContext.startActivity(new Intent(mContext,MatrixActivity.class));
                break;
            case Constants.SIMPLE_MATRIX_1:
                mContext.startActivity(new Intent(mContext,PatImageViewActivity.class));
                break;
            case Constants.SIMPLE_MATRIX_2:
                mContext.startActivity(new Intent(mContext,RelectedBmpActivity.class));
                break;
            case Constants.SVG_1:
                mContext.startActivity(new Intent(mContext,ShowSVGActivity.class));
                break;
        }

    }

    @Override
    public ArrayList<String> loadData() {
        ArrayList<String> data = new ArrayList<>();
        data = mRepository.getDatas();
        return data;
    }

}

package com.github.ostea.bmpoptimize.data;

import com.github.ostea.bmpoptimize.App.Constants;

import java.util.ArrayList;

/**
 * Desc:
 * Created by Thorn on 16/7/5.
 */
public class MainRepository {

    public ArrayList<String> getDatas() {
        ArrayList<String> mData=new ArrayList<>();
        mData.add(Constants.SIMPLE_MATRIX,"Android中图片变换Matrix的原理");
        mData.add(Constants.SIMPLE_MATRIX_1,"Android中图片变换Matrix的应用");
        mData.add(Constants.SIMPLE_MATRIX_2,"Android中图片变换Matrix的应用－倒影");
        mData.add(Constants.SVG_1,"Android中Vector矢量");
        return  mData;
    }
}

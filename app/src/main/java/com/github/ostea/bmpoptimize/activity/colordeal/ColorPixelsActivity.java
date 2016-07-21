package com.github.ostea.bmpoptimize.activity.colordeal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.github.ostea.bmpoptimize.R;
import com.github.ostea.bmpoptimize.util.ImageHelper;

/**
 * Desc:针对每一个像素点进行像素处理
 * Created by Thorn on 16/7/21.
 */
public class ColorPixelsActivity extends AppCompatActivity{

    ImageView iv_1,iv_2,iv_3,iv_4;
    Bitmap mBitmap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_color_pixels);

        iv_1= (ImageView) findViewById(R.id.imageview_1);
        iv_2= (ImageView) findViewById(R.id.imageview_2);
        iv_3= (ImageView) findViewById(R.id.imageview_3);
        iv_4= (ImageView) findViewById(R.id.imageview_4);

        mBitmap= BitmapFactory.decodeResource(getResources(),R.drawable.fbb);


        iv_1.setImageBitmap(mBitmap);//原图
        iv_2.setImageBitmap(ImageHelper.handleImageNegative(mBitmap));//底片效果
        iv_3.setImageBitmap(ImageHelper.handleImageOldPhoto(mBitmap));//怀旧效果
        iv_4.setImageBitmap(ImageHelper.handleImageArtStone(mBitmap));//浮雕效果
    }
}

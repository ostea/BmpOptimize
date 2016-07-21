package com.github.ostea.bmpoptimize.activity.colordeal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorMatrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

import com.github.ostea.bmpoptimize.R;

/**
 * Desc:  RGBA模型
 * Created by Thorn on 16/7/21.
 */
public class ImageColorActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_image_color);

    }
    public void primaryColor(View view) {
        startActivity(new Intent(ImageColorActivity.this,RGBAcrivity.class));
    }

    public void onColorMatrix(View v) {
        startActivity(new Intent(ImageColorActivity.this,ColorMatrixActivity.class));
    }
}

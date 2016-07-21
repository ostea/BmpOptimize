package com.github.ostea.bmpoptimize.activity.colordeal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.github.ostea.bmpoptimize.R;
import com.github.ostea.bmpoptimize.util.ImageHelper;

/**
 * Desc: 自然界中的色光三原色  三要素
 * 1.色调／色相  2.饱和度  3.亮度
 * Created by Thorn on 16/7/21.
 */
public class RGBAcrivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    ImageView mImageView;
    SeekBar sb_hue, sb_saturation, sb_lum;

    private int MAX_SB_VALUE = 255;
    private int MID_SB_VALIUE = 127;

    private float mHue, mStaturation, mLum;
    Bitmap bmp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_color_rgba);

        bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        mImageView = (ImageView) findViewById(R.id.imageview);


        sb_hue = (SeekBar) findViewById(R.id.sb_hue);
        sb_hue.setOnSeekBarChangeListener(this);
        sb_hue.setProgress(MID_SB_VALIUE);

        sb_saturation = (SeekBar) findViewById(R.id.sb_saturation);
        sb_saturation.setOnSeekBarChangeListener(this);
        sb_saturation.setProgress(MID_SB_VALIUE);


        sb_lum = (SeekBar) findViewById(R.id.sb_lum);
        sb_lum.setOnSeekBarChangeListener(this);
        sb_lum.setProgress(MID_SB_VALIUE);

        mImageView.setImageBitmap(bmp);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.sb_hue:
                mHue = (progress - MID_SB_VALIUE) * 1.0f / MID_SB_VALIUE * 180;
                break;
            case R.id.sb_saturation:
                mStaturation = progress * 1.0f / MID_SB_VALIUE;
                break;
            case R.id.sb_lum:
                mLum = progress * 1.0f / MID_SB_VALIUE;
                break;
        }
        mImageView.setImageBitmap(ImageHelper.handleImageEffect(bmp, mHue, mStaturation, mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

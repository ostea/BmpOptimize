package com.github.ostea.bmpoptimize.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Desc:
 * Created by Thorn on 16/7/21.
 */
public class ImageHelper {

    /**
     *
     * 对图片进行 简单处理
     * @param bm
     * @param hue  色相
     * @param saturation  饱和度
     * @param lum  明度
     *
     * **/
    public static Bitmap handleImageEffect(Bitmap bm,float hue,float saturation,float lum) {

        Bitmap bmp=Bitmap.createBitmap(bm.getWidth(),bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bmp);
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

        ColorMatrix hueMatrix=new ColorMatrix();
        hueMatrix.setRotate(0,hue);
        hueMatrix.setRotate(1,hue);
        hueMatrix.setRotate(2,hue);

        ColorMatrix saturationMaxtrix=new ColorMatrix();
        saturationMaxtrix.setSaturation(saturation);

        ColorMatrix lumMatrix=new ColorMatrix();
        lumMatrix.setScale(lum,lum,lum,1);

        ColorMatrix matrix=new ColorMatrix();
        matrix.postConcat(hueMatrix);
        matrix.postConcat(saturationMaxtrix);
        matrix.postConcat(lumMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(matrix));
        canvas.drawBitmap(bm,0,0,paint);
        return bmp;
    }

}

package com.github.ostea.bmpoptimize.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Desc:
 * Created by Thorn on 16/7/21.
 */
public class ImageHelper {

    /**
     * 对图片进行 简单处理
     *
     * @param bm
     * @param hue        色相
     * @param saturation 饱和度
     * @param lum        明度
     **/
    public static Bitmap handleImageEffect(Bitmap bm, float hue, float saturation, float lum) {

        Bitmap bmp = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        ColorMatrix hueMatrix = new ColorMatrix();
        hueMatrix.setRotate(0, hue);
        hueMatrix.setRotate(1, hue);
        hueMatrix.setRotate(2, hue);

        ColorMatrix saturationMaxtrix = new ColorMatrix();
        saturationMaxtrix.setSaturation(saturation);

        ColorMatrix lumMatrix = new ColorMatrix();
        lumMatrix.setScale(lum, lum, lum, 1);

        ColorMatrix matrix = new ColorMatrix();
        matrix.postConcat(hueMatrix);
        matrix.postConcat(saturationMaxtrix);
        matrix.postConcat(lumMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(matrix));
        canvas.drawBitmap(bm, 0, 0, paint);
        return bmp;
    }


    /**
     * 底片效果
     **/
    public static Bitmap handleImageNegative(Bitmap bm) {

        int width = bm.getWidth();
        int height = bm.getHeight();
        int color;
        int r, g, b, a;

        Bitmap bmp = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);

        int[] oldPixels = new int[width * height];
        int[] newPixels = new int[width * height];

        bm.getPixels(oldPixels, 0, width, 0, 0, width, height);
        for (int i = 0; i < width * height; i++) {
            color = oldPixels[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            r = 255 - r;
            g = 255 - g;
            b = 255 - b;

            if (r > 255)
                r = 255;
            else if (r < 0)
                r = 0;

            if (g > 255)
                g = 255;
            else if (g < 0)
                g = 0;

            if (b > 255)
                b = 255;
            else if (b < 0)
                b = 0;

            newPixels[i] = Color.argb(a, r, g, b);
        }
        bmp.setPixels(newPixels, 0, width, 0, 0, width, height);
        return bmp;
    }

    /**
     * 怀旧效果
     **/
    public static Bitmap handleImageOldPhoto(Bitmap bm) {

        int width = bm.getWidth();
        int height = bm.getHeight();
        int color;
        int r, g, b, a;
        int r1, g1, b1;

        Bitmap bmp = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);

        int[] oldPixels = new int[width * height];
        int[] newPixels = new int[width * height];

        bm.getPixels(oldPixels, 0, width, 0, 0, width, height);
        for (int i = 0; i < width * height; i++) {
            color = oldPixels[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            r1 = (int) (0.393 * r + 0.769 * g + 0.189 * b);
            g1 = (int) (0.349 * r + 0.686 * g + 0.168 * b);
            b1 = (int) (0.272 * r + 0.534 * g + 0.131 * b);

            if (r1 > 255)
                r1 = 255;
            else if (r1 < 0)
                r1 = 0;

            if (g1 > 255)
                g1 = 255;
            else if (g1 < 0)
                g1 = 0;

            if (b1 > 255)
                b1 = 255;
            else if (b1 < 0)
                b1 = 0;

            newPixels[i] = Color.argb(a, r1, g1, b1);
        }
        bmp.setPixels(newPixels, 0, width, 0, 0, width, height);
        return bmp;
    }

    /**
     * 浮雕效果
     **/
    public static Bitmap handleImageArtStone(Bitmap bm) {

        int width = bm.getWidth();
        int height = bm.getHeight();
        int colorBefore;
        int color;
        int r, g, b, a;
        int r1, g1, b1;

        Bitmap bmp = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);

        int[] oldPixels = new int[width * height];
        int[] newPixels = new int[width * height];

        bm.getPixels(oldPixels, 0, width, 0, 0, width, height);
        for (int i = 1; i < width * height; i++) {
            colorBefore = oldPixels[i - 1];
            r = Color.red(colorBefore);
            g = Color.green(colorBefore);
            b = Color.blue(colorBefore);
            a = Color.alpha(colorBefore);


            color = oldPixels[i];
            r1 = Color.red(color);
            g1 = Color.green(color);
            b1 = Color.blue(color);

            r = (r - r1 + 127);
            g = (g - g1 + 127);
            b = (b - b1 + 127);

            if (r > 255)
                r = 255;
            else if (r < 0)
                r = 0;

            if (g > 255)
                g = 255;
            else if (g < 0)
                g = 0;

            if (b > 255)
                b = 255;
            else if (b < 0)
                b = 0;

            newPixels[i] = Color.argb(a, r, g, b);
        }
        bmp.setPixels(newPixels, 0, width, 0, 0, width, height);
        return bmp;
    }
}

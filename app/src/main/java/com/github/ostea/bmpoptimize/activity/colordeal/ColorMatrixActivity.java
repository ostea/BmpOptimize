package com.github.ostea.bmpoptimize.activity.colordeal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.github.ostea.bmpoptimize.R;

/**
 * Desc:
 * Created by Thorn on 16/7/21.
 */
public class ColorMatrixActivity extends AppCompatActivity {

    private ImageView mImageView;
    GridLayout mGridLayout;
    Button btn_ok, btn_reset;
    Bitmap mbitmap;

    int mEditWidth, mEditHeight;

    EditText[] mEditTexts = new EditText[20];
    float[] mMatrixs = new float[20];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_color_matrix);


        mImageView = (ImageView) findViewById(R.id.imageview);
        mGridLayout = (GridLayout) findViewById(R.id.gridlayout);

        mbitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        mImageView.setImageBitmap(mbitmap);

        mGridLayout.post(new Runnable() {
            @Override
            public void run() {
                mEditWidth = mGridLayout.getWidth() / 5;
                mEditHeight = mGridLayout.getHeight() / 4;

                addEdittexts();
                initMatrixs();
            }
        });

        // 0.393 0.769 0.189
        //
    }

    private void addEdittexts() {
        for (int i = 0; i < 20; i++) {

            EditText editText = new EditText(ColorMatrixActivity.this);
            mEditTexts[i] = editText;
            mGridLayout.addView(editText, mEditWidth, mEditHeight);
        }
    }

    private void initMatrixs() {

        for (int i = 0; i < 20; i++) {
            if (i % 6 == 0) {
                mEditTexts[i].setText(String.valueOf(1));
                mMatrixs[i] = 1;
            } else {
                mEditTexts[i].setText(String.valueOf(0));
                mMatrixs[i] = 0;
            }
        }

    }

    private void getMatrixs() {
        for (int i = 0; i < 20; i++) {
            if (!TextUtils.isEmpty(mEditTexts[i].getText().toString())){
                mMatrixs[i] = Float.valueOf(mEditTexts[i].getText().toString().trim());
            }else{
                mMatrixs[i] = 0;
                mEditTexts[i].setText(String.valueOf(0));
            }
        }
    }

    private void setImageMatrix() {
        Bitmap bmp = Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), Bitmap.Config.ARGB_8888);
        ColorMatrix matrix = new ColorMatrix();
        matrix.set(mMatrixs);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColorFilter(new ColorMatrixColorFilter(matrix));
        canvas.drawBitmap(mbitmap, 0, 0, paint);
        mImageView.setImageBitmap(bmp);
    }

    public void onChangeMatrix(View v) {
        getMatrixs();
        setImageMatrix();
    }

    public void onReset(View v) {
        initMatrixs();
        setImageMatrix();
    }
}

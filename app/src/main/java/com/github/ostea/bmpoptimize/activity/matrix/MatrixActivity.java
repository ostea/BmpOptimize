package com.github.ostea.bmpoptimize.activity.matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.github.ostea.bmpoptimize.R;

/**
 * Desc:  matrix矩阵简单处理图片
 * Created by Thorn on 16/7/5.
 */
public class MatrixActivity extends AppCompatActivity implements View.OnTouchListener {
    TransformMatrixView mTransformMatrixView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mTransformMatrixView = new TransformMatrixView(this);
        mTransformMatrixView.setScaleType(ImageView.ScaleType.MATRIX);
        mTransformMatrixView.setOnTouchListener(this);
        setContentView(mTransformMatrixView);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
            Matrix matrix=new Matrix();
            // 输出图像的宽度和高度(72 x 72)
            Log.e("Test", "image size: width x height = " +
                    mTransformMatrixView.getBitmap().getWidth() + " x "
                    + mTransformMatrixView.getBitmap().getHeight());
//            //1.平移
//            matrix.postTranslate(mTransformMatrixView.getBitmap().getWidth(),mTransformMatrixView.getBitmap().getHeight());
//            mTransformMatrixView.setImageMatrix(matrix);
//
//            //2.旋转
//            matrix.setRotate(45f,mTransformMatrixView.getBitmap().getWidth()/2.0f,mTransformMatrixView.getBitmap().getHeight()/2.0f);
//            mTransformMatrixView.setImageMatrix(matrix);
//			// 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
//			matrix.postTranslate(mTransformMatrixView.getBitmap().getWidth() * 1.5f, 0f);
//            mTransformMatrixView.setImageMatrix(matrix);

//            //3.缩放
//            matrix.setScale(2f,2f);
//            mTransformMatrixView.setImageMatrix(matrix);

//            //4.错切变换
//            matrix.setSkew(0.5f,0.5f);

            //5.对称变换

            //float matrix_values[] = {1f, 0f, 0f, 0f, -1f, 0f, 0f, 0f, 1f};
            //matrix.setValues(matrix_values);
            // 做下面的平移变换，纯粹是为了让变换后的图像和原图像不重叠
			matrix.postTranslate(mTransformMatrixView.getBitmap().getWidth() * 1.5f, 0f);
            mTransformMatrixView.setImageMatrix(matrix);
            // 下面的代码是为了查看matrix中的元素 根号2 约等于 1.414
            float[] matrixValues = new float[9];
            matrix.getValues(matrixValues);
            for(int i = 0; i < 3; ++i) {
                String temp = new String();
                for(int j = 0; j < 3; ++j)
                {
                    temp += matrixValues[3 * i + j ] + "\t";
                }
                Log.e("Test", temp);
            }
            mTransformMatrixView.invalidate();

        }
        return true;
    }

    //验证我们的猜想
    class TransformMatrixView extends ImageView {

        private Bitmap mBitmap;
        private Matrix mMatrix;

        public TransformMatrixView(Context context) {
            super(context);
            mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            mMatrix = new Matrix();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            //画出原来的图像
            canvas.drawBitmap(mBitmap, 0, 0, null);
            //画出matrix矩阵变化后的图像
            canvas.drawBitmap(mBitmap, mMatrix, null);
            super.onDraw(canvas);
        }

        @Override
        public void setImageMatrix(Matrix matrix) {
            this.mMatrix.set(matrix);
            super.setImageMatrix(matrix);

        }

        public Bitmap getBitmap() {
            return mBitmap;
        }
    }
}

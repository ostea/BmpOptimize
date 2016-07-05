package com.github.ostea.bmpoptimize.activity.matrix;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.github.ostea.bmpoptimize.R;
import com.github.ostea.bmpoptimize.widget.PatImageView;

/**
 * Desc:
 * Created by Thorn on 16/7/5.
 */
public class PatImageViewActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        PatImageView piv = new PatImageView(this);
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        piv.setImageBitmap(bmp);

        setContentView(piv);
    }
}

package com.github.ostea.bmpoptimize.activity.svg;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.widget.ImageView;

import com.github.ostea.bmpoptimize.R;

/**
 * Desc:
 * Created by Thorn on 16/7/7.
 */
public class ShowSVGActivity extends AppCompatActivity{
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_show_svg);

        ImageView imageView = (ImageView) findViewById(R.id.iv);
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(
                this, R.drawable.anim_vector
        );
        imageView.setImageDrawable(animatedVectorDrawableCompat);
        ((Animatable) imageView.getDrawable()).start();
    }
}

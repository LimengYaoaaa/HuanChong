package com.jiyun.huanchong.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.security.MessageDigest;

/**
 * Created by 张龙辉 on 2017/12/13.
 */

public class Formation extends BitmapTransformation {
    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        if (toTransform == null) {
            return null;
        }
        int width = toTransform.getWidth();
        int height = toTransform.getHeight();
        int min = Math.min(width, height);
        int x = (width - min) / 2;
        int y = (height - min) / 2;


        Bitmap bitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);


        Canvas canvas = new Canvas(bitmap);


        Bitmap bitmap1 = Bitmap.createBitmap(toTransform, x, y, min, min);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        int r = min / 2;
        canvas.drawCircle(r, r, r, paint);
        return bitmap;
    }


    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {


    }
}
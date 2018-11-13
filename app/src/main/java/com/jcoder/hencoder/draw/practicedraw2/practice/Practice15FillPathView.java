package com.jcoder.hencoder.draw.practicedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice15FillPathView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();
    Path path1 = new Path();
    Path path2 = new Path();
    Path path3 = new Path();

    public Practice15FillPathView(Context context) {
        super(context);
    }

    public Practice15FillPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice15FillPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        pathPaint.setStrokeWidth(2);
        pathPaint.setColor(Color.RED);

        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
//        path.rLineTo(150, 80);

        pathPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Paint.getFillPath()和Paint.getTextPath()使用时要关闭硬件加速
        //Manifest.xml: android:hardwareAccelerated="false"

        // 使用 Paint.getFillPath() 获取实际绘制的 Path

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(0);
        // 第一处：获取 Path
        paint.getFillPath(path, path1);
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(300, 0);
        canvas.drawPath(path1, pathPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 150);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(40);
        paint.setPathEffect(null);
        // 第二处：设置 Style 为 STROKE 后再获取 Path
        paint.getFillPath(path, path2);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(300, 150);
        canvas.drawPath(path2, pathPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 300);
        paint.setStrokeWidth(40);
        paint.setPathEffect(new DashPathEffect(new float[]{10,5,25,10},0));
        // 第三处：Style 为 STROKE 并且线条宽度为 40 时的 Path
        paint.getFillPath(path, path3);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(300, 300);
        canvas.drawPath(path3, pathPaint);
        canvas.restore();
    }
}
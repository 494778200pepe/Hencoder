package com.jcoder.hencoder.draw.practicedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice13GetTextBoundsView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text1 = "A";
    String text2 = "anim_prop_menu1";
    String text3 = "J";
    String text4 = "j";
    String text5 = "Â";
    String text6 = "â";
    int top = 200;
    int bottom = 400;

    public Practice13GetTextBoundsView(Context context) {
        super(context);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差

        int middle = (top + bottom) / 2;
        Rect rect1 = new Rect();
        paint2.getTextBounds(text1, 0, text1.length(), rect1);
        Log.d("pepe", "left = -6 = " + rect1.left);
        Log.d("pepe", "right = 29 = " + rect1.right);
        Log.d("pepe", "top = -122 =" + rect1.top);
        Log.d("pepe", "bottom = 35 = " + rect1.bottom);
        Log.d("pepe", "width = 35 =" + rect1.width());
        Log.d("pepe", "height = 157 " + rect1.height());
        Paint.FontMetrics fm = paint2.getFontMetrics();
        Log.d("pepe", "ascent = -148.4375 = " + fm.ascent);
        Log.d("pepe", "descent = 39.0625 = " + fm.descent); //187.5
        Log.d("pepe", "top = -168.98438 =" + fm.top);
        Log.d("pepe", "bottom = 43.359375 = " + fm.bottom);
        Log.d("pepe", "leading = 0.0 =" + fm.leading);

        canvas.drawText(text1, 100, middle - (rect1.top + rect1.bottom) / 2, paint2);
        paint2.getTextBounds(text2, 0, text2.length(), rect1);
        canvas.drawText(text2, 200, middle - (rect1.top + rect1.bottom) / 2, paint2);
        paint2.getTextBounds(text3, 0, text3.length(), rect1);
        canvas.drawText(text3, 300, middle - (rect1.top + rect1.bottom) / 2, paint2);
        paint2.getTextBounds(text4, 0, text4.length(), rect1);

        canvas.drawText(text4, 400, middle - (rect1.top + rect1.bottom) / 2, paint2);
        paint2.getTextBounds(text5, 0, text5.length(), rect1);
        canvas.drawText(text5, 500, middle - (rect1.top + rect1.bottom) / 2, paint2);
        paint2.getTextBounds(text6, 0, text6.length(), rect1);
        canvas.drawText(text6, 600, middle - (rect1.top + rect1.bottom) / 2, paint2);

        //通过(rect1.top + rect1.bottom)/2  获取的是字符中间距离基线的偏差
        //如果用rect1.height() / 2，那么就是整个字符占用空间中心线距离底部的偏差了
    }
}
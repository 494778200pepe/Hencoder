package com.jcoder.hencoder.draw.practicedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jcoder.hencoder.R;


public class Practice02ClipPathView extends View {
    Paint paint = new Paint();
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(500, 200);

    public Practice02ClipPathView(Context context) {
        super(context);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        Path path1 = new Path();
        path1.addCircle(point1.x+bitmap.getWidth(),point1.y+bitmap.getHeight(),160, Path.Direction.CCW);
        canvas.clipPath(path1);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();


        canvas.save();
        Path path2 = new Path();
        path2.setFillType(Path.FillType.INVERSE_WINDING);
        path2.addCircle(point2.x+bitmap.getWidth(),point2.y+bitmap.getHeight(),160, Path.Direction.CCW);
        canvas.clipPath(path2);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);

        canvas.restore();
    }
}

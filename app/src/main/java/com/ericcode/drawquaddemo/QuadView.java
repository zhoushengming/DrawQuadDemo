package com.ericcode.drawquaddemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xiaoming on 2017/7/31.
 */

public class QuadView extends View {
    private Paint paint;
    private Paint drawPaint;
    private Paint textPaint;
    private Path path;
    private Path textPath;
    private Path quadPath;

    private AssistPoint assistPoint1 = new AssistPoint(400, 800);
    private AssistPoint endPoint = new AssistPoint(800, 1000);


    public QuadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaints();
    }

    private void initPaints() {
        this.paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);

        this.drawPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        drawPaint.setStyle(Paint.Style.FILL);
        drawPaint.setColor(Color.GRAY);

        this.path = new Path();
        path.moveTo(100, 100);
        path.lineTo(200, 200);
        path.lineTo(300, 200);
        path.lineTo(200, 100);
        path.close();

        this.textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.RED);
        textPaint.setTextSize(40);

        this.textPath = new Path();
        textPath.moveTo(200, 900);
        textPath.lineTo(300, 940);
        textPath.lineTo(400, 900);
        textPath.lineTo(500, 940);
        textPath.lineTo(600, 900);
        textPath.lineTo(700, 940);
        textPath.lineTo(800, 900);
        textPath.lineTo(900, 940);
        textPath.lineTo(1000, 900);

        this.quadPath = new Path();
        quadPath.moveTo(100, 1000);
        quadPath.quadTo(assistPoint1.x, assistPoint1.y, endPoint.x, endPoint.y);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPaint(drawPaint);
        canvas.save();
        canvas.restore();

        canvas.drawCircle(300, 600, 100, paint);
        canvas.save();
        canvas.restore();

        canvas.drawLine(0, 600, 300, 600, paint);
        canvas.save();
        canvas.restore();

        canvas.drawLines(new float[]{600, 600, 800, 600, 800, 800, 800, 600, 800, 800, 600, 800, 600, 800, 600, 600}, paint);
        canvas.save();
        canvas.restore();

        canvas.drawPath(path, paint);
        canvas.save();
        canvas.restore();

        canvas.drawPoint(400, 190, paint);

        canvas.drawPoints(new float[]{410, 200, 420, 210, 430, 220, 440, 230, 450, 240,}, paint);
        canvas.save();
        canvas.restore();

        canvas.drawRect(600, 10, 700, 50, paint);

//        canvas.drawRoundRect(600, 200, 700, 400, 30, 30, paint);

        canvas.drawText("aadfsd", 600, 400, textPaint);

        canvas.drawTextOnPath("abcdefghijklmnopqrstuvwxyz", quadPath, 40, 40, textPaint);

        canvas.drawPath(quadPath,paint);

    }

    static class AssistPoint {
        int x, y;

        public AssistPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

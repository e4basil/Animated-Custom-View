package com.basil.test.loadingview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Locale;

/**
 * Created by basi on 23/3/17.
 */

public class LoadingView extends View {

    private static final String FPS = "FPS: %d";
    private LoadingComputations loadingComputations;
    private Paint dotPaint, fpsPaint;
    private FramesManager framesManager;

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        loadingComputations = new LoadingComputations(getResources().getDisplayMetrics().density);
        framesManager = new FramesManager();
        dotPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        dotPaint.setColor(0xFFB0B0B0);

        fpsPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fpsPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension((int) loadingComputations.dpToPx(100), (int) loadingComputations.dpToPx(100));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(
                String.format(Locale.getDefault(), FPS, framesManager.fps()),
                0.f,
                fpsPaint.getTextSize(),
                fpsPaint);
        canvas.drawCircle(
                loadingComputations.dpToPx(50)-loadingComputations.dpToPx(10),
                loadingComputations.dpToPx(50)-loadingComputations.dpToPx(20) * (float) loadingComputations.verticalPosition(System.currentTimeMillis(), 0L),
                loadingComputations.dpToPx(3),
                dotPaint);
        canvas.drawCircle(
                loadingComputations.dpToPx(50)-loadingComputations.dpToPx(0),
                loadingComputations.dpToPx(50)-loadingComputations.dpToPx(20) * (float) loadingComputations.verticalPosition(System.currentTimeMillis(), 125L),
                loadingComputations.dpToPx(3),
                dotPaint);
        canvas.drawCircle(
                loadingComputations.dpToPx(50)+loadingComputations.dpToPx(10),
                loadingComputations.dpToPx(50)-loadingComputations.dpToPx(20) * (float) loadingComputations.verticalPosition(System.currentTimeMillis(), 250L),
                loadingComputations.dpToPx(3),
                dotPaint);
        framesManager.frame();
        invalidate();
    }
}

package net.sourceforge.simcpux.customviewsawtoothstyle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

/**
 * Created by shaomiao on 2016-10-17.
 */

public class CanvasTest4 extends View {
    Paint paint;
    DisplayMetrics dm;
    int heigth;
    int width;
    int triangle_height;
    int triangle_width;
    private  void init(){
        dm= new DisplayMetrics();
        ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(dm);
        paint = new Paint();
        //是否设置抗锯齿效果
        paint.setAntiAlias(true);
        //paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getResources().getColor(R.color.black));
        //paint.setTextSize((float) 2.0);
        //paint.setStrokeWidth(3);
        this.heigth= (int) (30*dm.density);
        this.width= (int) (dm.widthPixels*dm.density);
        this.triangle_width= (int) (12*dm.density);
        this.triangle_height=(int)(6*dm.density);

    }

    public CanvasTest4(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasTest4(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CanvasTest4(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public CanvasTest4(Context context) {
        super(context);
        init();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Path path = new Path(); //定义一条路径
        Log.e("aaa", "onDraw: "+heigth);
        path.moveTo(0,0);
        int i=1;
        for(;i<width/triangle_width;i++){
            path.lineTo(triangle_width/2*i,i%2==0?0:triangle_height);
        }
        path.lineTo(triangle_width/2*i,0);
        path.lineTo(triangle_width/2*i,heigth);
        path.lineTo(0,heigth);
        path.lineTo(0,0);
        canvas.drawPath(path, paint);
    }
}

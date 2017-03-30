package com.bawei.yuekaoA;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 1 on 2017/3/29.
 */
public class MyView extends View
{

    private float downx;
    private float downy;
    private int width;
    private int height;

    //定义接口
    public interface  jiekou
    {
        //定义抽象类  园内  园外
         void yuannei();
         void yuanwai();
    }
    //定义从参数
    private jiekou mjiekou;
    //定义接口的方法
    public void setMjiekou(jiekou mjiekou)
    {
        this.mjiekou = mjiekou;
    }

    private Paint mPaint;

    public MyView(Context context)
    {
        super(context);
    }


    public MyView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        //设置画笔
        mPaint = new Paint();
    }


    public MyView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.RED);
        width = getWidth() / 2;
        height = getHeight() / 2;


        //在中心位置设个正方形
        canvas.drawRect(width -100,height-100, width +100,height+100,mPaint);
        //消除锯齿
        mPaint.setAntiAlias(true);
         mPaint.setColor(Color.YELLOW);
        //设置外圆
        canvas.drawCircle(width,height,100,mPaint);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
        //设置内圆
        canvas.drawCircle(width,height,50,mPaint);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(30);
        //设置字体
        canvas.drawText("赵正亨",width-mPaint.measureText("赵正亨")/2,height,mPaint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                //得到按下的X和Y值
                downx = event.getX();
                downy = event.getY();

                break;
            case MotionEvent.ACTION_UP:
                //得到抬起的X和Y值
                float upx =  event.getX();
                float upy = event.getY();
                //判断如果按下与抬起相同
               if(downx==upx&&downy==upy)
               {
                   //利用勾股定理
                   float v = (upx - width)*(upx - width)+(upy - height) * (upy - height);
                   double sqrt = Math.sqrt(v);
                   //如果点击位置小于园内的半径
                   if(sqrt<50)
                   {
                       if(mjiekou != null)
                       {
                           mjiekou.yuannei();
                       }

                   }//如果点击位置大于xiao园内的半径  小于大院的半径
                   else if(50<sqrt&&sqrt<100)
                   {

                       if(mjiekou!=null)
                       {
                           mjiekou.yuanwai();
                       }

                   }
               }




                break;
        }


        return true;
    }

}

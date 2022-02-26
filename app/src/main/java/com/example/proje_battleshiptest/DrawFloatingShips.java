package com.example.proje_battleshiptest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class DrawFloatingShips extends SurfaceView {

    private Paint blackPaint = new Paint();


    public DrawFloatingShips(Context context) {//default constructor,
        super(context);
        initPaints();
        setWillNotDraw(false);//sets visible
    }

    public DrawFloatingShips(Context context, AttributeSet attirs){
        super(context, attirs);
        initPaints();
        setWillNotDraw(false);//sets visible
    }

    public DrawFloatingShips(Context context, AttributeSet attirs, int defStyle){
        super(context, attirs, defStyle);
        initPaints();
        setWillNotDraw(false);//sets visible
    }

    private void initPaints(){
        this.blackPaint.setColor(0xFFFF0000);
        this.blackPaint.setStyle(Paint.Style.FILL);
    }


    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        //FLOAT - like a double but half the number of bits
        //drawOval(x,y x2, y2, paint);
        Bitmap ships = BitmapFactory.decodeResource(getResources(), R.drawable.ships);
        ships =  Bitmap.createScaledBitmap(ships, 200, 1200, false);
        canvas.drawBitmap(ships, 0.0f, 0.0f, new Paint());
    }


}

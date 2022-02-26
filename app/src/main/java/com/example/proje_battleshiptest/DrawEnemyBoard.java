package com.example.proje_battleshiptest;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class DrawEnemyBoard extends SurfaceView{

    private Paint blackPaint = new Paint();

    public DrawEnemyBoard(Context context) {//default constructor,
        super(context);
        initPaints();
        setWillNotDraw(false);//sets visible
    }

    public DrawEnemyBoard(Context context, AttributeSet attirs){
        super(context, attirs);
        initPaints();
        setWillNotDraw(false);//sets visible
    }

    public DrawEnemyBoard(Context context, AttributeSet attirs, int defStyle){
        super(context, attirs, defStyle);
        initPaints();
        setWillNotDraw(false);//sets visible
    }

    private void initPaints(){
        this.blackPaint.setColor(0xFF00FF00);
        this.blackPaint.setStyle(Paint.Style.FILL);
    }


    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        //FLOAT - like a double but half the number of bits
        //drawOval(x,y x2, y2, paint);

        //
        canvas.drawRect(0.0f, 0.0f, 50.0f, 50.f, blackPaint);

        //Draws the board for the use will use to select and play their move
        Bitmap grid = BitmapFactory.decodeResource(getResources(), R.drawable.updatedgrid);
        grid =  Bitmap.createScaledBitmap(grid, 1200, 1150, false);

        //When user hits a ship a red marker will be placed
        Bitmap redMarker = BitmapFactory.decodeResource(getResources(), R.drawable.hitmarker);
        redMarker =  Bitmap.createScaledBitmap(redMarker, 200, 150, false);

        //A missed shot will be indicated with a white marker
        Bitmap whiteMarker = BitmapFactory.decodeResource(getResources(), R.drawable.missmarker);
        whiteMarker =  Bitmap.createScaledBitmap(whiteMarker, 200, 150, false);

        //When the user selects their move the COOR will be identified with a target
        Bitmap userSelection = BitmapFactory.decodeResource(getResources(), R.drawable.tagetselector);
        userSelection =  Bitmap.createScaledBitmap(userSelection, 200, 150, false);


        /**
         * Draws everything to surface view, as of now COOR is just giberish and guess work, will work out
         *a formula later
         */

        canvas.drawBitmap(grid, 0.0f, 0.0f, new Paint());
        canvas.drawBitmap(whiteMarker, 140.0f, 250.0f, new Paint());
        canvas.drawBitmap(redMarker, 410.0f, 250.0f, new Paint());
        canvas.drawBitmap(userSelection, 410.0f, 325.0f, new Paint());
    }

}

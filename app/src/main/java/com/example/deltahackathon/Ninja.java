package com.example.deltahackathon;

import static com.example.deltahackathon.GameView.screenRatioX;
import static com.example.deltahackathon.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;

public class Ninja {

    float x,y,width,height;
    public static float base;
    Bitmap ninjaRun1,ninjaRun2,ninjaRun3,ninjaRun4,ninjaRun5,ninjaRun6,ninjaRun7,ninjaRun8,ninjaRun9,ninjaRun10;
    Boolean atBase=true,ninjaJump=false,ninjaUpward=false,ninjaDownward=false;

    Ninja(Resources res){
        ninjaRun1= BitmapFactory.decodeResource(res,R.drawable.run1);
        ninjaRun2= BitmapFactory.decodeResource(res,R.drawable.run2);
        ninjaRun3= BitmapFactory.decodeResource(res,R.drawable.run3);
        ninjaRun4= BitmapFactory.decodeResource(res,R.drawable.run4);
        ninjaRun5= BitmapFactory.decodeResource(res,R.drawable.run5);
        ninjaRun6= BitmapFactory.decodeResource(res,R.drawable.run6);
        ninjaRun7= BitmapFactory.decodeResource(res,R.drawable.run7);
        ninjaRun8= BitmapFactory.decodeResource(res,R.drawable.run8);
        ninjaRun9= BitmapFactory.decodeResource(res,R.drawable.run9);
        ninjaRun10= BitmapFactory.decodeResource(res,R.drawable.run10);

        width=ninjaRun1.getWidth();
        height=ninjaRun1.getHeight();

        width/=3;
        height/=2;

        width*=screenRatioX;
        height*=screenRatioY;

        ninjaRun1=Bitmap.createScaledBitmap(ninjaRun1,(int)width,(int)height,false);
        base=(900)*screenRatioY;
        y=(900)*screenRatioY-height;
        x=150*screenRatioX;

    }

    Bitmap getBall(){

        return ninjaRun1;
    }

    RectF getCollisionShape(){

        return new RectF(x,y,x+width,y+height);
    }

}

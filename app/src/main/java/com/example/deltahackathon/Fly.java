package com.example.deltahackathon;

import static com.example.deltahackathon.GameView.screenRatioX;
import static com.example.deltahackathon.GameView.screenRatioY;
import static com.example.deltahackathon.Ninja.base;
import static com.example.deltahackathon.Ninja.runy;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;

public class Fly {
    float x,y;
    float width,height;
    Bitmap fly1,fly2,fly3,fly4,fly5,fly6,fly7;

    Fly(float screenX, float screenY, Resources res) {

        fly1 = BitmapFactory.decodeResource(res, R.drawable.fly1);
        fly2 = BitmapFactory.decodeResource(res, R.drawable.fly2);
        fly3 = BitmapFactory.decodeResource(res, R.drawable.fly3);
        fly4 = BitmapFactory.decodeResource(res, R.drawable.fly4);
        fly5 = BitmapFactory.decodeResource(res, R.drawable.fly5);
        fly6 = BitmapFactory.decodeResource(res, R.drawable.fly6);
        fly7 = BitmapFactory.decodeResource(res, R.drawable.fly7);

        width = fly1.getWidth();
        height = fly1.getHeight();

        width *= 2;
        height *= 2;

        width *= screenRatioX;
        height *= screenRatioY;

        fly1 = Bitmap.createScaledBitmap(fly1, (int) width, (int) height, false);
        fly2 = Bitmap.createScaledBitmap(fly2, (int) width, (int) height, false);
        fly3 = Bitmap.createScaledBitmap(fly3, (int) width, (int) height, false);
        fly4 = Bitmap.createScaledBitmap(fly4, (int) width, (int) height, false);
        fly5 = Bitmap.createScaledBitmap(fly5, (int) width, (int) height, false);
        fly6 = Bitmap.createScaledBitmap(fly6, (int) width, (int) height, false);
        fly7 = Bitmap.createScaledBitmap(fly7, (int) width, (int) height, false);

        base = (1000) * screenRatioY;
        y = runy+(20*screenRatioY);
        x = screenX;
    }

    Bitmap getFly(int flyFrame){
        if(flyFrame==1){
            return fly1;
        }
        else if(flyFrame==2){
            return fly2;
        }
        else if(flyFrame==3){
            return fly3;
        }
        else if(flyFrame==4){
            return fly4;
        }
        else if(flyFrame==5){
            return fly5;
        }
        else if(flyFrame==6){
            return fly6;
        }
        else{
            return fly7;
        }
    }

    RectF getFlyShape(){
        return new RectF(x,y,x+width,y+height);
    }
}



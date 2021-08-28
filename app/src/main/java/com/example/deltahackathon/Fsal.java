package com.example.deltahackathon;

import static com.example.deltahackathon.GameView.screenRatioX;
import static com.example.deltahackathon.GameView.screenRatioY;
import static com.example.deltahackathon.Ninja.base;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;

public class Fsal {

    float x,y;
    float width,height;
    Bitmap fsal1,fsal2,fsal3,fsal4,fsal5,fsal6,fsal7,fsal8,fsal9,fsal10;


    Fsal(float screenX, float screenY, Resources res) {

        fsal1 = BitmapFactory.decodeResource(res, R.drawable.fsal1);
        fsal2 = BitmapFactory.decodeResource(res, R.drawable.fsal2);
        fsal3 = BitmapFactory.decodeResource(res, R.drawable.fsal3);
        fsal4 = BitmapFactory.decodeResource(res, R.drawable.fsal4);
        fsal5 = BitmapFactory.decodeResource(res, R.drawable.fsal5);
        fsal6 = BitmapFactory.decodeResource(res, R.drawable.fsal6);
        fsal7 = BitmapFactory.decodeResource(res, R.drawable.fsal7);
        fsal8 = BitmapFactory.decodeResource(res, R.drawable.fsal8);
        fsal9 = BitmapFactory.decodeResource(res, R.drawable.fsal9);
        fsal10 = BitmapFactory.decodeResource(res, R.drawable.fsal10);

        width = fsal1.getWidth();
        height = fsal1.getHeight();

        width /= 4;
        height /= 4;

        width *= screenRatioX;
        height *= screenRatioY;

        fsal1 = Bitmap.createScaledBitmap(fsal1, (int) width, (int) height, false);
        fsal2 = Bitmap.createScaledBitmap(fsal2, (int) width, (int) height, false);
        fsal3 = Bitmap.createScaledBitmap(fsal3, (int) width, (int) height, false);
        fsal4 = Bitmap.createScaledBitmap(fsal4, (int) width, (int) height, false);
        fsal5 = Bitmap.createScaledBitmap(fsal5, (int) width, (int) height, false);
        fsal6 = Bitmap.createScaledBitmap(fsal6, (int) width, (int) height, false);
        fsal7 = Bitmap.createScaledBitmap(fsal7, (int) width, (int) height, false);
        fsal8 = Bitmap.createScaledBitmap(fsal8, (int) width, (int) height, false);
        fsal9 = Bitmap.createScaledBitmap(fsal9, (int) width, (int) height, false);
        fsal10 = Bitmap.createScaledBitmap(fsal10, (int) width, (int) height, false);

        base = (1000) * screenRatioY;
        y = base - height;
        x = screenX;
    }

    Bitmap getFsal(int fsalFrame){
        if(fsalFrame==1){
            return fsal1;
        }
        else if(fsalFrame==2){
            return fsal2;
        }
        else if(fsalFrame==3){
            return fsal3;
        }
        else if(fsalFrame==4){
            return fsal4;
        }
        else if(fsalFrame==5){
            return fsal5;
        }
        else if(fsalFrame==6){
            return fsal6;
        }
        else if(fsalFrame==7){
            return fsal7;
        }
        else if(fsalFrame==8){
            return fsal8;
        }
        else if(fsalFrame==9){
            return fsal9;
        }
        else {
            return fsal10;
        }
    }

    RectF getFsalShape(){
        return new RectF(+30,y+50,x+width-30,y+height-30);
    }

}

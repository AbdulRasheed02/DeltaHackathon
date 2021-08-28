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
    Boolean atBase=true,ninjaRun=true,ninjaJump=false,ninjaUpward=false,ninjaDownward=false;

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

        width/=4;
        height/=4;

        width*=screenRatioX;
        height*=screenRatioY;

        ninjaRun1=Bitmap.createScaledBitmap(ninjaRun1,(int)width,(int)height,false);
        ninjaRun2=Bitmap.createScaledBitmap(ninjaRun2,(int)width,(int)height,false);
        ninjaRun3=Bitmap.createScaledBitmap(ninjaRun3,(int)width,(int)height,false);
        ninjaRun4=Bitmap.createScaledBitmap(ninjaRun4,(int)width,(int)height,false);
        ninjaRun5=Bitmap.createScaledBitmap(ninjaRun5,(int)width,(int)height,false);
        ninjaRun6=Bitmap.createScaledBitmap(ninjaRun6,(int)width,(int)height,false);
        ninjaRun7=Bitmap.createScaledBitmap(ninjaRun7,(int)width,(int)height,false);
        ninjaRun8=Bitmap.createScaledBitmap(ninjaRun8,(int)width,(int)height,false);
        ninjaRun9=Bitmap.createScaledBitmap(ninjaRun9,(int)width,(int)height,false);
        ninjaRun10=Bitmap.createScaledBitmap(ninjaRun10,(int)width,(int)height,false);

        base=(1000)*screenRatioY;
        y=base-height;
        x=150*screenRatioX;

    }

    Bitmap getNinjaRun(int ninjaRunFrame){
        if(ninjaRunFrame==1){
            return ninjaRun1;
        }
        else if(ninjaRunFrame==2){
            return ninjaRun2;
        }
        else if(ninjaRunFrame==3){
            return ninjaRun3;
        }
        else if(ninjaRunFrame==4){
            return ninjaRun4;
        }
        else if(ninjaRunFrame==5){
            return ninjaRun5;
        }
        else if(ninjaRunFrame==6){
            return ninjaRun6;
        }
        else if(ninjaRunFrame==7){
            return ninjaRun7;
        }
        else if(ninjaRunFrame==8){
            return ninjaRun8;
        }
        else if(ninjaRunFrame==9){
            return ninjaRun9;
        }
        else {
            return ninjaRun10;
        }
    }

    RectF getCollisionShape(){
        return new RectF(x,y,x+width,y+height);
    }

}

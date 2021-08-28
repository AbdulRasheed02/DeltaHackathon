package com.example.deltahackathon;

import static com.example.deltahackathon.GameView.screenRatioX;
import static com.example.deltahackathon.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;

public class Ninja {

    public static float runy;
    float runx,attackx,attacky,jumpx,jumpy,slidex,slidey;
    float runWidth,runHeight,jumpWidth,jumpHeight,attackWidth,attackHeight,slideWidth,slideHeight;
    public static float base;
    Bitmap ninjaRun1,ninjaRun2,ninjaRun3,ninjaRun4,ninjaRun5,ninjaRun6,ninjaRun7,ninjaRun8,ninjaRun9,ninjaRun10;
    Bitmap ninjaAttack1,ninjaAttack2,ninjaAttack3,ninjaAttack4,ninjaAttack5,ninjaAttack6,ninjaAttack7,ninjaAttack8,ninjaAttack9,ninjaAttack10;
    Bitmap ninjaSlide1;
    Bitmap ninjaJump1,ninjaJump2,ninjaJump3,ninjaJump4,ninjaJump5,ninjaJump6,ninjaJump7,ninjaJump8,ninjaJump9,ninjaJump10;
    Boolean atBase=true,ninjaRun=true,ninjaJump=false,ninjaSlide=false,ninjaAttack=false,ninjaUpward=false,ninjaDownward=false;

    Ninja(Resources res){
        initNinjaRun(res);
        initNinjaAttack(res);
        initNinjaSlide(res);
        initNinjaJump(res);
    }

    private void initNinjaRun(Resources res) {
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

        runWidth=ninjaRun1.getWidth();
        runHeight=ninjaRun1.getHeight();

        runWidth/=4;
        runHeight/=4;

        runWidth*=screenRatioX;
        runHeight*=screenRatioY;

        ninjaRun1=Bitmap.createScaledBitmap(ninjaRun1,(int)runWidth,(int)runHeight,false);
        ninjaRun2=Bitmap.createScaledBitmap(ninjaRun2,(int)runWidth,(int)runHeight,false);
        ninjaRun3=Bitmap.createScaledBitmap(ninjaRun3,(int)runWidth,(int)runHeight,false);
        ninjaRun4=Bitmap.createScaledBitmap(ninjaRun4,(int)runWidth,(int)runHeight,false);
        ninjaRun5=Bitmap.createScaledBitmap(ninjaRun5,(int)runWidth,(int)runHeight,false);
        ninjaRun6=Bitmap.createScaledBitmap(ninjaRun6,(int)runWidth,(int)runHeight,false);
        ninjaRun7=Bitmap.createScaledBitmap(ninjaRun7,(int)runWidth,(int)runHeight,false);
        ninjaRun8=Bitmap.createScaledBitmap(ninjaRun8,(int)runWidth,(int)runHeight,false);
        ninjaRun9=Bitmap.createScaledBitmap(ninjaRun9,(int)runWidth,(int)runHeight,false);
        ninjaRun10=Bitmap.createScaledBitmap(ninjaRun10,(int)runWidth,(int)runHeight,false);

        base=(1000)*screenRatioY;
        runy=base-runHeight;
        runx=150*screenRatioX;
    }

    private void initNinjaJump(Resources res) {
        ninjaJump1=BitmapFactory.decodeResource(res,R.drawable.jump1);
        ninjaJump2=BitmapFactory.decodeResource(res,R.drawable.jump2);
        ninjaJump3=BitmapFactory.decodeResource(res,R.drawable.jump3);
        ninjaJump4=BitmapFactory.decodeResource(res,R.drawable.jump4);
        ninjaJump5=BitmapFactory.decodeResource(res,R.drawable.jump5);
        ninjaJump6=BitmapFactory.decodeResource(res,R.drawable.jump6);
        ninjaJump7=BitmapFactory.decodeResource(res,R.drawable.jump7);
        ninjaJump8=BitmapFactory.decodeResource(res,R.drawable.jump8);
        ninjaJump9=BitmapFactory.decodeResource(res,R.drawable.jump9);
        ninjaJump10=BitmapFactory.decodeResource(res,R.drawable.jump10);

        jumpWidth=ninjaJump1.getWidth();
        jumpHeight=ninjaJump1.getHeight();

        jumpWidth/=4;
        jumpHeight/=4;

        jumpWidth*=screenRatioX;
        jumpHeight*=screenRatioY;

        ninjaJump1=Bitmap.createScaledBitmap(ninjaJump1,(int)jumpWidth,(int)jumpHeight,false);
        ninjaJump2=Bitmap.createScaledBitmap(ninjaJump2,(int)jumpWidth,(int)jumpHeight,false);
        ninjaJump3=Bitmap.createScaledBitmap(ninjaJump3,(int)jumpWidth,(int)jumpHeight,false);
        ninjaJump4=Bitmap.createScaledBitmap(ninjaJump4,(int)jumpWidth,(int)jumpHeight,false);
        ninjaJump5=Bitmap.createScaledBitmap(ninjaJump5,(int)jumpWidth,(int)jumpHeight,false);
        ninjaJump6=Bitmap.createScaledBitmap(ninjaJump6,(int)jumpWidth,(int)jumpHeight,false);
        ninjaJump7=Bitmap.createScaledBitmap(ninjaJump7,(int)jumpWidth,(int)jumpHeight,false);
        ninjaJump8=Bitmap.createScaledBitmap(ninjaJump8,(int)jumpWidth,(int)jumpHeight,false);
        ninjaJump9=Bitmap.createScaledBitmap(ninjaJump9,(int)jumpWidth,(int)jumpHeight,false);
        ninjaJump10=Bitmap.createScaledBitmap(ninjaJump10,(int)jumpWidth,(int)jumpHeight,false);

        base=(1000)*screenRatioY;
        jumpy=base-jumpHeight;
        jumpx=150*screenRatioX;

    }

    private void initNinjaSlide(Resources res) {
        ninjaSlide1=BitmapFactory.decodeResource(res,R.drawable.slide1);

        slideWidth=ninjaSlide1.getWidth();
        slideHeight=ninjaSlide1.getHeight();

        slideWidth/=5;
        slideHeight/=4;

        slideWidth*=screenRatioX;
        slideHeight*=screenRatioY;

        ninjaSlide1=Bitmap.createScaledBitmap(ninjaSlide1,(int)slideWidth,(int)slideHeight,false);

        base=(1000)*screenRatioY;
        slidey=base-slideHeight;
        slidex=150*screenRatioX;
    }

    private void initNinjaAttack(Resources res) {
        ninjaAttack1=BitmapFactory.decodeResource(res,R.drawable.attack1);
        ninjaAttack2=BitmapFactory.decodeResource(res,R.drawable.attack2);
        ninjaAttack3=BitmapFactory.decodeResource(res,R.drawable.attack3);
        ninjaAttack4=BitmapFactory.decodeResource(res,R.drawable.attack4);
        ninjaAttack5=BitmapFactory.decodeResource(res,R.drawable.attack5);
        ninjaAttack6=BitmapFactory.decodeResource(res,R.drawable.attack6);
        ninjaAttack7=BitmapFactory.decodeResource(res,R.drawable.attack7);
        ninjaAttack8=BitmapFactory.decodeResource(res,R.drawable.attack8);
        ninjaAttack9=BitmapFactory.decodeResource(res,R.drawable.attack9);
        ninjaAttack10=BitmapFactory.decodeResource(res,R.drawable.attack10);

        attackWidth=ninjaAttack1.getWidth();
        attackHeight=ninjaAttack1.getHeight();

        attackWidth/=5;
        attackHeight/=4;

        attackWidth*=screenRatioX;
        attackHeight*=screenRatioY;

        ninjaAttack1=Bitmap.createScaledBitmap(ninjaAttack1,(int)attackWidth,(int)attackHeight,false);
        ninjaAttack2=Bitmap.createScaledBitmap(ninjaAttack2,(int)attackWidth,(int)attackHeight,false);
        ninjaAttack3=Bitmap.createScaledBitmap(ninjaAttack3,(int)attackWidth,(int)attackHeight,false);
        ninjaAttack4=Bitmap.createScaledBitmap(ninjaAttack4,(int)attackWidth,(int)attackHeight,false);
        ninjaAttack5=Bitmap.createScaledBitmap(ninjaAttack5,(int)attackWidth,(int)attackHeight,false);
        ninjaAttack6=Bitmap.createScaledBitmap(ninjaAttack6,(int)attackWidth,(int)attackHeight,false);
        ninjaAttack7=Bitmap.createScaledBitmap(ninjaAttack7,(int)attackWidth,(int)attackHeight,false);
        ninjaAttack8=Bitmap.createScaledBitmap(ninjaAttack8,(int)attackWidth,(int)attackHeight,false);
        ninjaAttack9=Bitmap.createScaledBitmap(ninjaAttack9,(int)attackWidth,(int)attackHeight,false);
        ninjaAttack10=Bitmap.createScaledBitmap(ninjaAttack10,(int)attackWidth,(int)attackHeight,false);


        base=(1000)*screenRatioY;
        attacky=base-attackHeight;
        attackx=150*screenRatioX;
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

    Bitmap getNinjaJump(int ninjaJumpFrame){
        if(ninjaJumpFrame==1){
            return ninjaJump1;
        }
        else if(ninjaJumpFrame==2){
            return ninjaJump2;
        }
        else if(ninjaJumpFrame==3){
            return ninjaJump3;
        }
        else if(ninjaJumpFrame==4){
            return ninjaJump4;
        }
        else if(ninjaJumpFrame==5){
            return ninjaJump5;
        }
        else if(ninjaJumpFrame==6){
            return ninjaJump6;
        }
        else if(ninjaJumpFrame==7){
            return ninjaJump7;
        }
        else if(ninjaJumpFrame==8){
            return ninjaJump8;
        }
        else if(ninjaJumpFrame==9){
            return ninjaJump9;
        }
        else {
            return  ninjaJump10;
        }
    }

    Bitmap getNinjaAttack(int ninjaAttackFrame){
        if(ninjaAttackFrame==1){
            return ninjaAttack1;
        }
        else if(ninjaAttackFrame==2){
            return ninjaAttack2;
        }
        else if(ninjaAttackFrame==3){
            return ninjaAttack3;
        }
        else if(ninjaAttackFrame==4){
            return ninjaAttack4;
        }
        else if(ninjaAttackFrame==5){
            return ninjaAttack5;
        }
        else if(ninjaAttackFrame==6){
            return ninjaAttack6;
        }
        else if(ninjaAttackFrame==7){
            return ninjaAttack7;
        }
        else if(ninjaAttackFrame==8){
            return ninjaAttack8;
        }
        else if(ninjaAttackFrame==9){
            return ninjaAttack9;
        }
        else {
            return ninjaAttack10;
        }
    }

    Bitmap getNinjaSlide(){
       return ninjaSlide1;
    }


    RectF getRunCollisionShape(){
        return new RectF(runx+20,runy+20,runx+runWidth-20,runy+runHeight-20);
    }

    RectF getAttackCollisionShape(){
        return new RectF(attackx+20,attacky+20,attackx+attackWidth-20,attacky+attackHeight-20);
    }

    RectF getJumpCollisionShape(){
        return new RectF(jumpx+20,jumpy+20,jumpx+jumpWidth-20,jumpy+jumpHeight-20);
    }

    RectF getSlideCollisionShape(){
        return new RectF(slidex+20,slidey+20,slidex+slideWidth-20,slidey+slideHeight-20);
    }

}

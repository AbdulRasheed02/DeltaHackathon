package com.example.deltahackathon;

import static com.example.deltahackathon.Ninja.base;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.util.Random;

public class GameView extends SurfaceView implements Runnable {

    Thread thread;
    boolean canDraw;

    public static float screenRatioX, screenRatioY;
    private float screenX,screenY;

    float circlex,circley,circleRadius;

    private BackGround backGround1,backGround2;
    private Ninja ninja;
    private Fsal fsal;
    private Fly fly;

    int ninjaRunFrame=1;
    int ninjaJumpFrame=1;
    int ninjaAttackFrame=1;
    int ninjaAttackFrameBuffer=1;

    int fsalFrame=1,flyFrame=1;
    int enemy;
    Boolean enemyAbsent=true,fsalAbsent=true,flyAbsent=true;

    float ninjaMaxHeight;
    float ninjaVerticalSpeed;

    Paint paint,paintCircle;

    Random random;


    public GameView(GameActivity activity, float screenX, float screenY) {
        super(activity);

        this.screenX=screenX;
        this.screenY=screenY;
        screenRatioX=2400f/screenX;
        screenRatioY=1080f/screenY;

        backGround1=new BackGround(screenX,screenY,getResources());
        backGround2=new BackGround(screenX,screenY,getResources());
        backGround1.x=0;
        backGround2.x=screenX;

        ninja=new Ninja(getResources());

        ninjaMaxHeight=300*screenRatioY;
        ninjaVerticalSpeed=12*screenRatioY;

        circlex=screenX-(300*screenRatioX);
        circley=screenY-(250*screenRatioY);
        circleRadius=100;

        paint=new Paint();
        paintCircle=new Paint();
        paintCircle.setColor(Color.parseColor("#66000000"));

        random=new Random();

        fsal=new Fsal(screenX,screenY,getResources());
        fly=new Fly(screenX,screenY,getResources());

    }

    @Override
    public void run() {

        while(canDraw){

        movement();
        draw();
        sleep();

        }

    }


    private void movement() {
        backGround();
        ninja();
        enemy();
        enemyMovement();
    }


    private void enemy() {
        if(enemyAbsent) {
            enemy = random.nextInt(2)+1;
            if(enemy==1){
                fsalAbsent=false;
                fsal.x=screenX;
                enemyAbsent=false;
            }
            if(enemy==2){
                flyAbsent=false;
                fly.x=screenX;
                enemyAbsent=false;
            }
        }

    }

    private void enemyMovement() {
        if(!enemyAbsent) {
            if (enemy == 1 && !fsalAbsent) {
                fsal.x -= 10 * screenRatioX;
                if (fsalFrame < 11) {
                    fsalFrame++;
                } else {
                    fsalFrame = 1;
                }
                if (fsal.x+fsal.fsal1.getWidth()<0){
                    fsalAbsent=true;
                    enemyAbsent=true;
                }

            }
            else if (enemy == 2 && !flyAbsent) {
                fly.x -= 10 * screenRatioX;
                if (flyFrame < 7) {
                    flyFrame++;
                } else {
                    flyFrame = 1;
                }

                if (fly.x+fly.fly1.getWidth()<0){
                    fsalAbsent=true;
                    enemyAbsent=true;
                }

            }

        }
    }

    private void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void draw() {
        if(getHolder().getSurface().isValid()){
            Canvas canvas=getHolder().lockCanvas();

            canvas.drawBitmap(backGround1.background,backGround1.x,backGround1.y,paint);
            canvas.drawBitmap(backGround2.background,backGround2.x,backGround2.y,paint);
            canvas.drawCircle(circlex,circley,circleRadius,paintCircle);

            if(ninja.ninjaRun){
                canvas.drawBitmap(ninja.getNinjaRun(ninjaRunFrame),ninja.runx,ninja.runy,paint);
            }
            else if(ninja.ninjaJump){
                canvas.drawBitmap(ninja.getNinjaJump(ninjaJumpFrame),ninja.jumpx,ninja.jumpy,paint);
            }
            else if(ninja.ninjaSlide){
                canvas.drawBitmap(ninja.getNinjaSlide(),ninja.slidex,ninja.slidey,paint);
            }
            else if(ninja.ninjaAttack){
                canvas.drawBitmap(ninja.getNinjaAttack(ninjaAttackFrame),ninja.attackx,ninja.attacky,paint);
            }

            if(!enemyAbsent){
                if(!fsalAbsent){
                    canvas.drawBitmap(fsal.getFsal(fsalFrame),fsal.x,fsal.y,paint);
                }
                else if(!flyAbsent){
                    canvas.drawBitmap(fly.getFly(flyFrame),fly.x,fly.y,paint);
                }
            }

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void backGround() {
        backGround1.x-=10*screenRatioX;
        backGround2.x-=10*screenRatioX;

        if(backGround1.x+backGround1.background.getWidth()<0){
            backGround1.x=screenX;
        }

        if(backGround2.x+backGround2.background.getWidth()<0){
            backGround2.x=screenX;
        }
    }

    private void ninja() {
        if (ninja.ninjaRun) {
            if (ninjaRunFrame < 11) {
                ninjaRunFrame++;
            } else {
                ninjaRunFrame = 1;
            }
        }
        else if (ninja.ninjaJump) {
            if (ninja.ninjaUpward && ninja.jumpy > ninjaMaxHeight+(400*screenRatioY)) {
                ninja.jumpy -= ninjaVerticalSpeed;
                ninjaJumpFrame=1;
            }
            else if
            (ninja.ninjaUpward && ninja.jumpy > ninjaMaxHeight+(300*screenRatioY)) {
                ninja.jumpy -= ninjaVerticalSpeed;
                ninjaJumpFrame=2;
            }
            else if(ninja.ninjaUpward && ninja.jumpy > ninjaMaxHeight+(200*screenRatioY)) {
                ninja.jumpy -= ninjaVerticalSpeed;
                ninjaJumpFrame=3;
            }
            else if(ninja.ninjaUpward && ninja.jumpy > ninjaMaxHeight+(100*screenRatioY)) {
                ninja.jumpy -= ninjaVerticalSpeed;
                ninjaJumpFrame=4;
            }
            else if(ninja.ninjaUpward && ninja.jumpy > ninjaMaxHeight) {
                ninja.jumpy -= ninjaVerticalSpeed;
                ninjaJumpFrame=5;
            }
            else if (ninja.ninjaUpward && ninja.jumpy < ninjaMaxHeight) {
                ninja.ninjaUpward = false;
                ninja.ninjaDownward = true;
            }
            else if (ninja.ninjaDownward && ninja.jumpy < ninjaMaxHeight) {
                ninja.jumpy += ninjaVerticalSpeed;
            }
            else if (ninja.ninjaDownward && ninja.jumpy < ninjaMaxHeight+(100*screenRatioY)) {
                ninja.jumpy += ninjaVerticalSpeed;
            }
            else if (ninja.ninjaDownward && ninja.jumpy < ninjaMaxHeight+(200*screenRatioY)) {
                ninja.jumpy += ninjaVerticalSpeed;
                ninjaJumpFrame=8;
            }
            else if (ninja.ninjaDownward && ninja.jumpy < ninjaMaxHeight+(250*screenRatioY)) {
                ninja.jumpy += ninjaVerticalSpeed;
                ninjaJumpFrame=9;
            }
            else if (ninja.ninjaDownward && ninja.jumpy < ninjaMaxHeight+(300*screenRatioY)) {
                ninja.jumpy += ninjaVerticalSpeed;
                ninjaJumpFrame=10;
            }
            else {
                ninja.jumpy = base - ninja.jumpHeight;
                ninja.ninjaRun=true;
                ninja.atBase=true;
                ninja.ninjaJump = false;
            }
        }
        else if(ninja.ninjaSlide){

        }
        else if(ninja.ninjaAttack){
            if (ninjaAttackFrame < 11 && ninjaAttackFrameBuffer<20) {
                ninjaAttackFrameBuffer++;
                if(ninjaAttackFrameBuffer<2){
                    ninjaAttackFrame=1;
                }
                else if(ninjaAttackFrameBuffer<4){
                    ninjaAttackFrame=2;
                }
                else if(ninjaAttackFrameBuffer<6){
                    ninjaAttackFrame=3;
                }
                else if(ninjaAttackFrameBuffer<8){
                    ninjaAttackFrame=4;
                }
                else if(ninjaAttackFrameBuffer<10){
                    ninjaAttackFrame=5;
                }
                else if(ninjaAttackFrameBuffer<12){
                    ninjaAttackFrame=6;
                }
                else if(ninjaAttackFrameBuffer<14){
                    ninjaAttackFrame=7;
                }
                else if(ninjaAttackFrameBuffer<16){
                    ninjaAttackFrame=8;
                }
                else if(ninjaAttackFrameBuffer<18){
                    ninjaAttackFrame=9;
                }
                else if(ninjaAttackFrameBuffer<20){
                    ninjaAttackFrame=10;
                }
            } else {
                ninjaAttackFrame=1;
                ninjaAttackFrameBuffer=1;
                ninja.ninjaAttack=false;
                ninja.ninjaRun=true;
            }

        }
    }

    public void resume(){
        canDraw=true;
        thread=new Thread(this);
        thread.start();
    }

    public void pause(){
        canDraw=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN: {
                float downx=event.getX();
                float downy=event.getY();

                if(ninja.atBase && !ninja.ninjaSlide && !ninja.ninjaAttack) {
                    if(downx>circlex-circleRadius && downx<circlex+circleRadius && downy>circley-circleRadius && downy<circley+circleRadius){
                        ninja.ninjaRun=false;
                        ninja.ninjaAttack=true;
                    }
                    else if (downx > (screenX / 2)) {
                        ninja.atBase=false;
                        ninja.ninjaRun=false;
                        ninja.ninjaJump = true;
                        ninja.ninjaUpward= true;
                        ninja.ninjaDownward = false;
                    }
                }

                return true;
            }

            case MotionEvent.ACTION_MOVE:{
                float downx=event.getX();
                if(ninja.atBase && !ninja.ninjaAttack && downx < (screenX / 2)){
                    ninja.ninjaRun=false;
                    ninja.ninjaSlide=true;
                }
                return value;
            }

            case MotionEvent.ACTION_UP:{
                float downx=event.getX();
                if(ninja.atBase && downx < (screenX / 2)){
                    ninja.ninjaRun=true;
                    ninja.ninjaSlide=false;
                }
                return value;
            }
        }
        return value;
    }

}

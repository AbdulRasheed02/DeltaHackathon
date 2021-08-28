package com.example.deltahackathon;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {

    Thread thread;
    boolean canDraw;

    public static float screenRatioX, screenRatioY;
    private float screenX,screenY;

    private BackGround backGround1,backGround2;
    private Ninja ninja;

    int ninjaRunFrame=1;

    Paint paint;


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


        paint=new Paint();

    }

    @Override
    public void run() {

        while(canDraw){

        movement();
        draw();
        sleep();

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

            if(ninja.ninjaRun){
                canvas.drawBitmap(ninja.getNinjaRun(ninjaRunFrame),ninja.runx,ninja.runy,paint);
            }

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void movement() {
        backGround();
        ninja();
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
        if(ninja.ninjaRun) {
            if (ninjaRunFrame < 11) {
                ninjaRunFrame++;
            } else {
                ninjaRunFrame = 1;
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

}

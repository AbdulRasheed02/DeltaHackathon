package com.example.deltahackathon;

import android.content.Context;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {

    Thread thread;
    boolean canDraw;

    public static float screenRatioX, screenRatioY;
    private float screenX,screenY;

    public GameView(GameActivity activity, float screenX, float screenY) {
        super(activity);

        this.screenX=screenX;
        this.screenY=screenY;
        screenRatioX=2400f/screenX;
        screenRatioY=1080f/screenY;

    }

    @Override
    public void run() {

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

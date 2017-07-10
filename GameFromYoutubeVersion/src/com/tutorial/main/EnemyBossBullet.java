package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class EnemyBossBullet extends GameObject{
    private Handler handler;
    private int timer = 50;
    private int timer2= 50;
    Random r = new Random();
    public EnemyBossBullet(int x, int y, ID id, Handler handler){
        super(x,y,id);
        this.handler = handler;
        velX = r.nextInt(5 - -5+ -5);
        velY = 5;
    }
    public Rectangle getBounds(){
        return new Rectangle((int) x,(int) y, 16, 16);
    }
    public void tick(){
        x += velX;
        y += velY;
        if(timer <= 0 ) {
            velY = 0;
            timer2--;
        } else timer--;
        if (timer2 <= 0) {
            if(velX == 0) velX = 2;

        }

        //if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 48) velX *= -1;
        //handler.addObject(new Trail((int)x,(int) y, ID.Trail, Color.red, 16, 16, 0.008f,handler));
        if(y >= Game.HEIGHT) handler.removeObject(this);
    }
    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y,16,16);
    }
}
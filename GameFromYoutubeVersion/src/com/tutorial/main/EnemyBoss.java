package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class EnemyBoss extends GameObject{
    private Handler handler;
    private int timer = 50;
    private int timer2= 50;
    Random r = new Random();
    public EnemyBoss(int x, int y, ID id, Handler handler){
        super(x,y,id);
        this.handler = handler;
        velX = 0;
        velY = 5;
    }
    public Rectangle getBounds(){
        return new Rectangle((int) x,(int) y, 64, 64);
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
            if(velX > 0)
                velX += 0.05f;
            else if(velX < 0)
                velX -= 0.05f;
            velX = Game.clamp(velX, -10, 10);
            // spawn bullets
            int spawn = r.nextInt(10);
            if(spawn == 0) handler.addObject(new EnemyBossBullet((int)x+48, (int) y+48, ID.Enemy, handler));
        }

        //if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 48) velX *= -1;
        //handler.addObject(new Trail((int)x,(int) y, ID.Trail, Color.red, 64, 64, 0.008f,handler));
    }
    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y,64,64);
    }
}
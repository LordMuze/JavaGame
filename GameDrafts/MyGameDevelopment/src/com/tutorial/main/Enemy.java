package com.tutorial.main;

import java.awt.*;
import java.util.Random;

/**
 * Created by LENOVO on 4/4/2017.
 */
public class Enemy extends GameObject {
    Random r = new Random();
    public Enemy(int x, int y, ID id) {
        super(x, y, id);
        velX = r.nextInt(5) + 1;
        velY = r.nextInt(5);

    }

    public void tick() {
        x += velX;
        y += velY;
    }


    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 32, 32);
    }
}

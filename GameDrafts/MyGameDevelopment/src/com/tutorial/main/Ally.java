package com.tutorial.main;

import java.awt.*;
import java.util.Random;

/**
 * Created by LENOVO on 4/4/2017.
 */
public abstract class Ally extends GameObject {
    protected int x;
    protected int y;
    protected int velX;
    protected int velY;
    protected ID id;
    Random r = new Random();
    public Ally(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;

    }
    public void tick() {

    }
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRoundRect(x, y, 32, 32, 32, 32);
    }
}

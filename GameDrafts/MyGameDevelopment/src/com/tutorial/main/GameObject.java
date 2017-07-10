package com.tutorial.main;

import java.awt.*;

/**
 * Created by LENOVO on 4/4/2017.
 */
public abstract class GameObject {
    // All the game objects
    // will inherit this behavior
     //protected int x, y;
    // ID to indicate specific objects
     //protected ID id;
    // indicate velocity of objects
    //protected int velX, velY;

    public GameObject() {


    }
    public abstract void tick();
    public abstract void render(Graphics g);

   /* public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;

    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setID(ID id) {
        this.id = id;
    }
    public ID getID() {
        return id;
    }
    public void setVelX(int velX) {
        this.velX = velX;
    }
    public void setVelY(int velY) {
        this.velY = velY;
    }
    public int getVelX() {
        return velX;
    }
    public int getVelY() {
        return velY;
    }
    */
   public abstract int getX();
   public abstract int getY();
   public abstract ID getID();
   public abstract void setX();
   public abstract void setY();
   public abstract int getVelX();
   public abstract int getVelY();
}

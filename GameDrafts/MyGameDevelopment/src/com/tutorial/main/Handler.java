package com.tutorial.main;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by LENOVO on 4/4/2017.
 */
public class Handler {
    //Basically this class maintain or update and render
    // all objects in the game
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    public void tick() {
        for(int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            //tick the objects
            tempObject.tick();
        }

    }
    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }

    }
    public void addObject(GameObject object) {
        this.object.add(object);
    }
    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
}

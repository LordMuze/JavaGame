package com.tutorial.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by LENOVO on 5/4/2017.
 */
public class Menu extends MouseAdapter {
    private Game game;
    Handler handler;
    private Random r = new Random();
    public Menu(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        //play button
        if(game.gameState == Game.STATE.Menu) {
            if (mouseOver(mx, my, 210, 150, 200, 64)) {
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new Enemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.Enemy, handler));
            }
            //help button
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = Game.STATE.Help;
            }
        }
            //back button
            if (game.gameState == Game.STATE.Help) {
                if (mouseOver(mx, my, 210, 350, 200, 64)) {
                    game.gameState = Game.STATE.Menu;
                    return;// return back to the if statements outside this if statements
                }
            }
            //quit button
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                System.exit(1);
            }

    }
    public void mouseReleased(MouseEvent e) {

    }
    private boolean mouseOver(int mx, int my, int x, int y,int width, int height) {
        if(mx > x && mx < x + width) {
            if(my > y && my < y + height) {
                return true;
            } else return false;
        }else return false; // if mouse position is in between x and y corners of the menu buttons, return true..
    }
    public void tick() {

    }
    public void render(Graphics g) {
        if (game.gameState == Game.STATE.Menu) {


            Font font = new Font("arial", 1, 50);
            g.setFont(font);
            g.setColor(Color.white);
            g.drawString("Menu", 240, 70);

            g.setColor(Color.WHITE);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Play", 270, 190);

            g.setColor(Color.WHITE);
            g.drawRect(210, 250, 200, 64);
            g.drawString("Help", 270, 290);

            g.setColor(Color.WHITE);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 270, 390);

        }else if(game.gameState == Game.STATE.Help) {
            Font font = new Font("arial", 1, 50);
            Font fon3 = new Font("arial", 1, 20);
            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString("Help", 240, 70);
            g.setFont(fon3);
            g.drawString("Use WASD keys to move player and dodge enemies", 50, 200);

            g.drawRect(210, 350, 200, 64);
            g.drawString("Back", 270, 390);
        }
    }
}

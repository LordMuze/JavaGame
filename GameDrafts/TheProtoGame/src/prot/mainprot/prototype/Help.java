package prot.mainprot.prototype;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
public class Help extends MouseAdapter implements State{
	GamePrototype game;
	public Help(GamePrototype game) {
		this.game = game;
	}
	public void tick() {
		
	}

	public void render(Graphics g) {
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

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
        if (State.mouseOver(mx, my, 210, 350, 200, 64)) {
        	game.removeMouseListener(this);
            game.setState(game.getMenuState());
            game.addMouseListener((MouseAdapter) game.getMenuState());
        }
	}
    

}

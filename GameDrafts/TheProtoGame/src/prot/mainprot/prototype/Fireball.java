package prot.mainprot.prototype;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Fireball extends GamePrototypeObject {
    private float x = 10;
    private float weaponX;
    private float weaponY;
    private int timer = 20;
    private ID id;
    private int[] tempArray = new int[2];
    private float change;
    private Color color;
    public Fireball(float mx, float my, ID id, float change, Color color) {
    	super(mx, my, id);
    	this.id = id;
    	this.weaponX = mx;
    	this.weaponY = my;
    	this.change = change;
    	this.color = color;
    }
	@Override
	public void tick() {
		if (timer <= 0) {
			x = x + change;
		}else {
			tempCoordinate((int) weaponX, (int) weaponY);
			timer--;
			
		}
		
	}
    
	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect( tempArray[0] - (int) x,  tempArray[1]  + 27, 8, 8);
		
	}
	public void tempCoordinate(int tempX, int tempY) {
		tempArray[0] = tempX;
		tempArray[1] = tempY;
	}
	public int refreshTimer() {
		return timer = 20;
	}
	public ID getId() {
		return id;
	}
	public int getHealth() {
		return 1;
	}
	public Rectangle getBounds() {
		return new Rectangle(tempArray[0] - (int) x, tempArray[1] + 27, 8, 8);
	}

}

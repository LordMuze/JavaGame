package prot.mainprot.prototype;

import java.awt.Color;
import java.awt.Graphics;

public class Fireball extends GamePrototypeObject {
    private float x = 10;
    private float weaponX;
    private float weaponY;
    private int timer = 20;
    private ID id;
    private int[] tempArray = new int[2];
    public Fireball(float mx, float my, ID id) {
    	super(mx, my, id);
    	this.id = id;
    	this.weaponX = mx;
    	this.weaponY = my;
    }
	@Override
	public void tick() {
		if (timer <= 0) {
			x = x + 1;
		}else {
			tempCoordinate((int) weaponX, (int) weaponY);
			timer--;
			
		}
		
	}
    
	@Override
	public void render(Graphics g) {
		g.setColor(Color.orange);
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

}

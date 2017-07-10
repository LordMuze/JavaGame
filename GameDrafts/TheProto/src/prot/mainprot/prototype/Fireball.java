package prot.mainprot.prototype;

import java.awt.Color;
import java.awt.Graphics;

public class Fireball extends GamePrototypeObject {
    private float x = 10;
    Weapon weapon;
    private float weaponX;
    private float weaponY;
    private int timer = 20;
    private int[] tempArray = new int[2];
    public Fireball(float weaponX, float weaponY, ID id) {
    	super(weaponX, weaponY, id);
    	this.weaponX = weaponX;
    	this.weaponY = weaponY;
    	this.id = id;
    }
	
	public void tick() {
		if (timer <= 0) {
			x = x + 4;
		}else {
			tempCoordinate((int) weaponX, (int) weaponY);
			timer--;
			
		}
		
	}
    
	
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
}

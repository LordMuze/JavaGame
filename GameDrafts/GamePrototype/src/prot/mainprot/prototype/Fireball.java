package prot.mainprot.prototype;

import java.awt.Color;
import java.awt.Graphics;

public class Fireball implements Projectile {
    private float x = 10;
    private float weaponX;
    private float weaponY;
    private int timer = 20;
    private int[] tempArray = new int[2];
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
	public void render(Graphics g, Weapon weapon) {
		g.setColor(Color.orange);
		weaponX =(int) weapon.getX();
		weaponY = (int) weapon.getY();
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

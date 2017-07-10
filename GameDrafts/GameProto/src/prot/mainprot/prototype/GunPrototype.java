package prot.mainprot.prototype;

import java.awt.Color;
import java.awt.Graphics;

public class GunPrototype implements Weapon {
	
	
	private float x, y;
	public GunPrototype() {
		;
		
	}

	
	public void tick(float x, float y) {
	
	}
	


	
	public void render(Graphics g, float x, float y) {
		g.setColor(Color.red);
		this.x = x;
		this.y = y;
		g.fillRect((int) x - 10, (int) y + 20, 85, 20);
        
	
}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}




}

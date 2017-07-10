package prot.mainprot.prototype;

import java.awt.Color;
import java.awt.Graphics;

public class GunPrototype implements Weapon {
	Projectile projectile;
	private int timer = 20;
	private float x, y;
	public GunPrototype(Projectile projectile) {
		this.projectile = projectile;
		
	}

	
	public void tick(float x, float y) {
		projectile.tick();
		if (timer <= 0) {
			
		}else {
			timer--;
		}
	}
	


	
	public void render(Graphics g, float x, float y) {
		g.setColor(Color.red);
		this.x = x;
		this.y = y;
		g.fillRect((int) x - 10, (int) y + 20, 85, 20);
        projectile.render(g, this);
	
}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}




}

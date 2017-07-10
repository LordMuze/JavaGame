package prot.mainprot.prototype;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class GunPrototype implements Weapon {
	Handler handler;
	private float x, y;
	private int timer = 30;
	private int timerVel = 30;
	private Random r = new Random();
	public GunPrototype(Handler handler) {
		this.handler = handler;
	}

	
	public void tick() {
		if (timer <= 0) {
	    int SpawnProb = r.nextInt(5);
	    if (SpawnProb == 0) {
		handler.addObject(new Fireball(getX() - 13, getY() -12, ID.Fireball));
	    }
	    
	    timer += timerVel;
		}else {
			timer--;
		}
	}
	


	
	public void render(Graphics g, float x, float y) {
		g.setColor(Color.red);
		this.x = x;
		this.y = y;
		g.fillRect((int) x - 10, (int) y + 20, 85, 20);
	
}
	public float getX() {
		return x - 5;
	}
	public float getY() {
		return y + 15;
	}




}

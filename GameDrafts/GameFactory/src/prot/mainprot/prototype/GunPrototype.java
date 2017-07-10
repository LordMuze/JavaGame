package prot.mainprot.prototype;

import java.awt.Color;
import java.awt.Graphics;

public class GunPrototype extends Weapon {
	ID id;
	Handler handler;
	private float x, y;
	private int timer = 20;
	public GunPrototype(ID id, Handler handler) {
		this.id = id;
		this.handler = handler;
	}

	
	public void tick(float x, float y) {
		if (timer <= 0) {
			handler.addObject(createProjectile(this.x, this.y, this.id));
			System.out.println(timer);
			timer = 20;
			System.out.println(timer);
		}else {
			timer--;
		}
	}
	


	
	public void render(Graphics g, float x, float y) {
		g.setColor(Color.red);
		this.x = x;
		this.y = y;
		g.fillRect((int) x - 10, (int) y + 20, 85, 20);
		if(timer <= 0) {
			
		}else {
			
		}
			
		
        
	
}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	protected GamePrototypeObject createProjectile(float x,float y, ID id) {
		GamePrototypeObject projectie = new Fireball(x, y, ID.FireBall);
		try {
		if (id == projectie.getId()) {
			return projectie;
		}
		} catch (NullPointerException nl) {
			System.err.println("It's either the project object has yet to be instantiated to an actual class object");
			System.err.println("or that you suck");
		}
		System.err.println("Nullified Projectile");
		return null;
		
	}
}

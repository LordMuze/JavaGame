package prot.mainprot.prototype;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
public class GunPrototype extends Weapon {
	ProjectileFactory projectileFactory;
	ID id;
	Handler handler;
	private float x, y;
	private int timer = 40;
	Random r = new Random();
	public GunPrototype(ID id, Handler handler, ProjectileFactory projectileFactory) {
		this.id = id;
		this.handler = handler;
		this.projectileFactory = projectileFactory;
	}

	
	public void tick(float x, float y) {
		int spawnBullet = r.nextInt(50);
		if (timer <= 0) {
			if(spawnBullet == 0) {
			handler.addObject(summonProjectile(this.x, this.y, this.id));
			timer = 20;
			}
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
	public GamePrototypeObject summonProjectile(float x, float y,ID id) {
		return projectileFactory.createProjectile(x, y, id);
	}

}

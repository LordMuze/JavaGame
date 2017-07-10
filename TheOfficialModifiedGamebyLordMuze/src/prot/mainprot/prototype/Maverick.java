package prot.mainprot.prototype;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.*;
public class Maverick extends Weapon {
	ProjectileFactory projectileFactory;
	ID id;
	Handler handler;
	private float x, y;
	private int timer = 20;
	Random r = new Random();
	public Maverick(ID id, Handler handler, ProjectileFactory projectileFactory) {
		this.id = id;
		this.handler = handler;
		this.projectileFactory = projectileFactory;
	}
	public void tick(float x, float y) {
		int spawnBullet = r.nextInt(50);
		if (timer <= 0 && spawnBullet == 5) {
			handler.addObject(summonProjectile(this.x + 30, this.y - 18, this.id));
			timer = 20;
		}else {
			timer--;
		}
		
	}
	public void render(Graphics g, float x, float y) {
		Graphics2D comp = (Graphics2D) g;
		g.setColor(Color.red);
		this.x = x;
		this.y = y;
		Arc2D.Float arc = new Arc2D.Float(x, y, 25, 20, 180, 180, Arc2D.CHORD);
		comp.draw(arc);
		comp.fill(arc);
	}
	public GamePrototypeObject summonProjectile(float x, float y, ID id) {
		return projectileFactory.createProjectile(x, y, id);
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
}

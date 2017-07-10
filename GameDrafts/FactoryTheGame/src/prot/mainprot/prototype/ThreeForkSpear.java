package prot.mainprot.prototype;
import java.util.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
public class ThreeForkSpear extends Weapon{
	ProjectileFactory projectileFactory;
	ID id;
	Handler handler;
	private float x, y;
	private int timer = 40;
	Random r = new Random();
	public ThreeForkSpear(ID id, Handler handler, ProjectileFactory projectileFactory) {
		this.id = id;
		this.handler = handler;
		this.projectileFactory = projectileFactory;
	}
	public void tick(float x, float y) {
		int spawnBullet = r.nextInt(50);
		if (timer <= 0 && spawnBullet == 5) {
			handler.addObject(summonProjectile(this.x + 170, this.y - 25,this.id));
			timer = 20;
		}else {
			timer--;
		}
	}
	public void render(Graphics g, float x, float y) {
		Graphics2D comp = (Graphics2D) g;
		g.setColor(Color.getHSBColor(53, 100, 100));
		this.x = x;
		this.y = y;
		g.fillRect((int) x + 30,(int) y + 10, 140, 8);
		g.setColor(Color.green);
		int[] xArray = {(int)x + 170, (int)x+10 + 170, (int)x + 170};
		int[] yArray = {(int) y - 13, (int) y+30 - 13, (int) y+60 - 13};
		GeneralPath triangle = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xArray.length);
		triangle.moveTo(xArray[0], yArray[0]);
		for(int i = 0; i < xArray.length; i++) {
			triangle.lineTo(xArray[i], yArray[i]);
		}
		triangle.closePath();
		comp.draw(triangle);
		comp.fill(triangle);
		
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
		
	}
	public GamePrototypeObject summonProjectile(float x, float y, ID id) {
		return projectileFactory.createProjectile(x, y, id);
	}
}

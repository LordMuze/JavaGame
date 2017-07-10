package prot.mainprot.prototype;
import java.util.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.geom.GeneralPath;

public class SlayerDracoBasic extends Weapon {
	ProjectileFactory projectileFactory;
	ID id;
	Handler handler;
	private float x, y;
	private int timer = 40;
	Random r = new Random();
	public SlayerDracoBasic(ID id, Handler handler, ProjectileFactory projectileFactory) {
		this.id = id;
		this.handler = handler;
		this.projectileFactory = projectileFactory;
	}
	@Override
	public void tick(float x, float y) {
		int spawnBullet = r.nextInt(70);
		if(timer <= 0 && spawnBullet == 7) {
			handler.addObject(summonProjectile(this.x + 48, this.y - 43, this.id));
			timer = 40;
		}else {
			timer--;
		}
	}

	@Override
	public void render(Graphics g, float x, float y) {
		Graphics2D comp = (Graphics2D) g;
		g.setColor(Color.white);
		this.x = x;
		this.y = y;
		int[] xArray = {(int) x - 10,(int) x, (int) x + 40, (int) x + 40, (int) x + 30, (int) x +30,(int) x + 20, (int) x + 20};
		int[] yArray = {(int) y, (int) y - 20, (int) y - 20, (int) y, (int) y,(int) y + 10, (int) y + 10,(int) y,};
		GeneralPath gun = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xArray.length);
		gun.moveTo(xArray[0], yArray[0]);
		for (int i = 0; i < xArray.length; i++) {
			gun.lineTo(xArray[i], yArray[i]);
		}
		gun.closePath();
		comp.draw(gun);
		comp.fill(gun);
	}

	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	protected GamePrototypeObject summonProjectile(float x, float y, ID id) {
		// TODO Auto-generated method stub
		return projectileFactory.createProjectile(x, y, id);
	}
}

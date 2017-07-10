package prot.mainprot.prototype;

import java.awt.Graphics;
import java.awt.*;
public class Torquedo extends GamePrototypeObject {
	Weapon weapon;
	float velocity = 1;
	float xr, yr;
	EnemysAlgorithm algo = new EnemysAlgorithm();
	public Torquedo(float x, float y, ID id, Weapon weapon) {
		super(x, y, id);
		this.xr = x;
		this.yr = y;
		this.weapon = weapon;
	}
	public void tick() {
		algo.moveBasicEnemy(xr, velocity);
	    xr = algo.getAlgoX();
		weapon.tick(xr, yr);
		xr = GamePrototype.clamp(xr, 0, GamePrototype.WIDTH - 40);
	}
	public void render(Graphics g) {
	    //xr = xr + counterX;
		g.setColor(Color.blue);
		g.fillRect((int) xr , (int) yr, 128, 32);
		weapon.render(g, xr, yr);
	}
}

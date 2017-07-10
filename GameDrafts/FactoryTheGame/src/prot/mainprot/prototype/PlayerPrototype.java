package prot.mainprot.prototype;

import java.awt.Color;
import java.awt.Graphics;



public class PlayerPrototype extends GamePrototypeObject {
	Weapon weapon;
	public PlayerPrototype(float x, float y, ID id, Weapon weapon) {
		super(x, y, id);
		this.weapon = weapon;
	}

	
	public void tick() {
		 x += velX;
	     x = GamePrototype.clamp(x, 0, GamePrototype.WIDTH -40);
	     weapon.tick(x, y);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x,(int)y, 64, 64);
		weapon.render(g, x, y);
		
	}

}

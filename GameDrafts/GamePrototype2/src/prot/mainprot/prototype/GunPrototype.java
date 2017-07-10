package prot.mainprot.prototype;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
public class GunPrototype extends Weapon {
	Projectile projectile;
	Projectile pot;
	ArrayList<Projectile> proto = projectile.getList();
	private ID id;
	private ID mID = ID.GunFirePrototype;
	private int timer = 20;
	private float x, y;
	public GunPrototype() {
		
	}

	
	public void tick(float x, float y) {
		if (timer <= 0) {
			/*for(int i = 0; i < proto.size(); i++) {
				if(proto.get(i).getID() == mID) {
					pot = (Projectile) proto.get(i);
				}
			}*/
		}else {
			timer--;
		}
		//pot.tick();
	}
	


	
	public void render(Graphics g, float x, float y) {
		g.setColor(Color.red);
		this.x = x;
		this.y = y;
		g.fillRect((int) x - 10, (int) y + 20, 85, 20);
        //pot.render(g, this);
	
}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public ID getID() {
		return id;
	}
	
}

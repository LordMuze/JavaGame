package prot.mainprot.prototype;
import java.awt.*;
import java.util.ArrayList;
public abstract class Projectile {
	ArrayList<Projectile> bulletsnarrows = new ArrayList();
	public abstract void tick();
	public abstract void  render(Graphics g, Weapon weapon);
	public void addProjectile(Projectile projectile) {
		bulletsnarrows.add(projectile);
	}
	public ArrayList<Projectile> getList() {
		return bulletsnarrows;
	}
	public abstract ID getID();
}

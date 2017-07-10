package prot.mainprot.prototype;
import java.awt.*;
public interface Projectile {
	public void tick();
	public void  render(Graphics g);
	public ID getID();
	//public Rectangle getRectangle();
}

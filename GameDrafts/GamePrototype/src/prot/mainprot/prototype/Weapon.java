package prot.mainprot.prototype;
import java.awt.*;
public interface Weapon {
	public void tick(float x, float y);
	public void render(Graphics g, float x, float y);
	public float getX();
	public float getY();
}

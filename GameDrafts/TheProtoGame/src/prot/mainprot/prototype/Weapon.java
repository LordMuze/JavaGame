package prot.mainprot.prototype;
import java.awt.*;
public abstract class Weapon {
	public abstract void tick(float x, float y);
	public abstract void render(Graphics g, float x, float y);
	public abstract float getX();
	public abstract float getY();
	/*protected abstract GamePrototypeObject createProjectile(float theX, float theY, ID id); */
	protected abstract  GamePrototypeObject summonProjectile(float x, float y, ID id);
	

	
}

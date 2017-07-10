package prot.mainprot.prototype;
import java.awt.*;
public class Enemy extends GamePrototypeObject {
	float x, y;
	ID id;
	Weapon weapon;
	private int velocityX = 3;
	EnemysAlgorithm algo = new EnemysAlgorithm();
	public Enemy(float x, float y, ID id) {
		super(x, y, id);
		this.x = x;
		this.y = y;
		this.id = id;
	}
	public ID getID() {
		return id;
	}
	public void tick() {
		algo.moveBasicEnemy(x, velocityX);
		x = algo.getAlgoX();
		x = GamePrototype.clamp(x, 0, GamePrototype.WIDTH - 40);
	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x,(int) y,  56, 56);
	}

}


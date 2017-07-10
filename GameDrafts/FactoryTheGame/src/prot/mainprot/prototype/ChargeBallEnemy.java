package prot.mainprot.prototype;
import java.awt.*;
public class ChargeBallEnemy extends GamePrototypeObject {
	float x, y;
	ID id;
	private int[] tempArray = new int[2];
	private int timer = 20;
	private float xVel = 10;
	public ChargeBallEnemy(float x, float y, ID id) {
		super(x, y, id);
		this.x = x;
		this.y = y;
		this.id = id;
	}
	public void tick() {
		if(timer <= 0) {
			xVel = xVel - 3;
		}else{
			tempCoordinate(x, y);
			timer--;
			
		}
		
	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(tempArray[0] - (int) xVel, tempArray[1] + 27, 16, 16);
	}
	public void tempCoordinate(float x, float y) {
		tempArray[0] = (int) x;
		tempArray[1] = (int) y;
	}
	public ID getId() {
		return id;
	}
}

package prot.mainprot.prototype;
import java.awt.*;
public class ChargeBall extends GamePrototypeObject {
	float x, y;
	ID id;
	private int[] tempArray = new int[2];
	private int timer = 20;
	private float xVel = 10;
	private float change;
	private Color color;
	public ChargeBall(float x, float y, ID id, float change, Color color) {
		super(x, y, id);
		this.x = x;
		this.y = y;
		this.id = id;
		this.change =change;
		this.color = color;
	}
	public void tick() {
		if(timer <= 0) {
			xVel = xVel + change;
		}else{
			tempCoordinate(x, y);
			timer--;
			
		}
		
	}
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(tempArray[0] - (int) xVel, tempArray[1] + 27, 16, 16);
	}
	public void tempCoordinate(float x, float y) {
		tempArray[0] = (int) x;
		tempArray[1] = (int) y;
	}
	public ID getId() {
		return id;
	}
	public Rectangle getBounds() {
		return new Rectangle(tempArray[0] - (int) xVel,tempArray[1] + 27, 16, 16);
	}
	public int getHealth() {
		return 1;
	}
}

package prot.mainprot.prototype;
import java.awt.*;
public class BasicEnemy extends GamePrototypeObject {
	float x, y;
	int counterX = 3;
	ID id;
	Weapon weapon;
	private int timerOne = 80;
	private int timerTwo = 0;
	public BasicEnemy(float x, float y, ID id) {
		super(x, y, id);
		this.x = x;
		this.y = y;
	}
	public ID getID() {
		return id;
	}
	public void tick() {
 
		
		if (timerTwo == 0 && timerOne != 0) {
			 x += counterX;
			timerOne--;
			System.out.println("First Run");
		}else if(timerOne == 0) {
			x -= counterX;
			timerTwo++;
			System.out.println("BenchMark!");
			if(timerTwo == 100) {
				timerTwo = 0;
				timerOne = 100;
				System.out.println("Benchmark! HOME RUN");
			}
		}
		x = GamePrototype.clamp(x, 0, GamePrototype.WIDTH - 40);
	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x + counterX,(int) y,  56, 56);
	}

	public float move(int timeOne, int timeTwo, int velocityX, float enemyX) {
		if (timeTwo == 0 && timeOne != 0) {
			enemyX += velocityX;
			timeOne--;
		}else if (timeOne == 0) {
			enemyX -= velocityX;
			timeTwo++;
			if(timeTwo == 80) {
				timeTwo = 0;
				timeOne = 100;
			}
		}
		return enemyX;
	}
}


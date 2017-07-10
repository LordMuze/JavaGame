package prot.mainprot.prototype;

public class UFOAlgorithm {
	private float theX;
	private float theY;
	private float velocityY;
	private int timerOne = 100;
	private int timerTwo = 0;
	private float velocity;
	public UFOAlgorithm(float x,float y,float velocityX, float velocityY) {
		this.theX = x;
		this.theY = y;
		this.velocity = velocityX;
		this.velocityY = velocityY;
	}
	public void moveBasicEnemy() {
		if (timerTwo == 0 && timerOne != 0) {
			theX += velocity;
			theY += velocityY;
			timerOne--;
			System.out.println("Velocity" + timerOne);
		}else if (timerOne == 0) {
			theX -= velocity;
			theY += velocityY;
			timerTwo++;
			System.out.println("Velocity De: " + velocity + velocityY);
			if(timerTwo == 100) {
				timerTwo = 0;
				timerOne = 100;
			}
		}
	}
	public float getAlgoX() {
		return theX;
	}
	public float getAlgoY() {
		return theY;
	}
	
}

package prot.mainprot.prototype;

public class EnemysAlgorithm {
	private float theX;
	private int timerOne = 100;
	private int timerTwo = 0;
	public EnemysAlgorithm() {
		
	}
	public void moveBasicEnemy(float x, float velocityX) {
		this.theX = x;
		if (timerTwo == 0 && timerOne != 0) {
			theX = theX + velocityX;
			timerOne--;
			//System.out.println(theX);
		}else if (timerOne == 0) {
			theX = theX - velocityX;
			timerTwo++;
			//System.out.println("Velocity De: " + velocity + " " + theX);
			if(timerTwo == 100) {
				timerTwo = 0;
				timerOne = 100;
			}
		}
	}
	public float getAlgoX() {
		///System.out.println(theX);
		return theX;
	}
}

package prot.mainprot.prototype;

public class AlgorithmTwo {
	private int timerOne = 100;
	private int timerTwo = 0;
	private float counterX;
	private float velocity;
	public AlgorithmTwo(float x, float vel) {
		this.counterX = x;
		this.velocity = vel;
	}
	public void moveBasicEnemy() { 
		if(timerTwo == 0 && timerOne != 0 && timerOne%10 == 0) {
			counterX += velocity;
			timerOne--;
		}else if (timerTwo == 0 && timerOne != 0 && timerOne%10 != 0){
			timerOne--;
		}
		if(timerOne == 0 && timerTwo %10 != 0) {
			timerTwo++;
		}else if(timerOne == 0 && timerTwo%10 == 0) {
			counterX -= velocity;
			//timerTwo++;
			if (timerTwo == 100) {
				timerTwo = 0;
				timerOne = 100;
				System.out.println("LOOK AT ME");
			}
		}
	}
	public float getAlgoX() {
		System.out.println(timerOne);
		System.out.println("sys" + timerTwo);
		return counterX;
	}
}

package prot.mainprot.prototype;
import java.awt.*;
public class Enemy extends GamePrototypeObject {
	float x, y;
	ID id;
	Weapon weapon;
	private int velocityX = 1;
	private int health = 20;
	private Handler handler;
	EnemysAlgorithm algo = new EnemysAlgorithm();
	public Enemy(float x, float y, ID id,Handler handler, Weapon weapon) {
		super(x, y, id);
		this.x = x;
		this.y = y;
		this.id = id;
		this.handler = handler;
		this.weapon = weapon;
	}
	public ID getID() {
		return id;
	}
	public void tick() {
		algo.moveBasicEnemy(y, velocityX);
		y = algo.getAlgoX();
		weapon.tick(x + 40, y + 40);
		collision();
	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x,(int) y,  56, 56);
		weapon.render(g, x + 40, y + 40);
	}
	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return health;
	}
    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            GamePrototypeObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.FireBall){
                if(getBounds().intersects(tempObject.getBounds())){
                    health -= 5;
                    handler.object.remove(tempObject);
                                    }
            }
        }
    }
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 60, 60);
	}

}


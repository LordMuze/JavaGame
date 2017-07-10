package prot.mainprot.prototype;

import java.awt.Graphics;
import java.awt.*;
public class Torquedo extends GamePrototypeObject {
	Weapon weapon;
	Handler handler;
	float velocity = 1;
	float xr, yr;
	private int health = 40;
	EnemysAlgorithm algo = new EnemysAlgorithm();
	public Torquedo(float x, float y, ID id,Handler handler, Weapon weapon) {
		super(x, y, id);
		this.xr = x;
		this.yr = y;
		this.handler = handler;
		this.weapon = weapon;
	}
	public void tick() {
		algo.moveBasicEnemy(yr, velocity);
	    yr = algo.getAlgoX();
		weapon.tick(xr, yr);
		xr = GamePrototype.clamp(xr, 0, GamePrototype.WIDTH - 40);
		collision();
	}
	public void render(Graphics g) {
	    //xr = xr + counterX;
		g.setColor(Color.blue);
		g.fillRect((int) xr , (int) yr, 128, 32);
		weapon.render(g, xr, yr);
	}
	public Rectangle getBounds() {
		return new Rectangle((int) xr, (int) yr, 130, 32);
	}
    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            GamePrototypeObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.FireBall){
                if(getBounds().intersects(tempObject.getBounds())){
                    health -= 4;
                    handler.object.remove(tempObject);
                                    }
            }
        }
    }
    public int getHealth() {
    	return health;
    }
}

package prot.mainprot.prototype;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
public class Fishball extends GamePrototypeObject {
	Weapon weapon;
	float velocity = 1;
	float counterY;
	float xr, yr;
	private int health = 50;
	Handler handler;
	// Implement the ufo's algorithm here//
	
	public Fishball(float x, float y, ID id,Handler handler, Weapon weapon) {
		super(x, y, id);
		this.xr = x;
		this.yr= y;
		this.handler = handler;
		this.weapon = weapon;
	}
	EnemysAlgorithm algo = new EnemysAlgorithm();
	public void tick() {
		algo.moveBasicEnemy(yr, velocity);
		yr = algo.getAlgoX();
		//yr = yr + counterY;
		weapon.tick(xr ,yr);
		System.out.println(yr);
		yr = GamePrototype.clamp(yr, 0, GamePrototype.WIDTH - 40);
		collision();
	}
	public void render(Graphics g) {
		Graphics2D comp = (Graphics2D) g;
		g.setColor(Color.white);
		int[] xArray = {(int) xr, (int) xr + 20, (int) xr + 80, (int) xr + 100};
		int[] yArray = {(int) yr, (int) yr - 20, (int) yr - 20, (int) yr};
		GeneralPath trapezium = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xArray.length);
		trapezium.moveTo(xArray[0], yArray[0]);
		for (int i = 0; i < xArray.length; i++) {
			trapezium.lineTo(xArray[i], yArray[i]);
		}
		trapezium.closePath();
		comp.draw(trapezium);
		comp.fill(trapezium);
		g.setColor(Color.yellow);
		Arc2D.Float arc = new Arc2D.Float((float) xArray[1], (float) yArray[1] - 25,60F, 50F, 0F, 180F, Arc2D.CHORD);
		comp.draw(arc);
		comp.fill(arc);
		weapon.render(g, xr + 36, yr - 9);
	}
	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return health;
	}
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) xr, (int) yr, 100,80);
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
}

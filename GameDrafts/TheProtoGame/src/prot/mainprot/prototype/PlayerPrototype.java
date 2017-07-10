package prot.mainprot.prototype;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;


public class PlayerPrototype extends GamePrototypeObject {
	Weapon weapon;
	Handler handler;
	public PlayerPrototype(float x, float y, ID id,Handler handler, Weapon weapon) {
		super(x, y, id);
		this.weapon = weapon;
		this.handler = handler;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}
	public void tick() {
		 y += velY;
		 x += velX;
	     x = GamePrototype.clamp(x, GamePrototype.WIDTH/2, GamePrototype.WIDTH - 80);
	     y = GamePrototype.clamp(y, 0, GamePrototype.HEIGHT - 100);
	     weapon.tick(x, y);
	     collision();
	}
    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            GamePrototypeObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.FireBallEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 2;
                    handler.object.remove(tempObject);
                }
            }else if(tempObject.getId() == ID.ChargeBallEnemy) {
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 5;
                    handler.object.remove(tempObject);
                }
            }
        }
    }
	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x,(int)y, 32, 32);
		weapon.render(g, x, y);
		
	}
	public int getHealth() {
		return 1;
	}
}

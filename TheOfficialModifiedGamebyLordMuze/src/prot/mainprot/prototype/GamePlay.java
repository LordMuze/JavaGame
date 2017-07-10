package prot.mainprot.prototype;
import java.awt.Graphics;
import java.util.*;
public class GamePlay implements State {
	private GamePrototype game;
	private Handler handler;
	private HUD hud;
	public GamePlay(GamePrototype game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}

	public void tick() {
		// TODO Auto-generated method stub
            if(hud.getScore() == 1) {
                handler.addObject(new PlayerPrototype(GamePrototype.WIDTH/2 - 32,GamePrototype.HEIGHT/2 - 32 ,ID.Player,handler, new GunPrototype(ID.FireBall, handler, new ProjectileFactory())));
                handler.addObject(new Enemy(GamePrototype.WIDTH/2  - 300, 90, ID.EnemyPrototype,handler,new SlayerDracoBasic(ID.FireBallEnemy, handler, new ProjectileFactory())));
            }
            if(hud.getScore() == 200) {
                handler.addObject(new Enemy(GamePrototype.WIDTH/2  - 300, 90, ID.EnemyPrototype,handler,new SlayerDracoBasic(ID.FireBallEnemy, handler, new ProjectileFactory())));
                handler.addObject(new Enemy(GamePrototype.WIDTH/2  - 300, 90, ID.EnemyPrototype,handler,new SlayerDracoBasic(ID.FireBallEnemy, handler, new ProjectileFactory())));

            }
            if(hud.getScore() == 500) {
                handler.addObject(new Torquedo(GamePrototype.WIDTH/2 - 340, 90, ID.EnemyPrototype,handler, new ThreeForkSpear(ID.ChargeBallEnemy, handler, new ProjectileFactory())));
                
            }
            if(hud.getScore() == 1200) {
                handler.addObject(new Fishball(GamePrototype.WIDTH/2 - 320, 120, ID.EnemyPrototype,handler, new Maverick(ID.ChargeBallEnemy, handler, new ProjectileFactory())));
                
            }
            if(HUD.HEALTH == 0) {
            	System.out.println("You died..");
            	System.exit(0);
            }
            removeGameObject();
	}

	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	// disposer
	public void removeGameObject() {
		LinkedList<GamePrototypeObject> gameList = handler.getGameList();
		for(int i = 0; i < gameList.size(); i++){
			if(gameList.get(i).getHealth() == 0) {
				gameList.remove(gameList.get(i));
			}
		}
	}
}

	



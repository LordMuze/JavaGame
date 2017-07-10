package prot.mainprot.prototype;

import java.awt.Color;

public class ProjectileFactory {
	protected GamePrototypeObject createProjectile(float x,float y, ID id) {
		try {
		if (id == ID.FireBall) {
			return new Fireball(x, y, ID.FireBall, 1, Color.orange);
		}else if (id == ID.ChargeBall) {
			return new ChargeBall(x, y, ID.ChargeBall, 1, Color.cyan);
		}else if (id == ID.ChargeBallEnemy) {
			return new ChargeBall(x, y, ID.ChargeBallEnemy, -1, Color.pink);
		}else if (id == ID.FireBallEnemy) {
			return new Fireball(x, y, ID.FireBallEnemy, -1, Color.red);
		}
		} catch (NullPointerException nl) {
			System.err.println("It's either the project object has yet to be instantiated to an actual class object");
			System.err.println("or that you suck");
		}
		System.err.println("Nullified Projectile");
		return null;
		
	}
}

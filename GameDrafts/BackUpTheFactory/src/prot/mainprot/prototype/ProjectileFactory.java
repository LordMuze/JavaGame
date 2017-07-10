package prot.mainprot.prototype;

public class ProjectileFactory {
	protected GamePrototypeObject createProjectile(float x,float y, ID id) {
		try {
		if (id == ID.FireBall) {
			return new Fireball(x, y, ID.FireBall);
		}else if (id == ID.ChargeBall) {
			return new ChargeBall(x, y, ID.ChargeBall);
		}
		} catch (NullPointerException nl) {
			System.err.println("It's either the project object has yet to be instantiated to an actual class object");
			System.err.println("or that you suck");
		}
		System.err.println("Nullified Projectile");
		return null;
		
	}
}

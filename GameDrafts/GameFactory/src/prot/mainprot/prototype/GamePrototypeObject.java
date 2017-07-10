package prot.mainprot.prototype;
import java.awt.*;


public abstract class GamePrototypeObject {
	protected float x, y;
	protected float velX, velY;
	protected ID id;
	public GamePrototypeObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
	// The Getter and setter methods
    public void setY(int y){
        this.y = y;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }

    public void setVelX(int velX){
        this.velX = velX;
    }
    public void setVelY(int velY){
        this.velY = velY;
    }
    public float getVelX(){
        return velX;
    }
    public float getVelY(){
        return velY;
    }
    public void setId(ID id) {
    	this.id = id;
    }
    public ID getId() {
    	return id;
    }
}

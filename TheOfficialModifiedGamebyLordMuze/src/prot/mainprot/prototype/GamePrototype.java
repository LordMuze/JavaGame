package prot.mainprot.prototype;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;





public class GamePrototype extends Canvas implements Runnable {
	
	    private static final long serialVersionUID = 1550691097823471818L;
	    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	    private Thread thread;
	    private boolean running = false;
	    private Handler handler;
	    private State menuState;
	    private State helpState;
	    private State gameState;
	    private State state;
	    private HUD hud;
	    public GamePrototype(){
	    	menuState = new Menu(this);
	    	helpState = new Help(this);
	    	hud = new HUD();
	        handler = new Handler();
	        state = menuState;
	        gameState = new GamePlay(this, handler, hud);
	        this.addKeyListener(new KeyInput(handler));
	        this.addMouseListener((MouseListener) menuState);
	        new Window(WIDTH,HEIGHT,"CrabToCrack", this);
            //handler.addObject(new PlayerPrototype(WIDTH/2 - 32,HEIGHT/2 - 32 ,ID.Player, new GunPrototype(ID.FireBall, handler, new ProjectileFactory())));
            //handler.addObject(new Enemy(WIDTH/2  - 300, HEIGHT/2 - 24, ID.EnemyPrototype));
            //handler.addObject(new BasicEnemy(WIDTH/2 - 300, HEIGHT/2 - 24, ID.EnemyPrototype));
            //handler.addObject(new Torquedo(WIDTH/2 - 340, HEIGHT/2 - 24, ID.EnemyPrototype, new ThreeForkSpear(ID.ChargeBallEnemy, handler, new ProjectileFactory())));
            //handler.addObject(new Fishball(WIDTH/2 - 32, HEIGHT/2 - 32, ID.EnemyPrototype, new Maverick(ID.FireBallEnemy, handler, new ProjectileFactory())));
	    }
	    public synchronized void start(){
	        thread = new Thread(this);
	        thread.start();
	        running = true;
	    }
	    public synchronized void stop(){
	        try{
	            thread.join();
	            running = false;
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	    public void run(){
	        this.requestFocus();
	        long lastTime = System.nanoTime();
	        double amountOfTicks = 60.0;
	        double ns = 1000000000 / amountOfTicks;
	        double delta = 0;
	        long timer = System.currentTimeMillis();
	        int frames = 0;
	        while(running){
	            long now = System.nanoTime();
	            delta += (now - lastTime) / ns;
	            lastTime = now;
	            while(delta >= 1){
	                tick();
	                delta--;
	            }
	            if(running)
	                render();
	            frames++;
	            if(System.currentTimeMillis() - timer > 1000){
	                timer += 1000;
	                System.out.println("FPS: " + frames);
	                frames = 0;
	            }
	        }
	        stop();
	    }
	    private void tick() {
	        handler.tick();
	        state.tick();
	        if(getCurrentState() == getGameState()) {
	        	hud.tick();
	        }
	    }
	    private void render(){
	        BufferStrategy bs = this.getBufferStrategy();
	        if(bs == null){
	            this.createBufferStrategy(3);
	            return;
	        }
	        Graphics g = bs.getDrawGraphics();
	        g.setColor(Color.black);
	        g.fillRect(0, 0, WIDTH, HEIGHT);
	        handler.render(g);
	        state.render(g);
	        if (getCurrentState() == getGameState()) {
	        	hud.render(g);
	        }
	        g.dispose();
	        bs.show();
	    }
	    public static float clamp(float var, float min, float max){
	        if(var >= max)
	            return var = max;
	        else if(var < min)
	            return var = min;
	        else
	            return var;
	    }
	    public void setState(State state) {
	    	this.state = state;
	    }
	    public State getMenuState() {
	    	return menuState;
	    }
	    public State getGameState() {
	    	return gameState;
	    }
	    public State getHelpState() {
	    	return helpState;
	    }
	    public State getCurrentState() {
	    	return state;
	    }
	    public static void main(String args[]){
	        new GamePrototype();
	    }
	}

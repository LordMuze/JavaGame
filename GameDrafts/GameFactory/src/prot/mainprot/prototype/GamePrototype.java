package prot.mainprot.prototype;
import java.awt.*;
import java.awt.image.BufferStrategy;





public class GamePrototype extends Canvas implements Runnable {
	
	    private static final long serialVersionUID = 1550691097823471818L;
	    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	    private Thread thread;
	    private boolean running = false;
	    private Handler handler;
	    public GamePrototype(){
	        handler = new Handler();
	        this.addKeyListener(new KeyInput(handler));
	        new Window(WIDTH,HEIGHT,"CrabToCrack", this);
            handler.addObject(new PlayerPrototype(WIDTH/2 - 32,HEIGHT/2 - 32 ,ID.Player, new GunPrototype(ID.FireBall, handler)));


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
	    private void tick(){
	        handler.tick();


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
	    public static void main(String args[]){
	        new GamePrototype();
	    }
	}


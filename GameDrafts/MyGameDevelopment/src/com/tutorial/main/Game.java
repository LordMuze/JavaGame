package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * Created by LENOVO on 4/4/2017.
 */
public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1550691097823471818L;
    private static final int WIDTH = 640, HEIGHT = WIDTH/12*9;// Set a 16:9 ratio
    private Random r;
    private Thread thread; // entire game is going to run
    // under this thread
    private boolean running = false;
    private Handler handler;
    public Game() {
        new Window(WIDTH, HEIGHT, "Let's Build A Game", this);
        handler = new Handler();
        r = new Random();
        for(int i = 0; i < 50; i++) {
            handler.addObject(new Player(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Player));
        }

    }
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
        // thread will initiate..

    }
    public synchronized  void stop() {
        try {
            thread.join(); // killing and stopping the thread
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void run() {
        // THE GAME LOOP

            long lastTime = System.nanoTime();  // system past time
            double amountOfTicks = 60.0;
            double ns = 1000000000 / amountOfTicks; // multiple of ticks
            double delta = 0;
            long timer = System.currentTimeMillis(); // system current time in milliseconds
            int frames = 0; // frames
            while(running)
            { long now = System.nanoTime(); // system current nanoTime
                delta += (now - lastTime) / ns; // synchronizing system present with the past time(gap) and divided by multiple of ticks to give us responsivness of hardware and network
                // im not so sure
                lastTime = now; // synchronzed, else returns the loop false..
                while(delta >=1) {
                    tick();
                    delta--;
                } // updates through calculating frames of previous session// or if its in network, then it will get through the network to update i guess.
                if(running) {
                    render();
                }
                frames++;
                if(System.currentTimeMillis() - timer > 1000) {
                    timer += 1000;
                    System.out.println("FPS: "+ frames);
                    frames = 0;
                }
            }
            stop();
        }
        private void tick() {
        handler.tick();

    }
    private void render() {
        //buffer strategy to reduce fps
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            //create three buffer strategies
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


    public static void main(String[] args) {
        new Game();
    }


}

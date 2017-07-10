package prot.mainprot.prototype;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Menu extends MouseAdapter implements State {
    private GamePrototype game;
    public Menu(GamePrototype game) {
        this.game = game;
    }
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        //play button
            if (State.mouseOver(mx, my, 210, 150, 200, 64)) {
                game.setState(game.getGameState());
                game.removeMouseListener(this);
            }
            //help button
            if (State.mouseOver(mx, my, 210, 250, 200, 64)) {
            	game.removeMouseListener(this);
                game.setState(game.getHelpState());
                game.addMouseListener((MouseAdapter) game.getHelpState());
            }
            //quit button
            if (State.mouseOver(mx, my, 210, 350, 200, 64)) {
                System.exit(1);
            }
        }
            //back button
/*            if (game.getState().getStateNumber() == 2) {
                if (mouseOver(mx, my, 210, 350, 200, 64)) {
                    game.setState(this);
                    return;// return back to the if statements outside this if statements
                }
            } */

    
    public void mouseReleased(MouseEvent e) {

    }
    /*private boolean mouseOver(int mx, int my, int x, int y,int width, int height) {
        if(mx > x && mx < x + width) {
            if(my > y && my < y + height) {
                return true;
            } else return false;
        }else return false; // if mouse position is in between x and y corners of the menu buttons, return true..
    } */
    public void tick() {

    }
    public void render(Graphics g) {


            Font font = new Font("arial", 1, 50);
            g.setFont(font);
            g.setColor(Color.orange);
            g.drawString("Menu", 240, 70);

            g.setColor(Color.green);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Play", 270, 190);

            g.setColor(Color.WHITE);
            g.drawRect(210, 250, 200, 64);
            g.drawString("Help", 270, 290);

            g.setColor(Color.red);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 270, 390);

        }

    }

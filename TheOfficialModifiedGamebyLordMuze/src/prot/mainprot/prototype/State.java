package prot.mainprot.prototype;
import java.awt.*;
public interface State {
	public void tick();
	public void render(Graphics g);
    static boolean mouseOver(int mx, int my, int x, int y,int width, int height) {
        if(mx > x && mx < x + width) {
            if(my > y && my < y + height) {
                return true;
            } else return false;
        }else return false; // if mouse position is in between x and y corners of the menu buttons, return true..
    }
}

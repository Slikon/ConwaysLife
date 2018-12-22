

package slavik;
import java.awt.Graphics;
import java.awt.Rectangle;



public abstract class AbstractCell extends Rectangle{
    private boolean alive;
    public AbstractCell(int x, int y, int size){
        this.alive = false;
        setBounds(x * size, y * size,size,size);
    }
    public abstract void render(Graphics g);
    public boolean is_alive(){
        return this.alive;
    }
    public void set_alive(boolean b){
        this.alive = b;
    }
}

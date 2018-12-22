package slavik;
import java.awt.*;

import java.awt.Color;
import java.awt.Graphics;
import slavik.AbstractCell;



public class BlueCell extends AbstractCell {


    public BlueCell (int x, int y, int size){
        super(x, y, size);
        //setBounds(x * Main.blockSize, y * Main.blockSize,Main.blockSize,Main.blockSize);

    }

    public void render(Graphics g){

        g.setColor(Color.BLUE);
        if(this.is_alive()){
            g.fillRect(x,y,width,height);
        }
    }


}

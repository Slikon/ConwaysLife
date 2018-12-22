package slavik;
import java.applet.Applet;
import java.awt.*;

import javax.swing.JFrame;



public class Main extends Applet implements Runnable {

    public static String title = "Kulyk_GameOfLife";
    public static int width = 1000;
    public static int height = 1000;
    public static int blockSize = 10;
    public static Main instance;

    public static boolean isRunning = false;

    public static Graphics g;
    public static Image screen;

    public static Level level;

    //Thread control
    public void start(){
        init();
        isRunning = true;
        Thread th = new Thread(this);
        th.start();
    }
    //Initialize the screen picture
    public void init(){
        screen = createVolatileImage(width, height);
        level = new Level(instance);
    }
    //Process of running
    public void run(){
        while (isRunning){
            tick();
            render(g);
            try {
                Thread.sleep(50);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    //Updating the screen per level
    private void tick(){
        width = getWidth();
        height = getHeight();
        level.tick();
    }

    //rendering the screen per level
    public void render(Graphics g){

        screen = createImage(width, height);
        g = screen.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0,width,height);


        level.render(g);

        g = getGraphics();
        g.drawImage(screen,0,0, null);


    }

    public static JFrame frame;



    public static void main(String[] args) {
        instance = new Main();

        frame = new JFrame();
        frame.add(instance);
        frame.setSize(width, height);
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        instance.start();
    }

    public Main get_instance(){
        return instance;
    }
}

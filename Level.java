package slavik;
import java.awt.*;
import java.util.Random;
import slavik.AbstractCell;

public class Level {

    public static AbstractCell[][] block;
    public static AbstractCell[][] block2;

    public Level(Main instance) {
        block = new AbstractCell[instance.width / instance.blockSize][instance.height / instance.blockSize];
        block2 = new AbstractCell[instance.width / instance.blockSize][instance.height / instance.blockSize];
        Random r = new Random();
        for (int x = 0; x < block.length; x++) {
            for (int y = 0; y < block.length; y++) {
                switch (r.nextInt(3)) {
                    case 0:
                        block[x][y] = new GreenCell(x, y, instance.blockSize);
                        block2[x][y] = new GreenCell(x, y, instance.blockSize);
                        break;
                    case 1:
                        block[x][y] = new RedCell(x, y, instance.blockSize);
                        block2[x][y] = new RedCell(x, y, instance.blockSize);
                        break;
                    case 2:
                        block[x][y] = new BlueCell(x, y, instance.blockSize);
                        block2[x][y] = new BlueCell(x, y, instance.blockSize);
                        break;
                }

                block[x][y].set_alive(r.nextBoolean());

            }
        }
    }

    public void tick() {
        for (int x = 0; x < block.length; x++) {
            for (int y = 0; y < block.length; y++) {
                block2[x][y].set_alive(block[x][y].is_alive());
            }
        }
        for (int x = 0; x < block.length; x++) {
            for (int y = 0; y < block.length; y++) {
                block[x][y].set_alive(false);
            }
        }
        for (int x = 0; x < block.length; x++) {
            for (int y = 0; y < block.length; y++) {
                int n = 0;

                try {
                    if (block2[x - 1][y].is_alive()) {
                        n++;
                    }
                } catch (Exception e) {

                }

                try {
                    if (block2[x - 1][y - 1].is_alive()) {
                        n++;
                    }
                } catch (Exception e) {

                }

                try {
                    if (block2[x][y - 1].is_alive()) {
                        n++;
                    }
                } catch (Exception e) {

                }

                try {
                    if (block2[x + 1][y - 1].is_alive()) {
                        n++;
                    }
                } catch (Exception e) {

                }

                try {
                    if (block2[x + 1][y].is_alive()) {
                        n++;
                    }
                } catch (Exception e) {

                }

                try {
                    if (block2[x + 1][y + 1].is_alive()) {
                        n++;
                    }
                } catch (Exception e) {

                }

                try {
                    if (block2[x][y + 1].is_alive()) {
                        n++;
                    }
                } catch (Exception e) {

                }

                try {
                    if (block2[x - 1][y + 1].is_alive()) {
                        n++;
                    }
                } catch (Exception e) {

                }

                boolean b = false;

                if (block2[x][y].is_alive()) {
                    switch (n) {
                        case 0:
                        case 1:
                            b = false;
                            break;
                        case 2:
                        case 3:
                            b = true;
                            break;

                        default:
                            b = false;
                            break;
                    }
                } else {
                    switch (n) {

                        case 3:
                            b = true;
                            break;
                        default:
                            b = false;
                            break;
                    }

                }

                block[x][y].set_alive(b);

            }
        }
    }

    public void render(Graphics g) {
        for (int x = 0; x < block.length; x++) {
            for (int y = 0; y < block.length; y++) {
                block[x][y].render(g);
            }
        }
    }
}

/*
    for(int x = 0;  x < block.length; x++){
        for(int y = 0;  y < block.length; y++){

        }
        }
 */

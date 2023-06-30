package object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Coin extends SuperObject {
    GamePanel gp;

    public Coin(GamePanel gp) {

        this.gp = gp;
        name = "Coin";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/pngwing.com.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        type = type_pickUponly;
    }
public int value = 1;

    @Override
    public void use() {
        gp.player.coin += value;
    }
}
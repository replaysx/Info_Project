package object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Heart extends SuperObject{
    GamePanel gp;

    public Heart(GamePanel gp) {
        name = "Heart";

        try {
            image3 = ImageIO.read(getClass().getResourceAsStream("/objects#/pixil-frame-0(11).png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/objects#/pixil-frame-0(9).png"));
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/pixil-frame-0(8).png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

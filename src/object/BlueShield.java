package object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BlueShield extends SuperObject{
    GamePanel gp;
    public BlueShield(GamePanel gp){
        this.gp = gp;

        name = "BlueShield";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/playerImages/sword_normal.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        defenseValue = 2;
        description = "["+name+"] \nDas ist ein Schwert";

    }
}

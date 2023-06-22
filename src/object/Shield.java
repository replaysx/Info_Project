package object;

import Main.GamePanel;
import entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Shield extends SuperObject {
    GamePanel gp;
    public Shield(GamePanel gp){
        this.gp = gp;
        name = "DefaultSword";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/playerImages/shield_wood.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        defenseValue = 1;
        description = "["+name+"]\n Das ist ein Schwert";
        rarity = new Color(255, 211, 0);
        type = type_shield;
    }
}

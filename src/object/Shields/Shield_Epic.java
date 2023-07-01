package object.Shields;

import Main.GamePanel;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Shield_Epic extends SuperObject {
    GamePanel gp;
    public Shield_Epic(GamePanel gp){
        this.gp = gp;
        name = "Epic Shield";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/shield_blue.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        defenseValue = 2;
        coinValue = 10;
        rarity = epic;
        description = "["+name+"]\nDefense: "+defenseValue;
        type = type_shield;
    }
}

package object.Shields;

import Main.GamePanel;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Shield_Wood extends SuperObject {
    GamePanel gp;
    public Shield_Wood(GamePanel gp){
        this.gp = gp;
        name = "Default Shield";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/shield_Common.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        defenseValue = 0;
        rarity = common;
        description = "["+name+"]\nDefense: "+defenseValue;
        type = type_shield;
    }
}

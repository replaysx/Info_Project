package object.Shields;

import Main.GamePanel;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Shield_Legendary extends SuperObject {
    GamePanel gp;
    public Shield_Legendary(GamePanel gp){
        this.gp = gp;
        name = "Legendary Shield";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/Schield_Legendary.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        defenseValue = 3;
        coinValue = 15;
        rarity = legendary;
        description = "["+name+"]\nDefense: "+defenseValue;
        type = type_shield;
    }
}

package object.Shields;

import Main.GamePanel;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Shield extends SuperObject {
    GamePanel gp;
    public Shield(GamePanel gp){
        this.gp = gp;
        name = "Rare Shield";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/shield_wood.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        defenseValue = 1;
        coinValue = 5;
        rarity = rare;
        description = "["+name+"]\nDefense: "+defenseValue;
        type = type_shield;
    }
}

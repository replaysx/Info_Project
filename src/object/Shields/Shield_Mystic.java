package object.Shields;

import Main.GamePanel;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Shield_Mystic extends SuperObject {
    GamePanel gp;
    public Shield_Mystic(GamePanel gp){
        this.gp = gp;
        name = "Mystic Shield";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/Shield_Mystic.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        defenseValue = 4;
        coinValue = 20;
        rarity = mystic;
        description = "["+name+"]\nDefense: "+defenseValue;
        type = type_shield;
    }
}

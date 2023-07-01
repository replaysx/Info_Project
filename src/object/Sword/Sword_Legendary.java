package object.Sword;

import Main.GamePanel;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Sword_Legendary extends SuperObject {
    GamePanel gp;
    public Sword_Legendary(GamePanel gp){

        this.gp = gp;
        name = "Legendary Sword";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/Sword_Legendary.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        attackValue = 4;
        coinValue = 15;
        description = "["+name+"] \nAttack: "+attackValue;
        attackWidth = 36;
        attackHeight = 36;
        type = type_weapon;
        rarity = legendary;
    }
}

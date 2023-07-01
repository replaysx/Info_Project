package object.Sword;

import Main.GamePanel;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Sword_Mystic extends SuperObject {
    GamePanel gp;
    public Sword_Mystic(GamePanel gp){

        this.gp = gp;
        name = "Mystic Sword";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/Sword_Mystic.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        attackValue = 5;
        coinValue = 20;
        description = "["+name+"] \nAttack: "+attackValue;
        attackWidth = 36;
        attackHeight = 36;
        type = type_weapon;
        rarity = mystic;
    }

}

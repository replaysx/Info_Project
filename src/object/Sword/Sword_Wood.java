package object.Sword;

import Main.GamePanel;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Sword_Wood extends SuperObject {
    GamePanel gp;
    public Sword_Wood(GamePanel gp){

        this.gp = gp;
        name = "Default Sword";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects#/Sword_Wood.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        attackValue = 1;
        description = "["+name+"] \nAttack: "+attackValue;
        attackWidth = 36;
        attackHeight = 36;
        type = type_weapon;
        rarity = common;
    }
}
